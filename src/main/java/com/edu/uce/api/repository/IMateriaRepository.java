package com.edu.uce.api.repository;

import java.util.List;

import com.edu.uce.api.repository.modelo.Materia;

public interface IMateriaRepository {

	//CRUD
	public Materia seleccionar(Integer id);
	public List<Materia> seleccionarPorIdEstudiante(Integer id);
	void actualizar(Materia materia);
	public void eliminar(Integer id);
	public void insertar(Materia materia);
	public List<Materia> seleccionarPorHoras(Integer horas);
}
