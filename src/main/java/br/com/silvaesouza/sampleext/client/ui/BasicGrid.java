package br.com.silvaesouza.sampleext.client.ui;
import java.util.ArrayList;
  import java.util.List;
  import com.google.gwt.core.shared.GWT;
  import com.google.gwt.user.client.ui.Composite;
  import com.sencha.gxt.core.client.ValueProvider;
  import com.sencha.gxt.data.shared.ListStore;
  import com.sencha.gxt.data.shared.ModelKeyProvider;
  import com.sencha.gxt.data.shared.PropertyAccess;
  import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
  import com.sencha.gxt.widget.core.client.grid.ColumnModel;
  import com.sencha.gxt.widget.core.client.grid.Grid;
  import com.sencha.gxt.widget.core.client.grid.GridView;
	
  public class BasicGrid extends Composite {
    
	// Basic model for each row in the grid
    public class NameModel {
      private int id;
      private String name;
      public int getId() {
        return id;
      }
      public void setId(int id) {
        this.id = id;
      }
      public String getName() {
        return name;
      }
      public void setName(String name) {
        this.name = name;
      }
    }
	  
    // Property access definitions for the values in the NameModel
    public interface GridProperties extends PropertyAccess<NameModel> {
      ModelKeyProvider<NameModel> id();
      ValueProvider<NameModel, String> name();
    }
	  
    // Setup the property access definitions for the values for the grid columns
    public static GridProperties gridProperties = GWT.create(GridProperties.class);
	
    public BasicGrid() {
      // Setup the ListStore.
      ListStore<NameModel> listStore = new ListStore<NameModel>(gridProperties.id());
      NameModel nameModel = new NameModel();
      nameModel.setId(1);
      nameModel.setName("Adriano");
      listStore.add(nameModel);
	
      // Setup the grid columns
      ColumnConfig<NameModel, String> nameCol = new ColumnConfig<NameModel, String>(gridProperties.name(), 50, "Name");
      List<ColumnConfig<NameModel, ?>> columns = new ArrayList<ColumnConfig<NameModel, ?>>();
      columns.add(nameCol);
      ColumnModel<NameModel> columnModel = new ColumnModel<NameModel>(columns);
	
      // Setup the grid view for styling
      GridView<NameModel> gridView = new GridView<NameModel>();
      gridView.setAutoExpandColumn(nameCol);
	    
      // Setup the grid
      Grid<NameModel> grid = new Grid<NameModel>(listStore, columnModel, gridView);
      // Setup a size if not depending on the parent container to give it a size. 
      grid.setPixelSize(300, 200);
	    
      initWidget(grid);
    }
  }