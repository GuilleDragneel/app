package com.unsis.spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unsis.spring.app.entity.Cuenta;

public interface CuentaDao extends JpaRepository<Cuenta, Long>{

}
