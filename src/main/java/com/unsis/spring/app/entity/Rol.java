package com.unsis.spring.app.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;

@Entity
@Table(name = "rol")
public class Rol implements Serializable{

    private static final long serialVersionUID = 1L;

    /*@Id: Representa a un primary key (llama primario) de
    nuestra tabla tbproduct*/
    @Id
    /*@GeneratedValue: Representa a un campo autogereado (secuencial),
    equivalente a un campo identity de una sentencia SQL.*/
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;
    
    @NotBlank 
	@Column(name = "name")
	private String name;

    public Rol(Long id, @NotBlank String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}