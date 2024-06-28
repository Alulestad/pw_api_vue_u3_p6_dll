package com.edu.uce.api.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.api.repository.modelo.Estudiante;
import com.edu.uce.api.service.IEstudianteService;

@RestController
@RequestMapping(path="/estudiantes") //el / aca no es absolutamente, poeque se puede poner luego en otro lado
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante est) {
//		Estudiante est=new Estudiante();
//		est.setNombre("Daniel");
//		est.setApellido("Llumiquinga");
//		//est.setFechaNacimiento(LocalDateTime.now());
//		est.setFechaNacimiento(LocalDateTime.of(1998, 4, 2, 5, 4, 3, 2));
		
		this.estudianteService.guardar(est);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	@PutMapping(path = "/actualizar")
	public void actualizar() {
		Estudiante est=this.estudianteService.buscar(1);
		est.setNombre("Bernardo");
		est.setApellido("Molina");
		est.setFechaNacimiento(LocalDateTime.of(1999, 4, 2, 5, 4, 3, 2));
		this.estudianteService.actualizar(est);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar/parcial
	@PatchMapping(path = "/actualizar/parcial")
	//@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial() {
		Estudiante est=this.estudianteService.buscar(1);
		est.setNombre("Bernardo");
		this.estudianteService.actualizar(est);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	@DeleteMapping(path = "/borrar")
	public void borrar() {
		this.estudianteService.borrar(1);
	}

	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	@GetMapping(path="/buscar")
	public Estudiante buscar() {
		
		return this.estudianteService.buscar(2);
	}
	
}
