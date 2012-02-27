package me.unoid.server.facebook;

import me.unoid.server.unouser.SaveUnoUser;

import org.json.JSONException;
import org.json.JSONObject;

public class SaveUnoUserFromFacebook {

	public static void save(final JSONObject unoUserJson,
			final JSONObject facebookMe) {

		String unoUserID = null;
		try {
			unoUserID = unoUserJson.getString("ID");
		} catch (JSONException e) {
			// e.printStackTrace();
		}

		String email = getValue(unoUserJson, facebookMe, "email", "email");

		String facebookLogin = getValue(unoUserJson, facebookMe,
				"facebookLogin", "username");

		String image = getImage(unoUserJson, facebookMe, facebookLogin);

		String firstName = getValue(unoUserJson, facebookMe, "firstName",
				"first_name");

		String lastName = getValue(unoUserJson, facebookMe, "lastName",
				"last_name");

		String gender = getValue(unoUserJson, facebookMe, "gender", "gender");

		String birthday = getValue(unoUserJson, facebookMe, "birthday",
				"birthday");

		String maritalStatus = getValue(unoUserJson, facebookMe,
				"maritalStatus", "relationship_status");

		// JSONObject hometown = facebookMe.getJSONObject("hometown");
		// String image = facebookMe.getString("id");

		SaveUnoUser.save(unoUserID, email, facebookLogin, image, firstName,
				lastName, gender, birthday, maritalStatus, null);

	}

	private static String getValue(final JSONObject unoUserJson,
			final JSONObject facebookMe, final String unoUserKey,
			final String facebookKey) {

		String value = null;
		try {
			value = unoUserJson.getString(unoUserKey);
		} catch (JSONException e) {
			// e.printStackTrace();
		}

		if (value == null) {

			try {
				value = facebookMe.getString(facebookKey);
			} catch (JSONException e) {
				// e.printStackTrace();
			}
		}

		return value;
	}

	private static String getImage(final JSONObject unoUserJson,
			final JSONObject facebookMe, final String facebookLogin) {

		String image = null;
		try {
			image = unoUserJson.getString("image");
		} catch (JSONException e) {
			// e.printStackTrace();
		}

		if (image == null) {

			image = "http://graph.facebook.com/" + facebookLogin + "/picture";
		}

		return image;
	}
}
