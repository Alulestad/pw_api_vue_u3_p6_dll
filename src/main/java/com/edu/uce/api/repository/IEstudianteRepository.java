package com.edu.uce.api.repository;

import com.edu.uce.api.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;

public interface IEstudianteRepository {
	
	//CRUD
	public Estudiante seleccionar(Integer id);
	public void actualizar(Estudiante estudiante);
	public void eliminar(Integer id);
	public void insertar(Estudiante estudiante);

}
