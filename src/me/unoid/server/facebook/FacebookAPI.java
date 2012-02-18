package me.unoid.server.facebook;

import me.unoid.server.URLUtilities;

import org.json.JSONException;
import org.json.JSONObject;

public class FacebookAPI {

	private static final String userURL = "https://graph.facebook.com/me";

	public static JSONObject me(final String authToken) {

		JSONObject json = new JSONObject();

		final String jsonString = URLUtilities.fetchURLGet(userURL, authToken);

		try {
			json = new JSONObject(jsonString);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return json;
	}

}
