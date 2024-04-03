package com.unsis.spring.app.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "profesor")
public class Profesor implements Serializable{
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
    @ManyToOne
    @JoinColumn(name = "id_cuenta") // nombre de la columna que representa la clave foránea
    private Cuenta cuenta;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "id_instituto") // nombre de la columna que representa la clave foránea
    private Instituto instituto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Instituto getInstituto() {
        return instituto;
    }

    public void setInstituto(Instituto instituto) {
        this.instituto = instituto;
    }
}
