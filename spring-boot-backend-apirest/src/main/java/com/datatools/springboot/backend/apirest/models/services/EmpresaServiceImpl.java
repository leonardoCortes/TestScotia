package com.datatools.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datatools.springboot.backend.apirest.models.dao.IEmpresaDao;
import com.datatools.springboot.backend.apirest.models.entity.Empresa;

@Service
public class EmpresaServiceImpl implements IEmpresaService{

	@Autowired
	private IEmpresaDao empresaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Empresa> findAll() {
		return (List<Empresa>) empresaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Empresa empresa) {
		empresaDao.save(empresa);
	}

	@Override
	@Transactional(readOnly = true)
	public Empresa findById(Long id) {
		return empresaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Empresa empresa) {
		empresaDao.delete(empresa);
		
	}

}
