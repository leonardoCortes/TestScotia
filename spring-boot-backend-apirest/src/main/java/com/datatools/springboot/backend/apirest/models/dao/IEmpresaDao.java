package com.datatools.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.datatools.springboot.backend.apirest.models.entity.Empresa;

public interface IEmpresaDao extends CrudRepository<Empresa, Long>{

}
