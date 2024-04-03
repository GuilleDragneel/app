package com.unsis.spring.app.services;

import java.util.List;

import com.unsis.spring.app.entity.Instituto;

public interface InstitutoService {

    public List<Instituto> findAll();
	
	public Instituto save(Instituto rol);
	
	public Instituto findById(Long id);
	
	public void delete(Instituto rol);
    
}