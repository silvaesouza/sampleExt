package br.com.silvaesouza.sampleext.client.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.DockPanel;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.DateTimePropertyEditor;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.DoublePropertyEditor;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.editing.GridEditing;
import com.sencha.gxt.widget.core.client.grid.editing.GridRowEditing;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;

import br.com.silvaesouza.sampleext.client.model.Plant;
import br.com.silvaesouza.sampleext.client.util.TestData;

public class RowEditingGridExample extends AbstractGridEditingExample {

	public static final int MAX_HEIGHT = 600;
	public static final int MAX_WIDTH = 800;
	public static final int MIN_HEIGHT = 320;
	public static final int MIN_WIDTH = 480;
	// private Widget widget;

	public interface PriceTemplate extends XTemplates {
		@XTemplate("<div style='text-align:right;padding:3px'>{value:currency}</div>")
		SafeHtml render(double value);
	}

	// Setup the property access definitions for the values for the grid columns
	private static final PlaceProperties properties = GWT.create(PlaceProperties.class);

	public RowEditingGridExample() {
		// MODO DO EXEMPLO COM TUDO
		/*
		 * new ExampleContainer(this) .setMaxHeight(MAX_HEIGHT)
		 * .setMaxWidth(MAX_WIDTH) .setMinHeight(MIN_HEIGHT)
		 * .setMinWidth(MIN_WIDTH) .doStandalone();
		 * 
		 * //initWidget(this);
		 */

		// MODO EDITADO CRIANDO O GRID
		ColumnConfig<Plant, String> nameColumn = new ColumnConfig<Plant, String>(properties.name(), 220, "Name");
		ColumnConfig<Plant, String> lightColumn = new ColumnConfig<Plant, String>(properties.light(), 120, "Light");
		ColumnConfig<Plant, Date> dateColumn = new ColumnConfig<Plant, Date>(properties.available(), 95, "Date");
		ColumnConfig<Plant, Boolean> indoorColumn = new ColumnConfig<Plant, Boolean>(properties.indoor(), 65, "Indoor");
		ColumnConfig<Plant, Double> priceColumn = new ColumnConfig<Plant, Double>(properties.price(), 75, "Price");

		List<ColumnConfig<Plant, ?>> l = new ArrayList<ColumnConfig<Plant, ?>>();
		l.add(nameColumn);
		l.add(lightColumn);
		l.add(priceColumn);
		l.add(dateColumn);
		l.add(indoorColumn);

		ColumnModel<Plant> columns = new ColumnModel<Plant>(l);

		// Setup the ListStore.
		final ListStore<Plant> store = new ListStore<Plant>(new ModelKeyProvider<Plant>() {
			@Override
			public String getKey(Plant item) {
				return "" + item.getId();
			}
		});

		List<Plant> plants = TestData.getPlants();
		//store.addAll(plants);

		MyPagingMemoryProxy proxy = new MyPagingMemoryProxy(plants);
		
		//final PlantServiceAsync service = GWT.create(PlantService.class);

		/*RpcProxy<PagingLoadConfig, PagingLoadResult<Plant>> rpxProxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<Plant>>() {
	        @Override
	        public void load(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<Plant>> callback) {
	          service.getPlants(callback);
	        }
	      };*/

		final PagingLoader<PagingLoadConfig, PagingLoadResult<Plant>> loader = new PagingLoader<PagingLoadConfig, PagingLoadResult<Plant>>(
				proxy);
		//loader.setRemoteSort(true);
		loader.addLoadHandler(new LoadResultListStoreBinding<PagingLoadConfig, Plant, PagingLoadResult<Plant>>(store));

		// CONFIGURANDO TOLLBAR DE NAVEGAÇÃO DO GRID
		final PagingToolBar toolBar = new PagingToolBar(5);
		toolBar.setBorders(false);
		toolBar.bind(loader);

		grid = new Grid<Plant>(store, columns) {
			@Override
			protected void onAfterFirstAttach() {
				super.onAfterFirstAttach();
				Scheduler.get().scheduleDeferred(new ScheduledCommand() {
					
					@Override
					public void execute() {
						loader.load();
					}
				});
				
			}
		};
		grid.getView().setAutoExpandColumn(nameColumn);
		grid.setLoader(loader);

		// ACRESCENTANDO EDITOR AO GRID
		DateTimeFormat dateFormat = DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT);
		DateField dateField = new DateField(new DateTimePropertyEditor(dateFormat));
		dateField.setClearValueOnParseError(false);

		NumberField<Double> priceField = new NumberField<Double>(new DoublePropertyEditor());

		final GridEditing<Plant> editing = createGridEditing(grid);
		editing.addEditor(nameColumn, new TextField());
		editing.addEditor(lightColumn, new TextField());
		editing.addEditor(priceColumn, priceField);
		editing.addEditor(dateColumn, dateField);
		editing.addEditor(indoorColumn, new CheckBox());

		/*
		 * VerticalLayoutContainer verticalLayoutContainer = new
		 * VerticalLayoutContainer(); verticalLayoutContainer.add(toolBar, new
		 * VerticalLayoutData(1, -1)); verticalLayoutContainer.add(grid, new
		 * VerticalLayoutData(1, 1));
		 */

		// panel = new ContentPanel();
		DockPanel dock = new DockPanel();
		grid.setHeight("300px");
		dock.add(grid, DockPanel.CENTER);
		dock.add(toolBar, DockPanel.SOUTH);

		// dock.setHeading("Abstract Grid Editing");
		dock.setHeight("300px");
		dock.setWidth("600px");

		initWidget(dock);
	}

	/*
	 * @Override public Widget asWidget() { if (widget == null) { widget =
	 * super.asWidget(); customize(); }
	 * 
	 * return widget; }
	 * 
	 * @Override public void onModuleLoad() { new ExampleContainer(this)
	 * .setMaxHeight(MAX_HEIGHT) .setMaxWidth(MAX_WIDTH)
	 * .setMinHeight(MIN_HEIGHT) .setMinWidth(MIN_WIDTH) .doStandalone(); }
	 */

	/*
	 * Converter<String, Double> doubleConverter = new Converter<String,
	 * Double>() {
	 * 
	 * @Override public String convertFieldValue(Double object) { return object
	 * == null ? "" : object.toString(); }
	 * 
	 * @Override public Double convertModelValue(String object) { return
	 * Double.valueOf(object); } };
	 */

	protected void customize() {
		panel.setHeading("Row Editable Grid");
	}

	@Override
	protected GridEditing<Plant> createGridEditing(Grid<Plant> editableGrid) {
		GridRowEditing<Plant> rowEditing = new GridRowEditing<Plant>(editableGrid);

		/*
		 * ColumnConfig<Plant, Double> price =
		 * editableGrid.getColumnModel().getColumn(2);
		 * rowEditing.addRenderer(price, new AbstractSafeHtmlRenderer<Double>()
		 * { PriceTemplate template = GWT.create(PriceTemplate.class);
		 * 
		 * @Override public SafeHtml render(Double object) { return
		 * template.render(object); } });
		 */

		return rowEditing;
	}

}