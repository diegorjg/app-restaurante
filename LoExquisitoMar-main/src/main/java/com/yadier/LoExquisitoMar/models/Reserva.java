package com.yadier.LoExquisitoMar.models;


import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Reserva {
	private  Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	private String hora;
	private int numPersonas;
	private int mesa;
	
	
	public static String ERR_FECHA = "La fecha debe ser mayor o igual al afecha actual.";
	public static String ERR_NUMPERSONAS = "Debe indicar el número de personas.";
	public static String ERR_HORA = "Debe indicar la hora.";
	public static String ERR_MESA = "Debe indicar la mesa.";
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	public int getNumPersonas() {
		return numPersonas;
	}
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	public int getMesa() {
		return mesa;
	}
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	
}
