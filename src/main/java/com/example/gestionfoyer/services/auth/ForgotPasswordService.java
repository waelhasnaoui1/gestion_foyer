package com.example.gestionfoyer.services.auth;

public interface ForgotPasswordService {

    String forgotPassword(String email);
    String resetPassword(String token, String newPassword);
    String getGeneratedToken(String email);
}
