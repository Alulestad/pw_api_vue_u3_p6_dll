package com.edu.uce.api.service;

import java.util.List;

import com.edu.uce.api.repository.modelo.Materia;

public interface IMateriaService {
	
	//Create Read Update Delete
	
	public Materia buscar(Integer id);
	public void actualizar(Materia materia);
	public void borrar(Integer id);
	public void guardar(Materia materia);
	public List<Materia> buscarPorHoras(Integer horas);
	
	

}
