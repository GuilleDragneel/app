package com.unsis.spring.app.services;

import java.util.List;

import com.unsis.spring.app.entity.Rol;

public interface RolService {

    public List<Rol> findAll();
	
	public Rol save(Rol rol);
	
	public Rol findById(Long id);
	
	public void delete(Rol rol);
    
}
