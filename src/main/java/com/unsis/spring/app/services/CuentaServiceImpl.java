package com.unsis.spring.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.unsis.spring.app.entity.Cuenta;
import com.unsis.spring.app.repository.CuentaDao;

import jakarta.transaction.Transactional;

public class CuentaServiceImpl implements CuentaService{
 @Autowired
	private CuentaDao cuentaDao;
	
	@Override
	@Transactional
	public List<Cuenta> findAll() {
		return (List<Cuenta>) cuentaDao.findAll();
	}

	@Override
	@Transactional
	public Cuenta save(Cuenta cuenta) {
		return cuentaDao.save(cuenta);
	}

	@Override 
	public Cuenta findById(Long id) {
		return cuentaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Cuenta cuenta) {
		cuentaDao.delete(cuenta);
		
	}
}
