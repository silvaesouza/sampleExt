package br.com.silvaesouza.sampleext.client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateTest {
	
	private static EntityManager em = null;

    @BeforeClass
    public static void setUpClass() throws Exception {
        if (em == null) {
            em = (EntityManager) Persistence.createEntityManagerFactory("JPAUnit").createEntityManager();
        }
    }

    @Test
    public void testAllOps(){
        // Start a transaction
        em.getTransaction().begin();
    }

}
