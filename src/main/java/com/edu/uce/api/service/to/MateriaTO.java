package com.edu.uce.api.service.to;

import java.io.Serializable;

import jakarta.persistence.Column;

public class MateriaTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7809653248968185422L;
	
	private Integer id;
	private String nombre;
	private String modalidad;
	private Integer numeroHoras;
	private String tipo; // Profesional, Basico u optativa
	private String materiaAntecesora;
	
	//Get and Set
	public Integer getId() {
		return id;
	}
	
	//gets y sets
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public Integer getNumeroHoras() {
		return numeroHoras;
	}
	public void setNumeroHoras(Integer numeroHoras) {
		this.numeroHoras = numeroHoras;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMateriaAntecesora() {
		return materiaAntecesora;
	}
	public void setMateriaAntecesora(String materiaAntecesora) {
		this.materiaAntecesora = materiaAntecesora;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
