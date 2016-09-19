package br.com.silvaesouza.sampleext.database.impl;

import javax.persistence.EntityManager;

import br.com.silvaesouza.sampleext.database.ConnectionFactory;
import br.com.silvaesouza.sampleext.domain.Person;
import br.com.silvaesouza.sampleext.domain.PersonRepository;

public class PersonRepositoryImpl implements PersonRepository{

	private EntityManager em;
	
	public PersonRepositoryImpl() {
		em = ConnectionFactory.getEntityManager();
	}
	
	@Override
	public void save(Person person) {
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
	}
	@Override
	public Person findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Person person) {
		// TODO Auto-generated method stub
	}
}