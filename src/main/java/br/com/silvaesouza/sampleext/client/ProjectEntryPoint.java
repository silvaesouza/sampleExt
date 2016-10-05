package br.com.silvaesouza.sampleext.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.core.client.GXT;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Resizable;
import com.sencha.gxt.widget.core.client.Resizable.Dir;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.info.Info;

import br.com.silvaesouza.sampleext.client.animation.CustomAnimation;
import br.com.silvaesouza.sampleext.client.app.ui.MyDockLayoutPanel;
import br.com.silvaesouza.sampleext.client.app.ui.MySplitLayoutPanel;
import br.com.silvaesouza.sampleext.client.model.ContactDatabase;
import br.com.silvaesouza.sampleext.client.model.ContactDatabase.ContactInfo;
import br.com.silvaesouza.sampleext.client.model.PersonG;
import br.com.silvaesouza.sampleext.client.service.PersonApplication;
import br.com.silvaesouza.sampleext.client.service.PersonApplicationAsync;
import br.com.silvaesouza.sampleext.client.ui.BasicGrid;
import br.com.silvaesouza.sampleext.client.ui.BasicTabExample;
import br.com.silvaesouza.sampleext.client.ui.FormsExample;
import br.com.silvaesouza.sampleext.client.ui.MyPaginationDataGrid;
import br.com.silvaesouza.sampleext.client.ui.RowEditingGridExample;
import br.com.silvaesouza.sampleext.client.ui.SimpleGrid;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProjectEntryPoint implements EntryPoint {

	/* Main Elements of the Website which represent the divs in the HTML-Page */
	//private FlowPanel header = new FlowPanel();
	//private FlowPanel content = new FlowPanel();
	//private FlowPanel footer = new FlowPanel();
	
	private TextButton buttonPagingDataGrid;
	private TextButton textButtonBasicTab;
	private TextButton textButtonConexao;
	private TextButton buttonRowGridEditor;
	private TextButton buttonFormExample;
	private TextButton buttonUIBindDock;
	private TextButton buttonUIBindSplit;
	private TextButton buttonAnimation;

	@Override
	public void onModuleLoad() {
		RootPanel.get("header").clear(true);
		addButtonsInit();
	}

	private void addButtonsInit() {
		//BUTTON PAGING GRID
		buttonPagingDataGrid = new TextButton("Paging Data Grid");
		buttonPagingDataGrid.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				setContent(Examples.PAGINGDATAGRID);
			}
		});

		//BUTTON BASIC TAB
		textButtonBasicTab = new TextButton("Basic Tab");
		textButtonBasicTab.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				setContent(Examples.BASICTAB);
			}
		});

		//BUTTON CONEXAO
		textButtonConexao = new TextButton("Teste Conexão");
		textButtonConexao.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				PersonApplicationAsync app = GWT.create(PersonApplication.class);

				app.save(getPerson(), new AsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {
						Info.display("Sucesso", "");
					}

					@Override
					public void onFailure(Throwable caught) {
						Info.display("Falha", caught.getMessage());
					}
				});
			}
		});
		
		//BUTTON ROW GRID EDITOR
		buttonRowGridEditor = new TextButton("GRID Editor");
		buttonRowGridEditor.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				setContent(Examples.ROWGRIDEDITOR);
			}
		});
		
		// BUTTON ROW GRID EDITOR
		buttonFormExample = new TextButton("Form Example");
		buttonFormExample.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				setContent(Examples.FORMEXAMPLE);
			}
		});
		
		// BUTTON UI BIND DOCK
		buttonUIBindDock = new TextButton("UI Bind Dock");
		buttonUIBindDock.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				setContent(Examples.UIBINDDOCKLAYOUT);
			}
		});
		
		// BUTTON UI BIND SPLIT
		buttonUIBindSplit = new TextButton("UI Bind Split");
		buttonUIBindSplit.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				setContent(Examples.UIBINDSPLITLAYOUT);
			}
		});
		
		// BUTTON UI BIND SPLIT
		buttonAnimation = new TextButton("Animation");
		buttonAnimation.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				setContent(Examples.ANIMATION);
			}
		});
		
		RootPanel.get("header").add(buttonPagingDataGrid);
		RootPanel.get("header").add(textButtonBasicTab);
		RootPanel.get("header").add(textButtonConexao);
		RootPanel.get("header").add(buttonRowGridEditor);
		RootPanel.get("header").add(buttonFormExample);
		RootPanel.get("header").add(buttonUIBindDock);
		RootPanel.get("header").add(buttonUIBindSplit);
		RootPanel.get("header").add(buttonAnimation);
	}
	
	private PersonG getPerson(){
		PersonG person = new PersonG();
		
		person.setName("AAAA");
		person.setEmail("a@a.com");
		person.setPhone("11111");
		person.setCell("aaaaaa");
		return person;
	}

	public void setContent(Examples example) {
		switch (example) {
		case PAGINGDATAGRID:
			addPagingDataGrid();
			break;
		case BASICTAB:
			addBasicTab();
			break;
		case ROWGRIDEDITOR:
			addRowGridEditor();
			break;
		case FORMEXAMPLE:
			addFormExample();
			break;
		case UIBINDDOCKLAYOUT:
			addUiBindDockLayoutExample();
			break;
		case UIBINDSPLITLAYOUT:
			addUiBindSplitLayoutExample();
			break;
		case ANIMATION:
			animation();
			break;
		default:
			break;
		}
	}
	
	private void addFormExample() {
		FormsExample forms = new FormsExample();
		
		RootPanel.get("content").clear(true);
		RootPanel.get("content").add(forms);
	}
	
	private void animation() {
		AbsolutePanel absolutePanel = null;
		final Button runButton = new Button("Run");
        runButton.addStyleName("runButton");
 
        absolutePanel = new AbsolutePanel();
        absolutePanel.setSize("350px", "350px");
        absolutePanel.getElement().setId("cwAbsolutePanel");
        absolutePanel.addStyleName("absolutePanel");
 
        final Image img = new Image(Resources.INSTANCE.gwtLogo());
        absolutePanel.add(img, 10, 10);
 
        runButton.addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                CustomAnimation animation = new CustomAnimation(img.getElement());
                animation.scrollTo(100, 200, 2000);
            }
        });
 
        HorizontalPanel mainLayout = new HorizontalPanel();
        mainLayout.setSpacing(10);
        mainLayout.add(runButton);
        mainLayout.add(absolutePanel);
 
        RootPanel.get("content").clear(true);
        RootPanel.get("content").add(mainLayout);
	}
	
	private void addUiBindDockLayoutExample() {
		MyDockLayoutPanel myDoc = new MyDockLayoutPanel();
		
		RootLayoutPanel.get().add(myDoc);
	}
	
	private void addUiBindSplitLayoutExample() {
		MySplitLayoutPanel myDoc = new MySplitLayoutPanel();
		
		RootLayoutPanel.get().add(myDoc);
	}

	private void addRowGridEditor() {
		// TODO Auto-generated method stub
		RowEditingGridExample gridEditor = new RowEditingGridExample();
		
		RootPanel.get("content").clear(true);
		RootPanel.get("content").add(gridEditor);
	}

	private void addPagingDataGrid() {
		// ADD PAGINGDATAGRID
		MyPaginationDataGrid<ContactInfo> pagingDataGrid = new MyPaginationDataGrid<ContactInfo>();

		pagingDataGrid.setHeight("500px");
		pagingDataGrid.setDataList(ContactDatabase.get().generateContacts(100));
		RootPanel.get("content").clear(true);
		RootPanel.get("content").add(pagingDataGrid);
	}

	private void addButtonGXTWorks() {
		// ADD BUTTON
		String version = GXT.getVersion().getRelease();
		TextButton textButton = new TextButton("Verify GXT Works: Version=" + version);
		textButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				MessageBox messageBox = new MessageBox("GXT Works.");
				messageBox.show();
			}
		});

		RootPanel.get("footer").clear(true);
		RootPanel.get("footer").add(textButton);
	}

	private void addBasicTab() {
		BasicTabExample tabs = new BasicTabExample();
		RootPanel.get("content").clear(true);
		RootPanel.get("content").add(tabs);
	}

	private void addBasicGrid() {
		BasicGrid grid = new BasicGrid();
		RootPanel.get().add(grid);
	}

	private void addSimpleGrid() {
		// ADD GRID
		ContentPanel root = new ContentPanel();

		root.setHeading("Simple Grid");
		root.setPixelSize(550, 250);
		root.addStyleName("margin-10");

		Resizable r = new Resizable(root, Dir.E, Dir.SE, Dir.S);
		r.setMinHeight(200);
		r.setMinWidth(300);

		SimpleGrid grid = new SimpleGrid();

		root.add(grid);

		// root.setWidget();

		RootPanel.get("content").clear(true);
		RootPanel.get("content").add(root);
	}

}
