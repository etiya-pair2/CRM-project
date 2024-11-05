package com.etiya.identityservice;

import com.etiya.identityservice.dto.Auth.LoginRequest;
import com.etiya.identityservice.dto.Auth.RegisterRequest;
import com.etiya.identityservice.dto.Auth.TokenResponse;
import com.etiya.identityservice.entity.User;
import com.etiya.identityservice.rules.AuthBusinessRules;
import com.etiya.identityservice.service.abstracts.UserService;
import com.etiya.identityservice.service.concretes.AuthServiceImpl;
import io.github.sabaurgup.exceptions.type.BusinessException;
import io.github.sabaurgup.security.BaseJwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class AuthServiceImplTest {


    @InjectMocks
    private AuthServiceImpl authServiceImpl;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserService userService;

    @Mock
    private BaseJwtService baseJwtService;

    @Mock
    private AuthBusinessRules authBusinessRules;

    @Mock
    private UserDetails userDetails;

    @Mock
    private User user;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLogin_Success() {
        // Given
        String email = "test@example.com";
        String password = "password";
        String encodedPassword = "encodedPassword";
        LoginRequest loginRequest = new LoginRequest(email, password);

        when(userService.loadUserByUsername(email)).thenReturn(userDetails);
        when(userDetails.getPassword()).thenReturn(encodedPassword);
        when(passwordEncoder.matches(password, encodedPassword)).thenReturn(true);
        when(baseJwtService.generateToken(userDetails.getUsername())).thenReturn("generatedToken");

        // When
        TokenResponse tokenResponse = authServiceImpl.login(loginRequest);

        // Then
        assertNotNull(tokenResponse);
        assertTrue(tokenResponse.isSuccess());
        assertEquals("generatedToken", tokenResponse.getToken());
        verify(userService).loadUserByUsername(email);
        verify(passwordEncoder).matches(password, encodedPassword);
        verify(baseJwtService).generateToken(userDetails.getUsername());
    }

    @Test
    void testLogin_Failure_InvalidPassword() {
        // Given
        String email = "test@example.com";
        String password = "password";
        String encodedPassword = "encodedPassword";
        LoginRequest loginRequest = new LoginRequest(email, password);

        when(userService.loadUserByUsername(email)).thenReturn(userDetails);
        when(userDetails.getPassword()).thenReturn(encodedPassword);
        when(passwordEncoder.matches(password, encodedPassword)).thenReturn(false);

        // When & Then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authServiceImpl.login(loginRequest);
        });
        assertEquals("E-posta veya şifre hatalı.", exception.getMessage());
    }
    @Test
    void testRegister_Success() {
        // Given
        String email = "test@example.com";
        String password = "password";
        String encodedPassword = "encodedPassword";
        RegisterRequest registerRequest = new RegisterRequest(email, password, "John", "Doe","12345678900"  );

        doNothing().when(authBusinessRules).checkIfEmailExist(email);
        when(passwordEncoder.encode(password)).thenReturn(encodedPassword);
        when(userService.create(any(User.class))).thenReturn(user);
        when(baseJwtService.generateToken(user.getUsername())).thenReturn("generatedToken");

        // When
        TokenResponse tokenResponse = authServiceImpl.register(registerRequest);

        // Then
        assertNotNull(tokenResponse);
        assertTrue(tokenResponse.isSuccess());
        assertEquals("generatedToken", tokenResponse.getToken());
        verify(authBusinessRules).checkIfEmailExist(email);
        verify(passwordEncoder).encode(password);
        verify(userService).create(any(User.class));
        verify(baseJwtService).generateToken(user.getUsername());
    }

    @Test
    void testRegister_EmailAlreadyExists() {
        // Given
        String email = "test@example.com";
        String password = "password";
        RegisterRequest registerRequest = new RegisterRequest(email, password, "John", "Doe", "12345678900");

        // Mocking the behavior of checkIfEmailExist to throw BusinessException if email already exists
        doThrow(new BusinessException("USER_EMAIL_ALREADY_EXISTS")).when(authBusinessRules).checkIfEmailExist(email);

        // When & Then: E-posta zaten mevcut olduğunda BusinessException fırlatılmalı
        BusinessException exception = assertThrows(BusinessException.class, () -> {
            authServiceImpl.register(registerRequest);
        });

        // Hata mesajını kontrol et
        assertEquals("USER_EMAIL_ALREADY_EXISTS", exception.getMessage());

        // Verifications: checkIfEmailExist metodu çağrıldı
        verify(authBusinessRules).checkIfEmailExist(email);

        // Verifying that no other interactions occur (other methods should not be called)
        verifyNoInteractions(passwordEncoder, userService, baseJwtService);
    }

}
