package me.unoid.server.facebook;

import me.unoid.server.unouser.GetUnoUser;

import org.json.JSONException;
import org.json.JSONObject;

public class GetUnoUserFromFacebook {

	public static String get(final String authenticationToken) {

		JSONObject facebookMe = FacebookAPI.me(authenticationToken);

		String unoUserID = saveUnoUser(facebookMe);

		return unoUserID;
	}

	private static String saveUnoUser(JSONObject facebookMe) {

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

		if (unoUserJson == null) {

			unoUserJson = GetUnoUser.getByEmail(email);
		}

		if (unoUserJson == null) {

			String unoUserID = "FB_" + facebookLogin;

			unoUserJson = createUnoUser(unoUserID);
		}

		SaveUnoUserFromFacebook.save(unoUserJson, facebookMe);

		return GetUnoUser.getUnoUserID(unoUserJson);
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
