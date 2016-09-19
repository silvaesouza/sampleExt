package br.com.silvaesouza.sampleext.client.service;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import br.com.silvaesouza.sampleext.client.model.Plant;

@RemoteServiceRelativePath ("plantService")
public interface PlantService extends RemoteService{

	public List<Plant> listAll();
	
	
}