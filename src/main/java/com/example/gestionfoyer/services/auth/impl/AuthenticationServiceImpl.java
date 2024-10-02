package com.example.gestionfoyer.services.auth.impl;


import com.example.gestionfoyer.dao.auth.SignUpRequest;
import com.example.gestionfoyer.dao.auth.SingninRequest;
import com.example.gestionfoyer.dao.auth.response.JwtAuthenticationResponse;
import com.example.gestionfoyer.entities.auth.Role;
import com.example.gestionfoyer.entities.auth.User;
import com.example.gestionfoyer.repositories.auth.UserRepository;
import com.example.gestionfoyer.services.auth.AuthenticationService;
import com.example.gestionfoyer.services.auth.JwtService;
import com.example.gestionfoyer.services.auth.RefreshTokenService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    private final RefreshTokenService refreshTokenService;

    @Override
    public JwtAuthenticationResponse SignUp (SignUpRequest request) {

        // Create a new User entity and set its properties
       // User user = new User();
      //  user.setFirstName(request.getFirstName());
       // user.setLastName(request.getLastName());
      //  user.setEmail(request.getEmail());
       // user.setPassword(passwordEncoder.encode(request.getPassword()));
     //   user.setRole(Role.USER);

        // Save the user entity to the database
      //  userRepository.save(user);
        var user= User.builder().firstName(request.getFirstName()).lastName(request.getLastName()).email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())).role(Role.USER).build();
        userRepository.save(user);
        var jwt=jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).refreshToken(refreshToken.getToken()).build();

    }

    @Override
    public JwtAuthenticationResponse SignIn(SingninRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
//        var jwt = jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(user);

        return JwtAuthenticationResponse.builder().token(refreshToken.getToken()).
                 userId(user.getId()) // Set the userId
                .refreshToken(refreshToken.getToken())
                .role(user.getRole().name()) // Set the role
                .build();

    }


}
