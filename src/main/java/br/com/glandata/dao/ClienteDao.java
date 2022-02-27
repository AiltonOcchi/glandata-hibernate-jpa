package br.com.glandata.dao;

import javax.persistence.EntityManager;

import br.com.glandata.model.Cliente;

public class ClienteDao {
	
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		em.persist(cliente);
	}

	/*
	public void atualizar(Cliente cliente) {
		em.merge(cliente);
	}

	public void remover(Cliente cliente) {
		cliente = em.merge(cliente);
		em.remove(cliente);
	}
	
	public Cliente buscarPorId(Long id) {
		return em.find(Cliente.class, id);
	}
	
	public int deletaCliente(Long id) {
		
		Query query = em.createQuery("DELETE FROM Cliente p WHERE p.id =: id");
		query.setParameter("id", id);
		int deletedCount = query.executeUpdate();
		
		return deletedCount;
	}
	
	public List<Cliente> buscarTodos() {
		String jpql = "SELECT p FROM Cliente p";
		return em.createQuery(jpql, Cliente.class).getResultList();

	}
	
	public List<Cliente> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Cliente p WHERE p.nome = :nome";
		return em.createQuery(jpql, Cliente.class)
				.getResultList();
	}
	
	public List<Cliente> buscarPorNomeDaCategoria(String nomeDaCategoria) {
		String jpql = "SELECT p FROM Cliente p WHERE p.categoria.nome = :nome";
		return em.createQuery(jpql, Cliente.class)
				.setParameter("nome", nomeDaCategoria)
				.getResultList();
	}
	
	public BigDecimal buscarPrecoDoClientePeloNome(String nomeDoCliente) {
		String jpql = "SELECT p.preco FROM Cliente p WHERE p.nome = :nome";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("nome", nomeDoCliente)
				.setMaxResults(1)
				.getSingleResult();
	}
	*/
	
}