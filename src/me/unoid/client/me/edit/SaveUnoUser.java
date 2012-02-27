package me.unoid.client.me.edit;

import me.unoid.client.GWTEntryPoint;
import me.unoid.client.me.MyPanel;
import me.unoid.client.me.UnoIDService;
import me.unoid.client.me.UnoIDServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SaveUnoUser {

	public static void save(final String unoUserJsonString) {

		final UnoIDServiceAsync unoIDService = GWT.create(UnoIDService.class);

		unoIDService.saveUnoUser(unoUserJsonString, new AsyncCallback<Void>() {

			public void onFailure(final Throwable caught) {
				System.out.println(caught);
			}

			public void onSuccess(Void results) {

				JSONObject obj = (JSONObject) JSONParser
						.parseStrict(unoUserJsonString);

				GWTEntryPoint.vpMain.clear();
				GWTEntryPoint.vpMain.add(new MyPanel(obj));
			}
		});

	}
}
