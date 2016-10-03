package br.com.silvaesouza.sampleext.client.app.ui;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
 
public class MyDockLayoutPanel extends Composite {
 
    private static MyDockLayoutPanelUiBinder uiBinder = GWT
            .create(MyDockLayoutPanelUiBinder.class);
    
    interface MyDockLayoutPanelUiBinder extends
            UiBinder<DockLayoutPanel, MyDockLayoutPanel> {
    }
    
    @UiField
    SplitLayoutPanel split;
    
    @UiField
    FlowPanel flowWest;
 
    public MyDockLayoutPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        split.getElement().getStyle()
        	.setProperty("border", "3px solid #000000");
        
        split.forceLayout();
        
        flowWest.getElement().getStyle()
        	.setProperty("border", "3px solid blue");
    }
}