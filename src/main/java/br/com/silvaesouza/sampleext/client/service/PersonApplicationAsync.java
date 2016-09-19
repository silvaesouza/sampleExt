package br.com.silvaesouza.sampleext.client.service;
import com.google.gwt.user.client.rpc.AsyncCallback;

import br.com.silvaesouza.sampleext.client.model.PersonG;

public interface PersonApplicationAsync {

	void save(PersonG person, AsyncCallback<Void> callback);

	void update(PersonG person, AsyncCallback<Void> callback);

	void delete(PersonG person, AsyncCallback<Void> callback);

	void findById(int id, AsyncCallback<PersonG> callback);

}