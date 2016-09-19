package br.com.silvaesouza.sampleext.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import br.com.silvaesouza.sampleext.client.model.Plant;
import br.com.silvaesouza.sampleext.client.service.PlantService;
import br.com.silvaesouza.sampleext.client.util.TestData;

public class PlantServiceImpl extends RemoteServiceServlet implements PlantService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlantServiceImpl() {
	}

	@Override
	public List<Plant> listAll() {
		return TestData.getPlants();
	}
	
}