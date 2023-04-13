package com.ecombackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecombackend.entity.EcomUser;

public interface EcomRepository extends JpaRepository<EcomUser, Integer> {

	EcomUser findByEmail(String email);
	EcomUser findByPhone(int phone);

}
