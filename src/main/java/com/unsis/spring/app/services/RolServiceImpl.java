package com.unsis.spring.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsis.spring.app.entity.Rol;
import com.unsis.spring.app.repository.RolDao;

import jakarta.transaction.Transactional;

@Service
public class RolServiceImpl implements RolService{
    
    @Autowired
	private RolDao rolDao;
	
	@Override
	@Transactional
	public List<Rol> findAll() {
		return (List<Rol>) rolDao.findAll();
	}

	@Override
	@Transactional
	public Rol save(Rol rol) {
		return rolDao.save(rol);
	}

	@Override 
	public Rol findById(Long id) {
		return rolDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Rol rol) {
		rolDao.delete(rol);
		
	}

}
