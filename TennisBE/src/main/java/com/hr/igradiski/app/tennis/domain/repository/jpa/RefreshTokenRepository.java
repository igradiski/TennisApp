package com.hr.igradiski.app.tennis.domain.repository.jpa;

import com.hr.igradiski.app.tennis.domain.RefreshToken;
import com.hr.igradiski.app.tennis.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    @Override
    Optional<RefreshToken> findById(Long id);

    Optional<RefreshToken> findByToken(String token);

    RefreshToken findByUser(User user);
}
