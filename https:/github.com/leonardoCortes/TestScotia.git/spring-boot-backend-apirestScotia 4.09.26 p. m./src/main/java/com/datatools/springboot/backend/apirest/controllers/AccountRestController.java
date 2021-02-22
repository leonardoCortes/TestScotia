package com.datatools.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.datatools.springboot.backend.apirest.models.entity.Account;
import com.datatools.springboot.backend.apirest.models.services.IClientService;



@RestController
@RequestMapping("/api")
public class AccountRestController {

	@Autowired
	private IClientService clientService;

	@GetMapping("/accounts/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Account show(@PathVariable Long id) {
		return clientService.findAccountById(id);
	}
	
	@DeleteMapping("/accounts/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clientService.deleteAccountById(id);
	}
	

	@PostMapping("/accounts")
	@ResponseStatus(HttpStatus.CREATED)
	public Account create(@RequestBody Account account) {
		return clientService.saveAccount(account);
	}
	
	@PostMapping("/accounts/transfer")
	@ResponseStatus(HttpStatus.OK)
	public void transfer(@RequestBody Account name, Double amount) {
		clientService.transfer(name, amount);
	}
}
