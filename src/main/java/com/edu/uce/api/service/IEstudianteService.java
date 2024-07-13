package com.edu.uce.api.service;

import java.util.List;

import com.edu.uce.api.repository.modelo.Estudiante;
import com.edu.uce.api.service.to.EstudianteTO;

public interface IEstudianteService {
	
	//deberia usar EstudianteTO**********************************
	public Estudiante buscar(Integer id);
	public EstudianteTO buscarPorId(Integer id);
	public void actualizar(Estudiante estudiante);
	public void borrar(Integer id);
	public void guardar(Estudiante estudiante);
	public List<Estudiante> buscarPorGenero(String genero);

}
