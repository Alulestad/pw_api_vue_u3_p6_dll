package com.edu.uce.api.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHeadResponseDecorator;
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
import com.edu.uce.api.service.IEstudianteService;
import com.edu.uce.api.service.IMateriaService;
import com.edu.uce.api.service.to.EstudianteTO;
import com.edu.uce.api.service.to.MateriaTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path="/estudiantes") //el / aca no es absolutamente, poeque se puede poner luego en otro lado
public class EstudianteController {

	@Autowired
	private IEstudianteService iEstudianteService;
	@Autowired
	private IMateriaService iMateriaService;
	
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes
	@PostMapping(produces = "application/json", consumes = "application/xml")
	public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante est) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("mensaje_201","Corresponde a la insercion de recursos" );
		this.iEstudianteService.guardar(est);
		//return ResponseEntity.status(201).body(this.iEstudianteService.buscar(est.getId()));
		return new ResponseEntity<Estudiante>(this.iEstudianteService.buscar(est.getId()),headers,HttpStatus.CREATED);
	}
	
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/3
	@PutMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
		this.iEstudianteService.actualizar(est);
		Estudiante est1=this.iEstudianteService.buscar(id);
		//return ResponseEntity.status(238).body(est1);
		HttpHeaders headers=new HttpHeaders();
		headers.add("mensaje_238", "corresponde a la actualizacion de recursos");
		return new ResponseEntity<>(est1, headers,238);
	}
	
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/3
	@PatchMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> actualizarParcial(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
		Estudiante est2=this.iEstudianteService.buscar(est.getId());
		if(est.getNombre()!=null) {
			est2.setNombre(est.getNombre());
		}
		if(est.getApellido()!=null) {
			est2.setApellido(est.getApellido());
		}
		if(est.getFechaNacimiento()!=null) {
			est2.setFechaNacimiento(est.getFechaNacimiento());
		}

		this.iEstudianteService.actualizar(est2);
		
		//return ResponseEntity.status(239).body(est2);
		HttpHeaders cabeceras=new HttpHeaders();
		cabeceras.add("mensaje_239", "Corresponde a la actualizacion de recursos parcial");
		return new ResponseEntity<Estudiante>(est2,cabeceras,239);
	}
	
	//para 2 variables: path = "/borrar2/{id}/{id2}" y @PathVariable Integer id,@PathVariable Integer id2
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/5
	@DeleteMapping(path = "/{id}",produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
		System.out.println("Borrar");
		this.iEstudianteService.borrar(id);
		//return ResponseEntity.status(240).body("Borrado");
		HttpHeaders cabeceras= new HttpHeaders();
		cabeceras.add("mensaje_240", "Corresponde a la eliminacion de recurso");
		return new ResponseEntity<>("Borrado",cabeceras,240);
	}
	

	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/3
	@GetMapping(path="/{id}", produces = "application/json")
	public ResponseEntity<Estudiante> buscarPorId(@PathVariable Integer id) {
		HttpHeaders cabeceras=new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta de un recurso"); //clave: mensaje_236, valor: el resto.
		cabeceras.add("valor", "Estudiante encontrado");
		
		//return ResponseEntity.status(236).body(this.iEstudianteService.buscar(id));
		return new ResponseEntity<> (this.iEstudianteService.buscar(id),cabeceras,236); 
		//1ra respuesta del body es this.... en el segundo mando las cabezeras y 3ro el codigo
		
		
		
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=F&edad=26
	//la url queda igual y solo se aniade (@RequestParam String genero, @RequestParam Integer edad)
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/genero?genero=M
	@GetMapping(path = "/genero",produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<Estudiante>> buscarPorGenero(@RequestParam String genero) {
		List <Estudiante> lista= this.iEstudianteService.buscarPorGenero(genero);
		//return ResponseEntity.status(236).body(lista);
		HttpHeaders cb=new HttpHeaders();
		cb.add("mesaje_236", "Corresponde a la busqueda de recursos");
		return new ResponseEntity<List<Estudiante>>(lista,cb,236);
	}
	
	
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/mixto/3?prueba=HolaMundo
	@GetMapping(path="/mixto/{id}",produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> buscarMixto(@PathVariable Integer id,@RequestParam String prueba) {
		System.out.println("id: "+id);
		System.out.println("prueba: "+prueba);
		//
		HttpHeaders cb=new HttpHeaders();
		cb.add("mesaje_236", "Corresponde a la busqueda de recursos");
		return new ResponseEntity<Estudiante>(this.iEstudianteService.buscar(id),cb,236);
	}
	
	//Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/test/3
	@GetMapping(path="/test/{id}",produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Estudiante> test(@PathVariable Integer id,@RequestBody Estudiante est) {
		System.out.println("est: "+est);
		
		HttpHeaders cb=new HttpHeaders();
		cb.add("mesaje_236", "Corresponde a la busqueda de recursos");
		return new ResponseEntity<Estudiante>(this.iEstudianteService.buscar(id),cb,236);
	}
	
	//los textos planos no se deberian de usar
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/texto/plano
	@GetMapping(path = "/texto/plano")
	public String prueba() {
		String prueba ="Texto de prueba";
		return prueba;
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/hateoas/1
	
	@GetMapping(path = "/hateoas/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public EstudianteTO buscarHateoas(@PathVariable Integer id){
		EstudianteTO est=this.iEstudianteService.buscarPorId(id);
		
		//ERROR: esto es una carga EAGER.
		//List<MateriaTO> lista= this.iMateriaService.buscarPorIdEstudiante(id);	
		//est.setMateriaTOs(lista);
		Link myLink=linkTo(methodOn(EstudianteController.class).buscarMateriasPorIdEtudiante(id)).withRel("susMaterias"); //referencia susMaterias
		Link myLink2=linkTo(methodOn(EstudianteController.class).buscarPorId(id)).withSelfRel(); //agrega una referencia a si mismo.
		
		est.add(myLink);
		est.add(myLink2);
		
		return est;
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/2/materias GET
	@GetMapping(path = "/{id}/materias",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MateriaTO> buscarMateriasPorIdEtudiante (@PathVariable Integer id){
		return this.iMateriaService.buscarPorIdEstudiante(id);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EstudianteTO> buscarTodos() {
		List<EstudianteTO> estudianteTOs = iEstudianteService.buscarTodos();

		for (EstudianteTO estuTO : estudianteTOs) {
			Link myLink = linkTo(methodOn(EstudianteController.class).buscarMateriasPorIdEtudiante(estuTO.getId())).withRel("susMaterias");
			estuTO.add(myLink);
		}

		return estudianteTOs;
	}

}
