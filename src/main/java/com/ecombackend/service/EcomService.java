package com.ecombackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ecombackend.entity.EcomUser;
import com.ecombackend.repository.EcomRepository;

@Service
public class EcomService {
	
	@Autowired
	public EcomRepository ecomRepository;
	
	public EcomUser saveUser(EcomUser ecomUser) {
		return ecomRepository.save(ecomUser);
	}
	
	public List<EcomUser> getUsers() {
		return ecomRepository.findAll();
	}
	
	public EcomUser getUserByEmail(String email) {
		return ecomRepository.findByEmail(email);
	}
	
	public EcomUser getUsersByPhone(int phone) {
		return ecomRepository.findByPhone(phone);
	}
	
	public EcomUser updateEcomUser(EcomUser ecomUser) {
		EcomUser existingUser = ecomRepository.findById(ecomUser.getId()).orElse(null);
		existingUser.setPassword(ecomUser.getPassword());
		return ecomRepository.save(existingUser);
	}
}
