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

		Categoria categoria = new Categoria("TELEVISORES");
		
		Produto celular1 = new Produto("TV Samsung 50", "Televisor 50 Polegadas", new BigDecimal("1200.00"), categoria);
		Produto celular2 = new Produto("TV Samsung 55", "Televisor 55 Polegadas", new BigDecimal("1500.00"), categoria);
		Produto celular3 = new Produto("TV Samsung 60", "Televisor 60 Polegadas", new BigDecimal("2000.00"), categoria);
		Produto celular4 = new Produto("TV Samsung 65", "Televisor 65 Polegadas", new BigDecimal("2500.00"), categoria);
		Produto celular5 = new Produto("TV Samsung 70", "Televisor 70 Polegadas", new BigDecimal("3000.00"), categoria);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();
		
		categoriaDao.cadastrar(categoria);
		
		produtoDao.cadastrar(celular1);
		produtoDao.cadastrar(celular2);
		produtoDao.cadastrar(celular3);
		produtoDao.cadastrar(celular4);
		produtoDao.cadastrar(celular5);
		
		em.getTransaction().commit();
		em.close();
		
	}
}

