package br.com.silvaesouza.sampleext.client.ui;

import java.util.List;

import com.google.gwt.core.client.Callback;
import com.sencha.gxt.data.shared.loader.MemoryProxy;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;

import br.com.silvaesouza.sampleext.client.model.Plant;
import br.com.silvaesouza.sampleext.client.util.TestData;

public class MyPagingMemoryProxy extends MemoryProxy<PagingLoadConfig, PagingLoadResult<Plant>> {
  private final List<Plant> totalList;
  
  public MyPagingMemoryProxy(List<Plant> totalList) {
    super(null);//data is useless in this case, memoryProxy only designed to hold, not to search
    this.totalList = totalList;
  }
  
  @Override
  public void load(PagingLoadConfig config, Callback<PagingLoadResult<Plant>, Throwable> callback) {
		callback.onSuccess(new PagingLoadResultBean<Plant>(TestData.getPlants(config.getOffset(), config.getLimit()), totalList.size(),
				config.getOffset()));
  }
}