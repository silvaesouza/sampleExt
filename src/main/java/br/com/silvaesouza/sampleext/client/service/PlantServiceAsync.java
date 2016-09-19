package br.com.silvaesouza.sampleext.client.service;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import br.com.silvaesouza.sampleext.client.model.Plant;

public interface PlantServiceAsync {

	public List<Plant> listAll(AsyncCallback<List<Plant>> callback);
	
	
}