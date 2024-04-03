package com.unsis.spring.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsis.spring.app.entity.Profesor;
import com.unsis.spring.app.repository.ProfesorDao;

import jakarta.transaction.Transactional;

@Service
public class ProfesorServiceImpl implements ProfesorService{

@Autowired
	private ProfesorDao profesorDao;
	
	@Override
	@Transactional
	public List<Profesor> findAll() {
		return (List<Profesor>) profesorDao.findAll();
	}

	@Override
	@Transactional
	public Profesor save(Profesor profesor) {
		return profesorDao.save(profesor);
	}

	@Override 
	public Profesor findById(Long id) {
		return profesorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Profesor profesor) {
		profesorDao.delete(profesor);
		
	}
    
}
