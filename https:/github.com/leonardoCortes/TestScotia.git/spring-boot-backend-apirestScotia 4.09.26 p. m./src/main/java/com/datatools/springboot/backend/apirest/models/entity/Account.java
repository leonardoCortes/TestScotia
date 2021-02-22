package com.datatools.springboot.backend.apirest.models.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "It cant be empty")
	@Column(nullable = false)
	private String nameAccount;

	@NotEmpty(message = "It cant be empty")
	@Column(nullable = false)
	private Double accountBalance;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@JsonIgnoreProperties(value={"accounts", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Client client;


	public Account(@NotEmpty(message = "It cant be empty") String nameAccount, @NotEmpty(message = "It cant be empty") Double accountBalance) {
		 this.nameAccount = nameAccount;
		 this.accountBalance = accountBalance;
		 
	}

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameAccount() {
		return nameAccount;
	}

	public void setNameAccount(String nameAccount) {
		this.nameAccount = nameAccount;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addFunds(Double addAmount) {
		accountBalance = accountBalance + addAmount;
	}
	
	public void trasfer(Account name, Double amount) {
		if(this.accountBalance >= amount) {
			name.accountBalance += amount;
			this.accountBalance -= amount;
		}
	}

	private static final long serialVersionUID = 1L;
}
