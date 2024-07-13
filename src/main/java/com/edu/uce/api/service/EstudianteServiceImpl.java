package com.edu.uce.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.uce.api.repository.IEstudianteRepository;
import com.edu.uce.api.repository.modelo.Estudiante;
import com.edu.uce.api.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Override
	public Estudiante buscar(Integer id) { //deberia usar EstudianteTO**********************************
		
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepository.actualizar(estudiante);

	}

	@Override
	public void borrar(Integer id) {
		this.estudianteRepository.eliminar(id);

	}

	@Override
	public void guardar(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);

	}

	@Override
	public List<Estudiante> buscarPorGenero(String genero) {
		return this.estudianteRepository.seleccionarPorGenero(genero);
	}
	
	public EstudianteTO convertir(Estudiante estu) {
		EstudianteTO estuTo= new EstudianteTO();
		estuTo.setId(estu.getId());
		estuTo.setApellido(estu.getApellido());
		estuTo.setFechaNacimiento(estu.getFechaNacimiento());
		estuTo.setGenero(estu.getGenero());
		estuTo.setNombre(estu.getNombre());
		return estuTo;
		
		
	}

	@Override
	public EstudianteTO buscarPorId(Integer id) {
		Estudiante est=this.estudianteRepository.seleccionar(id);
		
		return this.convertir(est);
	}

}
