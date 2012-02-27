package me.unoid.client.me;

import me.unoid.client.Utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class GetUnoUser {

	public static void get(final String unoUserID) {

		final UnoIDServiceAsync unoIDService = GWT.create(UnoIDService.class);

		unoIDService.getUnoUser(unoUserID, new AsyncCallback<String>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(final String jsonResults) {

				JSONObject obj = (JSONObject) JSONParser
						.parseStrict(jsonResults);

				String unoUserID = ConvertJson.convertToString(obj
						.get("ID"));
				
				RootPanel.get().clear();
				RootPanel.get().add(new MyPanel(jsonResults));
			}
		});

	}
}
