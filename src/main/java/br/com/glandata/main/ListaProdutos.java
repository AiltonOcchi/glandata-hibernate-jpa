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
		
		listaProdutos.forEach(produto -> System.out.println(produto.getNome()));
		
	    em.close();
		
	}

}