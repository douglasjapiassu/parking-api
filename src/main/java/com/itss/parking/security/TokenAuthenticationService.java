package com.itss.parking.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itss.parking.entity.User;
import com.itss.parking.repository.UserRepository;

@Service
public class TokenAuthenticationService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optUser = this.userRepository.findByUsername(username);
		if (optUser.isPresent()) {
			return optUser.get();
		}

		throw new UsernameNotFoundException("Invalid data");
	}

}
