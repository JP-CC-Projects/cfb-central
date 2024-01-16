package com.jpcc.CFBProject.security.securityrepository;


import java.util.Optional;

import com.jpcc.CFBProject.security.securitydomain.RefreshToken;
import com.jpcc.CFBProject.security.securitydomain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;


@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(User user);
}