package com.datatools.springboot.backend.apirest.models.services;

import java.util.List;

import com.datatools.springboot.backend.apirest.models.entity.Empresa;

public interface IEmpresaService {
	
	public List<Empresa> findAll();
	
	public void save(Empresa empresa);
	
	public Empresa findById(Long id);
	
	public void delete(Empresa empresa);

}
