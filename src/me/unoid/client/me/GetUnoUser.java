package me.unoid.client.me;

import me.unoid.client.GWTEntryPoint;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

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

				GWTEntryPoint.vpMain.clear();
				GWTEntryPoint.vpMain.add(new MyPanel(obj));
			}
		});

	}
}
