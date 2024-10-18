package com.example.gestionfoyer.services.auth;

import com.example.gestionfoyer.dto.auth.SignUpRequest;
import com.example.gestionfoyer.dto.auth.SingninRequest;
import com.example.gestionfoyer.dto.auth.response.JwtAuthenticationResponse;

public interface AuthenticationService {

    JwtAuthenticationResponse SignUp(SignUpRequest request);
    JwtAuthenticationResponse SignIn(SingninRequest request);



}
