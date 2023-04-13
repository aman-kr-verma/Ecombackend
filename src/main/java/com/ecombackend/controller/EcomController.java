package com.ecombackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecombackend.entity.EcomUser;
import com.ecombackend.service.EcomService;


@RestController
@RequestMapping()
@CrossOrigin(origins = "*")
public class EcomController {
	
	@Autowired
	public EcomService ecomService;
	
	@PostMapping("/signup")
	public EcomUser addUser(@RequestBody EcomUser ecomUser) {
		return ecomService.saveUser(ecomUser);
	}
	
	@GetMapping("/users")
	public List<EcomUser> findUsers() {
		return ecomService.getUsers();
	}
	
	@GetMapping("/userByEmail/{email}")
	public EcomUser findUserByEmail(@PathVariable String email) {
		return ecomService.getUserByEmail(email);
	}
	
	@GetMapping("/userByPhone/{phone}")
	public EcomUser findUsersByPhone(@PathVariable int phone) {
		return ecomService.getUsersByPhone(phone);
	}
	
	
	@PutMapping("/update")
	public EcomUser updateEcomUserPassword(@RequestBody EcomUser ecomUser) {
		return ecomService.updateEcomUser(ecomUser);
	}
}
