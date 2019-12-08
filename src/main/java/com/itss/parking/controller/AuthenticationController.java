package com.itss.parking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itss.parking.dto.Login;
import com.itss.parking.dto.Token;
import com.itss.parking.security.TokenService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/auth")
@ApiResponses(value = { @ApiResponse(code = 401, message = "You dont have permission to access"),
		@ApiResponse(code = 500, message = "Will throw exception"), })
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<Token> autenticar(@RequestBody @Valid Login form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();

		try {
			Authentication authenticate = this.authenticationManager.authenticate(dadosLogin);
			String token = tokenService.generateToken(authenticate);
			return ResponseEntity.ok(new Token(token, "Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

}
