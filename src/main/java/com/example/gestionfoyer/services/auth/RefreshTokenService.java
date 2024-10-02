package com.example.gestionfoyer.services.auth;

import com.example.gestionfoyer.entities.auth.RefreshToken;
import com.example.gestionfoyer.entities.auth.User;

import java.util.Optional;

public interface RefreshTokenService {

    public RefreshToken createRefreshToken(User user);
    public Optional<RefreshToken> findByToken(String token);
    public RefreshToken verifyExpiration(RefreshToken token);
    public void deleteByUser(User user);
}
