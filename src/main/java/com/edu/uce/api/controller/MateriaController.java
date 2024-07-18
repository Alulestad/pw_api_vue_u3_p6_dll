package com.edu.uce.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
import com.edu.uce.api.repository.modelo.Materia;
import com.edu.uce.api.service.IMateriaService;
import com.edu.uce.api.service.to.MateriaTO;

@RestController
@RequestMapping(path = "/materias")
public class MateriaController {

	@Autowired
	private IMateriaService iMateriaService;

	// Nivel1
	// http://localhost:8080/API/v1.0/Matricula/materias
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Materia> guardar(@RequestBody Materia materia) {
		this.iMateriaService.guardar(materia);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_201", "Corresponde a la insercion de recursos");
		//return ResponseEntity.status(201).body(this.iMateriaService.buscar(materia.getId()));
		return new ResponseEntity<Materia>(this.iMateriaService.buscar(materia.getId()),cabeceras,201);
	}

	// Nivel1
	// http://localhost:8080/API/v1.0/Matricula/materias/4
	@PutMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Materia> actualizar(@RequestBody Materia materia, @PathVariable Integer id) {
		materia.setId(id);
		this.iMateriaService.actualizar(materia);		
		HttpHeaders cabeceras= new HttpHeaders();
		cabeceras.add("mensaje_238", "Corresponde a la actualizacion de recursos");
		//return ResponseEntity.status(238).body(this.iMateriaService.buscar(id));
		return new ResponseEntity<Materia>(this.iMateriaService.buscar(id),cabeceras,238);
	}

	// Nivel1
	// http://localhost:8080/API/v1.0/Matricula/materias/4
	@PatchMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Materia> actualizarParcial(@RequestBody Materia materia, @PathVariable Integer id) {
		materia.setId(id);
		Materia materia2 = this.iMateriaService.buscar(materia.getId());
		if (materia.getNombre() != null) {
			materia2.setNombre(materia.getNombre());
		}
		if (materia.getMateriaAntecesora() != null) {
			materia2.setMateriaAntecesora(materia.getMateriaAntecesora());
		}
		if (materia.getModalidad() != null) {
			materia2.setModalidad(materia.getModalidad());
		}
		if (materia.getNumeroHoras() != null) {
			materia2.setNumeroHoras(materia.getNumeroHoras());
		}
		if (materia.getTipo() != null) {
			materia2.setTipo(materia.getTipo());
		}

		this.iMateriaService.actualizar(materia2);
		//return ResponseEntity.status(239).body(materia2);
		HttpHeaders cabeceras=new HttpHeaders();
		cabeceras.add("mensaje_239", "Corresponde a la actualizacion de recursos parcial");
		return new ResponseEntity<Materia>(materia2,cabeceras,239);
	}

	// Nivel1
	// http://localhost:8080/API/v1.0/Matricula/materias/6
	@DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
		this.iMateriaService.borrar(id);
		//return ResponseEntity.status(240).body("Borrado");
		HttpHeaders cabeceras= new HttpHeaders();
		cabeceras.add("mensaje_240", "Corresponde a la eliminacion de recurso");
		return new ResponseEntity<String>("Borrado",cabeceras,240);
		
	}

	// Nivel1
	// http://localhost:8080/API/v1.0/Matricula/materias/1
	@GetMapping(path = "/{id}",produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Materia> buscar(@PathVariable Integer id) {
		Materia mate1= this.iMateriaService.buscar(id);
		//return ResponseEntity.status(236).body(mate1);
		HttpHeaders cb=new HttpHeaders();
		cb.add("mensaje_236", "Corresponde a la busqueda de recursos");
		return new ResponseEntity<Materia>(mate1,cb,236);
	
	}

	// Nivel1
	// http://localhost:8080/API/v1.0/Matricula/materias/hora?hora=120
	@GetMapping(path = "/hora",produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<Materia>> buscarPorHora(@RequestParam Integer hora) {
		List<Materia> lista=this.iMateriaService.buscarPorHoras(hora);
		//return ResponseEntity.status(236).body(lista);
		HttpHeaders cb=new HttpHeaders();
		cb.add("mesaje_236", "Corresponde a la busqueda de recursos");
		return new ResponseEntity<List<Materia>>(lista,cb,236);
	}
	
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/2/materias GET
	@GetMapping(path = "/{id}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MateriaTO> buscarMateriasPorIdEtudiante(@PathVariable Integer id) {
		return this.iMateriaService.buscarPorIdEstudiante(id);
	}

}
