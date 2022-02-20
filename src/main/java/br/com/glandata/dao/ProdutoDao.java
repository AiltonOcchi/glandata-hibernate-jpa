package br.com.glandata.dao;

import java.math.BigDecimal;
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
	
	public List<Produto> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";// também podemos usar ?1
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome) //poderia ser o numero  que representa a interrogação
				.getResultList();
	}
	
	public List<Produto> buscarPorNomeDaCategoria(String nomeDaCategoria) {
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nomeDaCategoria)
				.getResultList();
	}
	
	public BigDecimal buscarPrecoDoProdutoPeloNome(String nomeDoProduto) {
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";// também podemos usar ?1
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("nome", nomeDoProduto)
				.setMaxResults(1)
				.getSingleResult();
	}
	
}