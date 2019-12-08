package com.itss.parking.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.itss.parking.entity.User;
import com.itss.parking.repository.UserRepository;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

	private TokenService tokenService;

	private UserRepository repository;

	public JWTAuthenticationFilter(TokenService tokenService, UserRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = retrieveToken(request);

		boolean isValid = tokenService.isValidToken(token);

		if (isValid) {
			authClient(token);
		}

		filterChain.doFilter(request, response);
	}

	private void authClient(String token) {
		Long userId = tokenService.getUserId(token);
		Optional<User> optUser = this.repository.findById(userId);

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(optUser.get(),
				null, optUser.get().getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String retrieveToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7, token.length());
	}
}
