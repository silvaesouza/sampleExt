package br.com.silvaesouza.sampleext.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

import br.com.silvaesouza.sampleext.client.model.Contact;
import br.com.silvaesouza.sampleext.client.model.ContactProperties;
import br.com.silvaesouza.sampleext.client.util.ContactTestData;

public class SimpleGrid extends Grid<Contact> {

	private static final ContactProperties props = GWT.create(ContactProperties.class);

	private static ColumnConfig<Contact, String> nameCol = new ColumnConfig<Contact, String>(props.name(), 150, "Name");
	private static ColumnConfig<Contact, String> phoneCol = new ColumnConfig<Contact, String>(props.phone(), 75,
			"Phone");
	private static ColumnConfig<Contact, String> emailCol = new ColumnConfig<Contact, String>(props.email(), 150,
			"Email");

	public SimpleGrid() {

		super(generateData(), createColumnModel());

		this.getView().setStripeRows(true);
		this.getView().setColumnLines(true);
		this.getView().setAutoExpandColumn(nameCol);
		this.setBorders(false);
		this.setColumnReordering(true);
		
	}

	private static ColumnModel<Contact> createColumnModel() {

		List<ColumnConfig<Contact, ?>> columnConfigList = new ArrayList<ColumnConfig<Contact, ?>>();
		columnConfigList.add(nameCol);
		columnConfigList.add(phoneCol);
		columnConfigList.add(emailCol);

		return new ColumnModel<Contact>(columnConfigList);
	}

	private static ListStore<Contact> generateData() {

		ListStore<Contact> store = new ListStore<Contact>(props.key());
		store.addAll(ContactTestData.generateData());

		return store;
	}
}