package br.com.glandata.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.glandata.dao.ProdutoDao;
import br.com.glandata.model.Produto;
import br.com.glandata.uil.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {

		Produto celular = new Produto();
		celular.setNome("Moto G30");
		celular.setDescricao("Aparelho Celular 5G");
		celular.setPreco(new BigDecimal("1200.00"));

		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();
		produtoDao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();

	}
}