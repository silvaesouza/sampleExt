package br.com.silvaesouza.sampleext.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import br.com.silvaesouza.sampleext.client.service.FormExampleService;
import br.com.silvaesouza.sampleext.client.vo.FormExampleVO;

public class FormExampleServiceImpl extends RemoteServiceServlet implements FormExampleService{

	private static final long serialVersionUID = 1L;
	
	public FormExampleServiceImpl() {
	}
	
	@Override
	public String save(FormExampleVO form) {
		return "Success... " + form;
	}

}