package br.com.glandata.main;

import javax.persistence.EntityManager;

import br.com.glandata.dao.ProdutoDao;
import br.com.glandata.model.Produto;
import br.com.glandata.uil.JPAUtil;

public class RemoveProduto {
	
	public static void main(String[] args) {
		
		Produto produto =  new Produto(14l);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		
		produtoDao.remover(produto);
		
		em.flush();
		
		//em.getTransaction().commit();
		em.close();
	}
	
}
