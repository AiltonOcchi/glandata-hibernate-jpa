package br.com.glandata.dao;

import javax.persistence.EntityManager;

import br.com.glandata.model.Pedido;

public class PedidoDao {
	
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		em.persist(pedido);
	}

	/*
	public void atualizar(Pedido pedido) {
		em.merge(pedido);
	}

	public void remover(Pedido pedido) {
		pedido = em.merge(pedido);
		em.remove(pedido);
	}
	
	public Pedido buscarPorId(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public int deletaPedido(Long id) {
		
		Query query = em.createQuery("DELETE FROM Pedido p WHERE p.id =: id");
		query.setParameter("id", id);
		int deletedCount = query.executeUpdate();
		
		return deletedCount;
	}
	
	public List<Pedido> buscarTodos() {
		String jpql = "SELECT p FROM Pedido p";
		return em.createQuery(jpql, Pedido.class).getResultList();

	}
	
	public List<Pedido> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Pedido p WHERE p.nome = :nome";
		return em.createQuery(jpql, Pedido.class)
				.getResultList();
	}
	
	public List<Pedido> buscarPorNomeDaCategoria(String nomeDaCategoria) {
		String jpql = "SELECT p FROM Pedido p WHERE p.categoria.nome = :nome";
		return em.createQuery(jpql, Pedido.class)
				.setParameter("nome", nomeDaCategoria)
				.getResultList();
	}
	
	public BigDecimal buscarPrecoDoPedidoPeloNome(String nomeDoPedido) {
		String jpql = "SELECT p.preco FROM Pedido p WHERE p.nome = :nome";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("nome", nomeDoPedido)
				.setMaxResults(1)
				.getSingleResult();
	}
	*/
	
}