package com.unsis.spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unsis.spring.app.entity.Rol;

public interface RolDao extends JpaRepository<Rol, Long> {
    
}
