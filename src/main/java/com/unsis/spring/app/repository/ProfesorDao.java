package com.unsis.spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unsis.spring.app.entity.Profesor;

public interface ProfesorDao extends JpaRepository<Profesor, Long>{
    
}
