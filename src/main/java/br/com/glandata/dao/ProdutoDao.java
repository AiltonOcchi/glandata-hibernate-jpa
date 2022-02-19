package br.com.glandata.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.glandata.model.Produto;

public class ProdutoDao {
	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		em.persist(produto);
	}

	public void atualizar(Produto produto) {
		em.merge(produto);
	}

	public void remover(Produto produto) {
		produto = em.merge(produto);
		em.remove(produto);
	}
	
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public int deletaProduto(Long id) {
		
		Query query = em.createQuery("DELETE FROM Produto p WHERE p.id =: id");
		query.setParameter("id", id);
		int deletedCount = query.executeUpdate();
		
		return deletedCount;
	}
	
	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p";
		// return em.createQuery(jpql).getResultList();// Também funciona mas gera warning
		return em.createQuery(jpql, Produto.class).getResultList();

	}
}