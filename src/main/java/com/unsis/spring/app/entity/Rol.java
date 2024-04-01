package com.unsis.spring.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    /*@Id: Representa a un primary key (llama primario) de
    nuestra tabla tbproduct*/
    @Id
    /*@GeneratedValue: Representa a un campo autogereado (secuencial),
    equivalente a un campo identity de una sentencia SQL.*/
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String nombre;

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
