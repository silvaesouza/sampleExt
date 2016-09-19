package br.com.silvaesouza.sampleext.client.ui;
import java.util.Comparator;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;

import br.com.silvaesouza.sampleext.client.model.ContactDatabase.ContactInfo;
 
/**
 * MyPaginationDataGrid extends PagingDataGrid to add Columns into Grid by implementation of 
 * initTableColumns() method
 * 
 * @author Ravi Soni
 *
 * @param <T>
 */
public class MyPaginationDataGrid<T> extends PagingGridProvider<T>{
     
    @Override
    public void initTableColumns(DataGrid<T> dataGrid,
            ListHandler<T> sortHandler) {
        Column<T, String> firstNameColumn = new Column<T, String>(
                new TextCell()) {
            @Override
            public String getValue(T object) {
                return ((ContactInfo) object).getFirstName();
            }
        };
        firstNameColumn.setSortable(true);
        sortHandler.setComparator(firstNameColumn, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return ((ContactInfo) o1).getFirstName().compareTo(
                        ((ContactInfo) o2).getFirstName());
            }
        });
        dataGrid.addColumn(firstNameColumn, "First Name");
 
        dataGrid.setColumnWidth(firstNameColumn, 20, Unit.PCT);
 
        // Last name.
        Column<T, String> lastNameColumn = new Column<T, String>(new TextCell()) {
            @Override
            public String getValue(T object) {
                return ((ContactInfo) object).getLastName();
            }
        };
        lastNameColumn.setSortable(true);
        sortHandler.setComparator(lastNameColumn, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return ((ContactInfo) o1).getLastName().compareTo(
                        ((ContactInfo) o2).getLastName());
            }
        });
        dataGrid.addColumn(lastNameColumn, "Last Name");
        dataGrid.setColumnWidth(lastNameColumn, 20, Unit.PCT);
    }
 
}