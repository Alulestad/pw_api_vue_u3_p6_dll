package com.edu.uce.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.uce.api.repository.IMateriaRepository;
import com.edu.uce.api.repository.modelo.Materia;
import com.edu.uce.api.service.to.MateriaTO;

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
	public List<MateriaTO> buscarPorIdEstudiante(Integer id) {
		List<Materia> lista=this.iMateriaRepository.seleccionarPorIdEstudiante(id);
		List<MateriaTO> listaFinal=new ArrayList<>();
		
		for(Materia m:lista) {
			listaFinal.add(this.materiaToMateriaTO(m));
		}
		
		return listaFinal;
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
	
	private MateriaTO materiaToMateriaTO(Materia materia) {
		MateriaTO mateTO= new MateriaTO();
		
		mateTO.setId(materia.getId());
		if(materia.getMateriaAntecesora() !=null)
		mateTO.setMateriaAntecesora(materia.getMateriaAntecesora());
		
		if(materia.getModalidad() !=null)
		mateTO.setModalidad(materia.getModalidad());
		
		if(materia.getNombre() !=null)
		mateTO.setNombre(materia.getNombre());
		
		if(materia.getNumeroHoras() !=null)
		mateTO.setNumeroHoras(materia.getNumeroHoras());
		
		if(materia.getTipo() !=null)
		mateTO.setTipo(materia.getTipo());
		
		return mateTO;
	}

}
