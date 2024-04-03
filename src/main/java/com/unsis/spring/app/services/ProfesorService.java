package com.unsis.spring.app.services;

import java.util.List;

import com.unsis.spring.app.entity.Profesor;

public interface ProfesorService {
    
    public List<Profesor> findAll();
	
	public Profesor save(Profesor profesor);
	
	public Profesor findById(Long id);
	
	public void delete(Profesor profesor);
}
