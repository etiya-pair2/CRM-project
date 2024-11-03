@echo off
chcp 65001>nul

setlocal enabledelayedexpansion

:: GitHub pull islemi sorusu
set /p pull_option="Github'dan guncellemeleri cekmek istiyor musunuz? Evet icin 1, Hayir icin 2 giriniz: "

if "%pull_option%"=="1" (
    echo GitHub'dan guncellemeler cekiliyor...
    git pull origin main
    if errorlevel 1 (
        echo GitHub'dan guncellemeler alinamadi. Islemi iptal ediyorum...
        exit /b 1
    )
)

echo Mevcut containerlar durduruluyor...
podman compose -f podman-compose.yml down 

set /p arg="Lütfen bir argüman girin: Eğer yeni değişiklikler varsa 1, kod hala aynı ise 2 giriniz: "

if "%arg%"=="1" (
    echo Yeni değişiklikler uygulanarak sistem ayağa kaldırılıyor.. lütfen bekleyiniz..
    podman compose -f podman-compose.yml up --build -d
) else if "%arg%"=="2" (
    echo Sistem ayağa kaldırılıyor.. lütfen bekleyiniz..
    podman compose -f podman-compose.yml up -d
) else (
    echo Geçersiz argüman. Lütfen 1 veya 2 girin.
    pause
    exit /b 1
)

:: Container'ların başlaması için bir bekleme süresi
echo Container'ların başlatılması bekleniyor...
timeout /t 15 /nobreak >nul

:: Frontend, backend ve diğer servislerin portlarını dinamik olarak alıyoruz
for /f "tokens=2 delims=: " %%a in ('podman ps --filter "name=front" --format "{{.Ports}}"') do (
    for /f "tokens=1 delims=->" %%b in ("%%a") do set FRONTEND_PORT=%%b
)

for /f "tokens=2 delims=: " %%a in ('podman ps --filter "name=gateway" --format "{{.Ports}}"') do (
    for /f "tokens=1 delims=->" %%b in ("%%a") do set GATEWAY_PORT=%%b
)

for /f "tokens=2 delims=: " %%a in ('podman ps --filter "name=configserver" --format "{{.Ports}}"') do (
    for /f "tokens=1 delims=->" %%b in ("%%a") do set CONFIGSERVER_PORT=%%b
)

for /f "tokens=2 delims=: " %%a in ('podman ps --filter "name=eureka" --format "{{.Ports}}"') do (
    for /f "tokens=1 delims=->" %%b in ("%%a") do set EUREKA_PORT=%%b
)

:: Eğer portlar boşsa hata ile karşılaşmamak için bir kontrol yapıyoruz
if "%FRONTEND_PORT%"=="" (
    echo Frontend portu bulunamadı.
)

if "%GATEWAY_PORT%"=="" (
    echo Backend gateway portu bulunamadı.
)

if "%CONFIGSERVER_PORT%"=="" (
    echo ConfigServer portu bulunamadı.
)

if "%EUREKA_PORT%"=="" (
    echo Eureka portu bulunamadı.
)

:: Port bilgilerini ekrana renkli olarak yazdırıyoruz
powershell -Command "& {Write-Host 'Frontend portu: %FRONTEND_PORT%' -ForegroundColor Red}"
powershell -Command "& {Write-Host 'Backend gateway portu: %GATEWAY_PORT%' -ForegroundColor Green}"
powershell -Command "& {Write-Host 'ConfigServer portu: %CONFIGSERVER_PORT%' -ForegroundColor Yellow}"
powershell -Command "& {Write-Host 'Eureka portu: %EUREKA_PORT%' -ForegroundColor Cyan}"

powershell -Command "& {Write-Host 'Frontend : http://localhost:%FRONTEND_PORT%' -ForegroundColor Red}"
powershell -Command "& {Write-Host 'Backend : http://localhost:%GATEWAY_PORT%/swagger-ui/index.html' -ForegroundColor Green}"
powershell -Command "& {Write-Host 'ConfigServer : http://localhost:%CONFIGSERVER_PORT%' -ForegroundColor Yellow}"
powershell -Command "& {Write-Host 'Eureka : http://localhost:%EUREKA_PORT%' -ForegroundColor Cyan}"

pause
exit /b 0
