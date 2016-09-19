package br.com.silvaesouza.sampleext.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import br.com.silvaesouza.sampleext.client.converter.PersonConverter;
import br.com.silvaesouza.sampleext.client.model.PersonG;
import br.com.silvaesouza.sampleext.client.service.PersonApplication;
import br.com.silvaesouza.sampleext.database.impl.PersonRepositoryImpl;
import br.com.silvaesouza.sampleext.domain.Person;
import br.com.silvaesouza.sampleext.domain.PersonRepository;

public class PersonApplicationImpl extends RemoteServiceServlet implements PersonApplication{

	private static final long serialVersionUID = 1L;
	private PersonConverter pConverter;
	private PersonRepository pRep;
	private Person person;
	
	public PersonApplicationImpl() {
		pConverter = new PersonConverter();
		pRep = new PersonRepositoryImpl();
	}
	
	@Override
	public void save(PersonG personG) {
		System.out.println("1111");
		person = pConverter.personConverterG(personG);
		pRep.save(person);
	}

	@Override
	public void update(PersonG person) {
		// TODO Auto-generated method stub
	}

	@Override
	public PersonG findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PersonG person) {
		// TODO Auto-generated method stub
	}
}