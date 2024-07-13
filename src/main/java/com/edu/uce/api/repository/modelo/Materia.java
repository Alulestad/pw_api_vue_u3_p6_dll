package com.edu.uce.api.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {

	@Id
	@GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	@Column(name = "mtra_id")
	private Integer id;
	@Column(name = "mtra_nombre")
	private String nombre;
	@Column(name = "mtra_modalidad")
	private String modalidad;
	@Column(name = "mtra_numero_horas")
	private Integer numeroHoras;
	@Column(name = "mtra_tipo")
	private String tipo; // Profesional, Basico u optativa
	@Column(name = "mtra_materia_antecesora")
	private String materiaAntecesora;
	
	
	@ManyToOne
	@JoinColumn(name = "mate_id_estudiante")
	private Estudiante estudiante;
	//
	
	//GETS Y SETS
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
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", modalidad=" + modalidad + ", numeroHoras=" + numeroHoras
				+ ", tipo=" + tipo + ", materiaAntecesora=" + materiaAntecesora + "]";
	}
	
	
	

}
