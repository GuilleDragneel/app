package com.unsis.spring.app.services;

import java.util.List;

import com.unsis.spring.app.entity.Cuenta;

public interface CuentaService {

    public List<Cuenta> findAll();
	
	public Cuenta save(Cuenta cuenta);
	
	public Cuenta findById(Long id);
	
	public void delete(Cuenta cuenta);
}
