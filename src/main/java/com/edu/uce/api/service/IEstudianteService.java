package com.edu.uce.api.service;

import com.edu.uce.api.repository.modelo.Estudiante;

public interface IEstudianteService {
	
	public Estudiante buscar(Integer id);
	public void actualizar(Estudiante estudiante);
	public void borrar(Integer id);
	public void guardar(Estudiante estudiante);

}
