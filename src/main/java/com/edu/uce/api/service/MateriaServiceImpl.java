package com.edu.uce.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.uce.api.repository.IMateriaRepository;
import com.edu.uce.api.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	@Qualifier(value = "materiaRepo")
	private IMateriaRepository iMateriaRepository;
	
	@Override
	public Materia buscar(Integer id) {
		System.out.println("MateriaServiceImpl Id: "+id);
		return this.iMateriaRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Materia materia) {
		this.iMateriaRepository.actualizar(materia);

	}

	@Override
	public void borrar(Integer id) {
		this.iMateriaRepository.eliminar(id);

	}

	@Override
	public void guardar(Materia materia) {
		this.iMateriaRepository.insertar(materia);

	}

	@Override
	public List<Materia> buscarPorHoras(Integer horas) {

		return this.iMateriaRepository.seleccionarPorHoras(horas);
	}

}
