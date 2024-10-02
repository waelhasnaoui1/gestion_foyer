package com.example.gestionfoyer.repositories.auth;


import com.example.gestionfoyer.entities.auth.RefreshToken;
import com.example.gestionfoyer.entities.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {

    Optional<RefreshToken> findByUser(User user);
    Optional<RefreshToken> findByToken(String token);

    void deleteByUser(User user);

}
