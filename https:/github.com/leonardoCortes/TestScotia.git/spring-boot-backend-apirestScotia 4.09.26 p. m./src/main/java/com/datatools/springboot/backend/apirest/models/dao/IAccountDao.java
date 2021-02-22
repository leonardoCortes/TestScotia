package com.datatools.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.datatools.springboot.backend.apirest.models.entity.Account;

public interface IAccountDao extends JpaRepository<Account, Long>{

}
