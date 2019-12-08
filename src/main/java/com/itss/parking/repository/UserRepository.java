package com.itss.parking.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.itss.parking.entity.User;

@Repository
public interface UserRepository extends IGenericRepository<User, Long>{
	
	Optional<User> findByUsername(String email);

}
