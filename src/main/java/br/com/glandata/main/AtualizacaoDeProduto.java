package br.com.glandata.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.glandata.dao.ProdutoDao;
import br.com.glandata.model.Categoria;
import br.com.glandata.model.Produto;
import br.com.glandata.uil.JPAUtil;

public class AtualizacaoDeProduto {

	public static void main(String[] args) {
		
		Produto produto = new Produto((long) 1);
		produto.setNome("Camisa");
		produto.setDescricao("Camisa Social");
		produto.setPreco(new BigDecimal("90.00"));
		produto.setCategoria(new Categoria((long)44));
		
		EntityManager em = JPAUtil.getEntityManager();
		
		//CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		
		//categoriaDao.cadastrar(produto.getCategoria());
		produtoDao.atualizar(produto);
		
		em.getTransaction().commit();// Não esquecer do Commit
		em.close();
		
		System.out.println(produto.getCategoria());
		
	}
	
}



