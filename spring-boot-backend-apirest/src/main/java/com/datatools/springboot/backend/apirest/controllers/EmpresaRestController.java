package com.datatools.springboot.backend.apirest.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.datatools.springboot.backend.apirest.models.entity.Empresa;
import com.datatools.springboot.backend.apirest.models.services.IEmpresaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EmpresaRestController {

	@Autowired
	private IEmpresaService empresaService;

	@GetMapping("/empresas")
	public List<Empresa> index() {
		return empresaService.findAll();
	}

	@GetMapping("/empresas/{id}")
	public Empresa show(@PathVariable Long id) {
		return this.empresaService.findById(id);
	}

	@PostMapping("/empresas")
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa create(@RequestBody Empresa empresa) {
		empresa.setCreateAt(new Date());
		this.empresaService.save(empresa);
		return empresa;
	}

	@PutMapping("/empresas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa update(@RequestBody Empresa empresa, @PathVariable Long id) {
		Empresa currentEmpresa = this.empresaService.findById(id);
		
		currentEmpresa.setTipoId(empresa.getTipoId());
		currentEmpresa.setNombre(empresa.getNombre());
		currentEmpresa.setDireccion(empresa.getDireccion());
		currentEmpresa.setCiudad(empresa.getCiudad());
		currentEmpresa.setDepartamento(empresa.getDepartamento());
		currentEmpresa.setPais(empresa.getPais());
		currentEmpresa.setTelefono(empresa.getTelefono());
		currentEmpresa.setNit(empresa.getNit());
		currentEmpresa.setEmail(empresa.getEmail());
		return currentEmpresa;
	}

	@DeleteMapping("/empresas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Empresa currentEmpresa = this.empresaService.findById(id);
		this.empresaService.delete(currentEmpresa);
	}
}
