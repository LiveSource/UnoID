package me.unoid.server.facebook;

import me.unoid.server.unouser.GetUnoUser;

import org.json.JSONException;
import org.json.JSONObject;

public class GetUnoUserIDFromFacebook {

	public static String get(final String authenticationToken) {

		JSONObject facebookMe = FacebookAPI.me(authenticationToken);

		String unoUserID = getUnoUserIDFromFacebook(facebookMe);

		return unoUserID;
	}

	private static String getUnoUserIDFromFacebook(JSONObject facebookMe) {

		String facebookLogin = null;
		try {
			facebookLogin = facebookMe.getString("username");
		} catch (JSONException e) {
			// e.printStackTrace();
		}

		String email = null;
		try {
			email = facebookMe.getString("email");
		} catch (JSONException e) {
			// e.printStackTrace();
		}

		JSONObject unoUserJson = GetUnoUser.getByFacebookLogin(facebookLogin);

		String unoUserID = GetUnoUser.getUnoUserID(unoUserJson);

		if (unoUserID == null) {

			unoUserJson = GetUnoUser.getByEmail(email);

			unoUserID = GetUnoUser.getUnoUserID(unoUserJson);
		}

		if (unoUserID == null) {

			unoUserID = "FB_" + facebookLogin;

			unoUserJson = createUnoUser(unoUserID);
		}

		SaveUnoUserFromFacebook.save(unoUserJson, facebookMe);

		return unoUserID;
	}

	private static JSONObject createUnoUser(final String unoUserID) {

		JSONObject jsonObject = new JSONObject();

		try {

			jsonObject.put("ID", unoUserID);

		} catch (JSONException e) {

			// e.printStackTrace();
		}

		return jsonObject;
	}

}
