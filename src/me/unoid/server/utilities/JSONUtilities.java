package me.unoid.server.utilities;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtilities {

	public static String getString(final JSONObject json, final String key) {

		String value = null;
		try {
			value = json.getString(key);
		} catch (JSONException e) {
			//e.printStackTrace();
		}
		return value;
	}
}