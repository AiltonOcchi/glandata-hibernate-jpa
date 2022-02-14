package br.com.glandata.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.glandata.dao.ProdutoDao;
import br.com.glandata.model.Categoria;
import br.com.glandata.model.Produto;
import br.com.glandata.uil.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {

		Produto celular = new Produto("Moto G30", "Aparelho Celular 5G", new BigDecimal( "1200.00"), Categoria.ELETRONICOS);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();
		produtoDao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}
}