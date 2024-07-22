package com.edu.uce.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		estuTo.setCedula(estu.getCedula());
		return estuTo;
		
		
	}

	@Override
	public EstudianteTO buscarPorId(Integer id) {
		Estudiante est=this.estudianteRepository.seleccionar(id);
		
		return this.convertir(est);
	}

	@Override
	public List<EstudianteTO> buscarTodos() {
		List<Estudiante> estudiantes=this.estudianteRepository.seleccionarTodos();
		List<EstudianteTO> estudianteTOs=new ArrayList<>();
		for ( Estudiante estu : estudiantes) {
			estudianteTOs.add(this.convertir(estu));
		}
		
		
		return estudianteTOs;
	}

	@Override
	public EstudianteTO buscarPorCedula(String cedula) {
		
		return this.convertir(this.estudianteRepository.seleccionarPorCedula(cedula));
	}

	@Override
	public void eliminarPorCedula(String cedula) {
		this.estudianteRepository.eliminarPorCedula(cedula);
		
	}
	
	public Estudiante estudianteTOtoEstudiante(EstudianteTO estudianteTO) {
		Estudiante estu= new Estudiante();
		estu.setCedula(estudianteTO.getCedula());
		estu.setNombre(estudianteTO.getNombre());
		estu.setApellido(estudianteTO.getApellido());
		estu.setFechaNacimiento(estudianteTO.getFechaNacimiento());
		estu.setGenero(estudianteTO.getGenero());
		return estu;
		
	}

	@Override
	public void guardarTO(EstudianteTO estudianteTO) {
		Estudiante estudiante=this.estudianteTOtoEstudiante(estudianteTO);
		this.estudianteRepository.insertar(estudiante);
		
	}
	
	
	
	
	
	
	
	

}
