package me.unoid.server.facebook;

import me.unoid.server.utilities.URLUtilities;

import org.json.JSONException;
import org.json.JSONObject;

public class FacebookAPI {

	//private static Logger logger = Logger.getLogger("facebook");

	private static final String userURL = "https://graph.facebook.com/me";

	public static JSONObject me(final String authToken) {

		JSONObject json = new JSONObject();

		final String jsonString = URLUtilities.fetchURLGet(userURL, authToken);

		//logger.log(Level.INFO, "faceboookMejsonString=" + jsonString);

		try {
			json = new JSONObject(jsonString);

		} catch (JSONException e) {
			//e.printStackTrace();
		}

		return json;
	}

}
