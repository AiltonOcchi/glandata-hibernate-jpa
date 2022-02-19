package br.com.glandata.main;

import javax.persistence.EntityManager;

import br.com.glandata.model.Categoria;
import br.com.glandata.uil.JPAUtil;

public class EstadosPersistenciaJPA {
	public static void main(String[] args) {

		Categoria celulares = new Categoria("Celulares");// Estado transiente, n�o gerenciado
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(celulares);// estado gerenciado
		
		celulares.setNome("COMPUTADORES"); // continua gerenciado

		em.getTransaction().commit();// faz altera��o do nome
		em.close(); // estado detached
	}
}