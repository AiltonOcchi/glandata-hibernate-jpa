package br.com.glandata.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.glandata.dao.CategoriaDao;
import br.com.glandata.dao.ProdutoDao;
import br.com.glandata.model.Categoria;
import br.com.glandata.model.Produto;
import br.com.glandata.uil.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {

		Categoria celulares = new Categoria("celulares");
		
		Produto celular = new Produto("Moto G30", "Aparelho Celular 5G", new BigDecimal( "1200.00"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
	}
}

