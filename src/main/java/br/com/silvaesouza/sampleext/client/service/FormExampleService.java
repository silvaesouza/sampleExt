package br.com.silvaesouza.sampleext.client.service;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import br.com.silvaesouza.sampleext.client.vo.FormExampleVO;

@RemoteServiceRelativePath ("formExampleService")
public interface FormExampleService extends RemoteService{

	public String save(FormExampleVO form);
	
}