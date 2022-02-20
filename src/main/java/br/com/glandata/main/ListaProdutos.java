package br.com.glandata.main;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.glandata.dao.ProdutoDao;
import br.com.glandata.model.Produto;
import br.com.glandata.uil.JPAUtil;

public class ListaProdutos {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		List<Produto> listaProdutos = produtoDao.buscarTodos();
		
		System.out.println("###################Lista todos os produtos");
		listaProdutos.forEach(produto -> System.out.println(produto.getNome()));
		
		System.out.println("###################Lista todos os produtos por nome");
		produtoDao.buscarPorNome("Moto G30").forEach(produto -> System.out.println(produto.getId() + " - "+produto.getNome()));
		
		System.out.println("###################Lista todos os produtos por nome da categoria");
		produtoDao.buscarPorNomeDaCategoria("Vestuario").forEach(produto -> System.out.println(produto.getId() + " - "+produto.getNome()));
		
	    em.close();
		
	}

}

