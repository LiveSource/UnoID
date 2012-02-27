package me.unoid.server.facebook;

import me.unoid.server.unouser.SaveUnoUser;
import me.unoid.server.utilities.JSONUtilities;

import org.json.JSONException;
import org.json.JSONObject;

public class SaveUnoUserFromFacebook {

	public static void save(final JSONObject unoUserJson,
			final JSONObject facebookMe) {

		updateValue(unoUserJson, facebookMe, "email", "email");

		updateImage(unoUserJson, facebookMe);

		updateValue(unoUserJson, facebookMe, "firstName", "first_name");

		updateValue(unoUserJson, facebookMe, "lastName", "last_name");

		updateValue(unoUserJson, facebookMe, "gender", "gender");

		updateValue(unoUserJson, facebookMe, "birthday", "birthday");

		updateValue(unoUserJson, facebookMe, "maritalStatus",
				"relationship_status");

		// JSONObject hometown = facebookMe.getJSONObject("hometown");
		// String image = facebookMe.getString("id");

		SaveUnoUser.save(unoUserJson);

	}

	private static void updateValue(JSONObject unoUserJson,
			final JSONObject facebookMe, final String unoUserKey,
			final String facebookKey) {

		String value = JSONUtilities.getString(unoUserJson, unoUserKey);

		if (value == null) {
			value = JSONUtilities.getString(facebookMe, facebookKey);

			try {
				unoUserJson.put(unoUserKey, value);
			} catch (JSONException e) {
				// e.printStackTrace();
			}
		}
	}

	private static void updateImage(final JSONObject unoUserJson,
			final JSONObject facebookMe) {

		String image = JSONUtilities.getString(unoUserJson, "image");

		if (image == null) {

			String facebookLogin = JSONUtilities.getString(unoUserJson,
					"facebookLogin");

			image = "http://graph.facebook.com/" + facebookLogin + "/picture";

			try {
				unoUserJson.put("image", image);
			} catch (JSONException e) {
				// e.printStackTrace();
			}
		}
	}
}
