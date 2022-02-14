package br.com.glandata.dao;

import javax.persistence.EntityManager;

import br.com.glandata.model.Categoria;

public class CategoriaDao {
	
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		em.persist(categoria);
	}
	
}


