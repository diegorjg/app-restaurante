package com.yadier.LoExquisitoMar.models;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Usuario {
	private  Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String direccion;
	private String password;
	
	public static String ERR_NOMBRE = "El nombre debe tener mas de 3 letras y menos de 20.";
	public static String ERR_APELLIDO = "Debe indicar el apellido del usuario.";
	public static String ERR_EMAIL = "Debe indicar el email del usuario.";
	public static String ERR_DIRECCION = "Debe indicar la dirección del usuario.";
	public static String ERR_PASSWORD = "Debe indicar la contraseña del usuario.";
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
