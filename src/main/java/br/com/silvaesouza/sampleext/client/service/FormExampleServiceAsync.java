package br.com.silvaesouza.sampleext.client.service;
import com.google.gwt.user.client.rpc.AsyncCallback;

import br.com.silvaesouza.sampleext.client.vo.FormExampleVO;

public interface FormExampleServiceAsync {

	void save(FormExampleVO form, AsyncCallback<String> callback);

}