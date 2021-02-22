package com.datatools.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.datatools.springboot.backend.apirest.models.entity.Account;
import com.datatools.springboot.backend.apirest.models.entity.Client;


public interface IClientService {

	public List<Client> findAll();
	
	public Page<Client> findAll(Pageable pageable);
	
	public Client findById(Long id);
	
	public Client save(Client client);
	
	public void delete(Long id);
	
	public Account findAccountById(Long id);
	
	public Account saveAccount(Account account);
	
	public void deleteAccountById(Long id);
	
	public void transfer(Account name, Double amount);

	
	
}
