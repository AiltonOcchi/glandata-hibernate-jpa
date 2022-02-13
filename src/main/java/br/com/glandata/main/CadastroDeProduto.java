package br.com.glandata.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.glandata.model.Produto;

public class CadastroDeProduto {
	public static void main(String[] args) {

		Produto celular = new Produto();
		celular.setNome("Moto G30");
		celular.setDescricao("Aparelho Celular 5G");
		celular.setPreco(new BigDecimal("1200.00"));

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("glandata");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();

	}
}