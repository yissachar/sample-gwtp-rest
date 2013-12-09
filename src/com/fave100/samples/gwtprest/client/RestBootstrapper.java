package com.fave100.samples.gwtprest.client;

import com.fave100.samples.gwtprest.shared.FaveItemCollection;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Bootstrapper;

public class RestBootstrapper implements Bootstrapper {

	DispatchAsync _dispatcher;
	FaveItemService _faveItemService;

	@Inject
	public RestBootstrapper(DispatchAsync dispatcher, FaveItemService faveItemService) {
		_dispatcher = dispatcher;
		_faveItemService = faveItemService;
	}

	@Override
	public void onBootstrap() {
		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		
		sendButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final long startTime = System.currentTimeMillis();
				_dispatcher.execute(_faveItemService.listFaveItems(), new AsyncCallback<FaveItemCollection>() {

					@Override
					public void onFailure(Throwable caught) {
						System.out.println("error");
					}

					@Override
					public void onSuccess(FaveItemCollection result) {
						errorLabel.setText("We retrieved "+result.getItems().size()+" messages in "+(System.currentTimeMillis()-startTime) + " ms");
					}
				});			
			}
		});
	}
}
