package br.com.silvaesouza.sampleext.domain;

public interface PersonRepository {
	public void save(Person person);

	public void update(Person person);

	public Person findById(int id);

	public void delete(Person person);
}