import { ApplicationConfig, importProvidersFrom, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
// import { TranslateModule } from ""
import { routes } from './app.routes';
import { provideHttpClient, withInterceptors } from '@angular/common/http';
import { provideNetlifyLoader } from '@angular/common';
import { authInterceptor } from './shared/interceptors/auth.interceptor';
import { provideAnimations } from '@angular/platform-browser/animations';

import { provideToastr } from 'ngx-toastr';
import { UUIDShortenerPipe } from './shared/pipes/uuidShortener.pipe';

// Global konfigürasyon yapısı (kod için)
export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(withInterceptors([authInterceptor])), // artık tüm uygulama http client kullanabilir
    provideAnimations(),
    provideToastr(),
    UUIDShortenerPipe,
    // importProvidersFrom([TranslateModule.forRoot({
    //   loader: {
    //     provide: TranslateLoader,
    //     useFactory:
    //   }
    // })])
  ],
};

// httpclient,
