package com.edu.uce.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.uce.api.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional //de jakarta
public class EstudianteRepositoryImpl implements IEstudianteRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante seleccionar(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.seleccionar(id));

	}

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);

	}

	@Override
	public List<Estudiante> seleccionarPorGenero(String genero) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e where e.genero=:genero",Estudiante.class);
		myQuery.setParameter("genero", genero);
		
		return myQuery.getResultList();
	}
	
	@Override
	public List<Estudiante> seleccionarTodos() {
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e",Estudiante.class);
		return myQuery.getResultList();
	}
	
	

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e where e.cedula=:cedula",Estudiante.class);
		myQuery.setParameter("cedula", cedula);
		
		return myQuery.getSingleResult();
	}

	@Override
	public void eliminarPorCedula(String cedula) {
		Query myQuery = this.entityManager.createQuery("DELETE FROM Estudiante e where e.cedula=:cedula");
		myQuery.setParameter("cedula", cedula);
		myQuery.executeUpdate();
		
	}
	
	
	
	

}
