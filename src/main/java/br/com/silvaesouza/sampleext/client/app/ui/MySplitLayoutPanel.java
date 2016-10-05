package br.com.silvaesouza.sampleext.client.app.ui;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
 
public class MySplitLayoutPanel extends Composite {
 
    private static MySplitLayoutPanelUiBinder uiBinder = GWT
            .create(MySplitLayoutPanelUiBinder.class);
 
    interface MySplitLayoutPanelUiBinder extends
            UiBinder<SplitLayoutPanel, MySplitLayoutPanel> {
    }
 
    public MySplitLayoutPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}