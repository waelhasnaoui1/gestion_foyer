package com.example.gestionfoyer.services.auth;

import com.example.gestionfoyer.dao.auth.SignUpRequest;
import com.example.gestionfoyer.dao.auth.SingninRequest;
import com.example.gestionfoyer.dao.auth.response.JwtAuthenticationResponse;

public interface AuthenticationService {

    JwtAuthenticationResponse SignUp(SignUpRequest request);
    JwtAuthenticationResponse SignIn(SingninRequest request);



}
