package com.edu.uce.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.edu.uce.api.service.IEstudianteService;

@RestController
@RequestMapping(path="/estudiantes") //el / aca no es absolutamente, poeque se puede poner luego en otro lado
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes
	@PostMapping
	public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante est) {
		this.estudianteService.guardar(est);
		//esto deberia consultar aca
		return ResponseEntity.status(201).body(est);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/3
	@PutMapping(path = "/{id}")
	public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
		this.estudianteService.actualizar(est);
		return ResponseEntity.status(238).body(est);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar/parcial
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/3
	@PatchMapping(path = "/{id}")
	public ResponseEntity<Estudiante> actualizarParcial(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
		Estudiante est2=this.estudianteService.buscar(est.getId());
		if(est.getNombre()!=null) {
			est2.setNombre(est.getNombre());
		}
		if(est.getApellido()!=null) {
			est2.setApellido(est.getApellido());
		}
		if(est.getFechaNacimiento()!=null) {
			est2.setFechaNacimiento(est.getFechaNacimiento());
		}

		this.estudianteService.actualizar(est2);
		
		return ResponseEntity.status(239).body(est2);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/1
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/2
	//para 2 variables: path = "/borrar2/{id}/{id2}" y @PathVariable Integer id,@PathVariable Integer id2
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/5
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
		System.out.println("Borrar");
		this.estudianteService.borrar(id);
		return ResponseEntity.status(240).body("Borrado");
	}
	

	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/3/nuevo/asdf
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/3
	@GetMapping(path="/{id}")
	public ResponseEntity<Estudiante> buscarPorId(@PathVariable Integer id) {

		Estudiante es= this.estudianteService.buscar(id);
		return ResponseEntity.status(236).body(es);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=F&edad=26
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/genero?genero=M
	@GetMapping(path = "/genero")
	public ResponseEntity<List<Estudiante>> buscarPorGenero(@RequestParam String genero) {
		List <Estudiante> lista= this.estudianteService.buscarPorGenero(genero);
		return ResponseEntity.status(235).body(lista);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarMixto/3?prueba=HolaMundo
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/mixto/3?prueba=HolaMundo
	@GetMapping(path="/mixto/{id}")
	public Estudiante buscarMixto(@PathVariable Integer id,@RequestParam String prueba) {
		System.out.println("id: "+id);
		System.out.println("prueba: "+prueba);
		
		return this.estudianteService.buscar(id);
	}
	
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/test/3
	@GetMapping(path="/test/{id}")
	public Estudiante test(@PathVariable Integer id,@RequestBody Estudiante est) {
		System.out.println("est: "+est);
		
		return this.estudianteService.buscar(id);
	}
	
	
	
}
