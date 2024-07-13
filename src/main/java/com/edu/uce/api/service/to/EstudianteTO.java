package com.edu.uce.api.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import aj.org.objectweb.asm.commons.SerialVersionUIDAdder;
import jakarta.persistence.Column;

public class EstudianteTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 968762004004279482L;  //generate i serial number en la izquierda 

	private Integer id;
	private String nombre;
	private String apellido;
	private LocalDateTime fechaNacimiento;
	private String genero;
	
	
	private List<MateriaTO> materiaTOs;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<MateriaTO> getMateriaTOs() {
		return materiaTOs;
	}
	public void setMateriaTOs(List<MateriaTO> materiaTOs) {
		this.materiaTOs = materiaTOs;
	}
	
	
	

	
	
	

}