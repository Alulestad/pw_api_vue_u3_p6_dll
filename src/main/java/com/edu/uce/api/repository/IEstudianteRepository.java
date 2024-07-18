package com.edu.uce.api.repository;

import java.util.List;

import com.edu.uce.api.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;

public interface IEstudianteRepository {
	
	//CRUD
	public Estudiante seleccionar(Integer id);
	void actualizar(Estudiante estudiante);
	public void eliminar(Integer id);
	public void insertar(Estudiante estudiante);
	public List<Estudiante> seleccionarPorGenero(String genero);
	
	public List<Estudiante> seleccionarTodos();
	

}
