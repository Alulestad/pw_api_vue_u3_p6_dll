package com.edu.uce.api.repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.edu.uce.api.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository ("materiaRepo")
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Materia seleccionar(Integer id) {
		System.out.println("MateriaRepositoryImpl Id: "+id);
		
		return this.entityManager.find(Materia.class, id);
	}
	
	@Override
	public List<Materia> seleccionarPorIdEstudiante(Integer id) {
		TypedQuery<Materia> myQuery=this.entityManager.createQuery("select m from Materia m where m.estudiante.id=:id ",Materia.class);
		myQuery.setParameter("id", id);
		
		return myQuery.getResultList();
	}
	

	@Override
	public void actualizar(Materia materia) {
		this.entityManager.merge(materia);

	}

	@Override
	public void eliminar(Integer id) {

		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);

	}

	@Override
	public List<Materia> seleccionarPorHoras(Integer horas) {
		TypedQuery<Materia> myQueryTyped= this.entityManager.createQuery("select m from Materia m where "
				+ "m.numeroHoras=:datoHoras",Materia.class);
		myQueryTyped.setParameter("datoHoras", horas);
		return myQueryTyped.getResultList();
	}



	

}
