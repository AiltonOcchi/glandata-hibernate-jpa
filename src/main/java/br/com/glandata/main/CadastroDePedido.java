package br.com.glandata.main;

import javax.persistence.EntityManager;

import br.com.glandata.dao.ClienteDao;
import br.com.glandata.dao.PedidoDao;
import br.com.glandata.model.Cliente;
import br.com.glandata.model.ItemPedido;
import br.com.glandata.model.Pedido;
import br.com.glandata.model.Produto;
import br.com.glandata.uil.JPAUtil;

public class CadastroDePedido {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("Ailton","123456");
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(1, pedido, new Produto((long)6)));
		pedido.adicionarItem(new ItemPedido(2, pedido, new Produto((long)1)));
		pedido.adicionarItem(new ItemPedido(1, pedido, new Produto((long)2)));
		
		EntityManager em = JPAUtil.getEntityManager();
		PedidoDao pedidoDao =  new PedidoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		em.getTransaction().begin();
		
		clienteDao.cadastrar(cliente);
		
		pedidoDao.cadastrar(pedido);
		
		em.getTransaction().commit();
		
	}

}
