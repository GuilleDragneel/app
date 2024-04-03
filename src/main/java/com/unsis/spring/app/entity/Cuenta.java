package com.unsis.spring.app.entity;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "cuenta")
public class Cuenta implements Serializable{
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
	@Column(name = "nombres")
	private String nombres;

    @NotBlank 
	@Column(name = "apellidoP")
	private String apellidoP;

	@Column(name = "apellidoM")
	private String apellidoM;

    @NotBlank 
	@Column(name = "correo")
	private String correo;

    @NotBlank 
	@Column(name = "contrasena")
	private String contrasena;

    @ManyToOne
    @JoinColumn(name = "id_rol") // nombre de la columna que representa la clave foránea
    private Rol rol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        // Cifrar la contraseña usando BCrypt
        //this.contrasena = new BCryptPasswordEncoder().encode(contrasena);
        this.contrasena = contrasena;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    } 
    
    
}
