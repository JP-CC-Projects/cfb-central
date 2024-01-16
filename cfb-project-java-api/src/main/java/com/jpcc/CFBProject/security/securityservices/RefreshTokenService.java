package com.jpcc.CFBProject.security.securityservices;

import com.jpcc.CFBProject.request.RefreshTokenRequest;
import com.jpcc.CFBProject.security.securitydomain.*;
import com.jpcc.CFBProject.security.securityrepository.*;
import com.jpcc.CFBProject.security.JwtServiceImpl;
import com.jpcc.CFBProject.security.securitydomain.RefreshToken;
import com.jpcc.CFBProject.security.securityrepository.RefreshTokenRepository;
import com.jpcc.CFBProject.security.securityrepository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {
	@Value("${token.refreshExpiration}")
	private Long refreshTokenDurationMs;

	private RefreshTokenRepository refreshTokenRepository;
	private UserRepository userRepository;
	private JwtServiceImpl jwtService;

	public RefreshTokenService(RefreshTokenRepository refreshTokenRepository, UserRepository userRepository,
			JwtServiceImpl jwtService) {
		super();
		this.refreshTokenRepository = refreshTokenRepository;
		this.userRepository = userRepository;
		this.jwtService = jwtService;
	}

	public Optional<RefreshToken> findByToken(String token) {
		return refreshTokenRepository.findByToken(token);
	}

	public RefreshToken createRefreshToken(Integer userId) {
		RefreshToken refreshToken = new RefreshToken();

		refreshToken.setUser(userRepository.findById(userId).get());
		refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
		refreshToken.setToken(UUID.randomUUID().toString());

		refreshToken = refreshTokenRepository.save(refreshToken);
		return refreshToken;
	}

	public RefreshToken verifyExpiration(RefreshToken token) {
		if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
			refreshTokenRepository.delete(token);

			throw new IllegalStateException(
					"Refresh token " + token.getToken() + " was expired. Please make a new signin request");
		}

		return token;
	}

	@Transactional
	public int deleteByUserId(Integer userId) {
		return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
	}

	public String createNewAccessToken(RefreshTokenRequest refreshTokenRequest) {
		Optional<RefreshToken> refreshTokenOpt = refreshTokenRepository.findByToken(refreshTokenRequest.refreshToken());
		String accessToken = refreshTokenOpt
				.map(this::verifyExpiration)
				.map(refreshToken -> jwtService.generateToken(new HashMap<>(), refreshToken.getUser()))
				.orElseThrow(() -> new IllegalArgumentException("Refresh token not found"));
		return accessToken;
	}
}