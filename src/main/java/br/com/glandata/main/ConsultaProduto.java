package br.com.glandata.main;

import javax.persistence.EntityManager;

import br.com.glandata.dao.ProdutoDao;
import br.com.glandata.model.Produto;
import br.com.glandata.uil.JPAUtil;

public class ConsultaProduto {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto produto =  produtoDao.buscarPorId(13l);
		System.out.println("Dados do Produto"+ produto);
		
		System.out.println("Preço da celular: "+ produtoDao.buscarPrecoDoProdutoPeloNome("Moto G30"));
		
	    em.close();
		
	}

}


