package br.com.silvaesouza.sampleext.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class ConnectionFactory {
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("JPAUnit");
	private static EntityManager entityManager;

	public static EntityManager getEntityManager() {
		entityManager = emf.createEntityManager();
		return entityManager;
	}

	public static Session getSession() {
		return (Session) entityManager.getDelegate();
	}
}