package com.edu.uce.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.api.repository.modelo.Estudiante;
import com.edu.uce.api.repository.modelo.Materia;
import com.edu.uce.api.service.IMateriaService;

@RestController
@RequestMapping(path = "/materias")
public class MateriaController {

	@Autowired
	private IMateriaService iMateriaService;
	
	//http://localhost:8080/API/v1.0/Matricula/materias
	@PostMapping
	public void guardar(@RequestBody Materia materia) {
		this.iMateriaService.guardar(materia);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/materias/1
	@GetMapping(path = "/{id}")
	public Materia buscar(@PathVariable Integer id) {
		return this.iMateriaService.buscar(id);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/materias
	@PutMapping(path = "/{id}")
	public void actualizar(@RequestBody Materia materia, @PathVariable Integer id) {
		materia.setId(id);
		this.iMateriaService.actualizar(materia);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/materias/4
	@PatchMapping(path = "/{id}")
	public void actualizarParcial(@RequestBody Materia materia,@PathVariable Integer id) {
		materia.setId(id);
		Materia materia2=this.iMateriaService.buscar(materia.getId());
		if(materia.getNombre()!=null) {
			materia2.setNombre(materia.getNombre());
		}
		if(materia.getMateriaAntecesora()!=null) {
			materia2.setMateriaAntecesora(materia.getMateriaAntecesora());
		}
		if(materia.getModalidad()!=null) {
			materia2.setModalidad(materia.getModalidad());
		}
		if(materia.getNumeroHoras()!=null) {
			materia2.setNumeroHoras(materia.getNumeroHoras());
		}
		if(materia.getTipo()!=null) {
			materia2.setTipo(materia.getTipo());
		}

		this.iMateriaService.actualizar(materia2);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/materias/6
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.iMateriaService.borrar(id);
	}
	
	
	//http://localhost:8080/API/v1.0/Matricula/materias/hora?hora=120
	@GetMapping(path = "/hora")
	public List<Materia> buscarPorHora(@RequestParam Integer hora){
		
		return this.iMateriaService.buscarPorHoras(hora);
	}
	
}
