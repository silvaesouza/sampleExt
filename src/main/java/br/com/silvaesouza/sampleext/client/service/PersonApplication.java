package br.com.silvaesouza.sampleext.client.service;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import br.com.silvaesouza.sampleext.client.model.PersonG;

@RemoteServiceRelativePath ("personController")
public interface PersonApplication extends RemoteService{

	public void save(PersonG person);
	public void update(PersonG person);
	public PersonG findById(int id);
	public void delete(PersonG person);
	
	
}