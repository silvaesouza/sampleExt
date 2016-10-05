package br.com.silvaesouza.sampleext.client;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {
	
	public static final Resources INSTANCE =  GWT.create(Resources.class);

	@Source("br/com/silvaesouza/sampleext/images/title_logo.png")
	ImageResource gwtLogo();

}
