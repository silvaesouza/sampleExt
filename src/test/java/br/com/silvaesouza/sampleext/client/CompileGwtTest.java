package br.com.silvaesouza.sampleext.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

import br.com.silvaesouza.sampleext.client.model.PersonG;
import br.com.silvaesouza.sampleext.client.service.PersonApplication;
import br.com.silvaesouza.sampleext.client.service.PersonApplicationAsync;

public class CompileGwtTest extends GWTTestCase {
	@Override
	public String getModuleName() {
		return "br.com.silvaesouza.sampleext.sampleext";
	}

	public void testSandbox() {

		assertTrue(true);
	}

	public void testTimer() {
		// Setup an asynchronous event handler.
		Timer timer = new Timer() {
			public void run() {
				PersonApplicationAsync personSvc = GWT.create(PersonApplication.class);
				
				AsyncCallback<PersonG> callback = new AsyncCallback<PersonG>() {

					@Override
					public void onFailure(Throwable caught) {
						assertTrue(false);
					}

					@Override
					public void onSuccess(PersonG result) {
						// TODO Auto-generated method stub
						
					}
					
				};
				
				//personSvc.findById(1, callback);

				finishTest();
			}
		};

		// Setup an asynchronous event handler.

		/*
		 * // Set up the callback object. AsyncCallback<StockPrice[]> callback =
		 * new AsyncCallback<StockPrice[]>() { public void onFailure(Throwable
		 * caught) { // If the stock code is in the list of delisted codes, //
		 * display // an error message. String details = caught.getMessage(); if
		 * (caught instanceof DelistedException) { details = "Company '" +
		 * ((DelistedException) caught).getSymbol() + "' was delisted"; }
		 * 
		 * errorMsgLabel.setText("Error: " + details);
		 * errorMsgLabel.setVisible(true); }
		 * 
		 * public void onSuccess(StockPrice[] result) { updateTable(result); }
		 * };
		 * 
		 * // Make the call to the stock price service.
		 * stockPriceSvc.getPrices(stocks.toArray(new String[0]), callback);
		 */

		// Set a delay period significantly longer than the
		// event is expected to take.
		delayTestFinish(500);

		// Schedule the event and return control to the test system.
		timer.schedule(100);
	}
}
