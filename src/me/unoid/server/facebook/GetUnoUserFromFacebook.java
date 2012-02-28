package me.unoid.server.facebook;

import java.util.logging.Logger;

import me.unoid.server.unouser.GetUnoUser;
import me.unoid.server.utilities.JSONUtilities;

import org.json.JSONException;
import org.json.JSONObject;

public class GetUnoUserFromFacebook {

	private static Logger logger = Logger.getLogger("UnoIDMe");

	public static String get(final String authenticationToken) {

		JSONObject facebookMe = FacebookAPI.me(authenticationToken);

		String unoUser = saveUnoUser(facebookMe);

		return unoUser;
	}

	private static String saveUnoUser(JSONObject facebookMe) {

		String facebookLogin = JSONUtilities.getString(facebookMe, "username");
		if (facebookLogin == null) {
			facebookLogin = JSONUtilities.getString(facebookMe, "id");
		}

		JSONObject unoUserJson = GetUnoUser.getByFacebookLogin(facebookLogin);

		String email = JSONUtilities.getString(facebookMe, "email");

		if (unoUserJson == null) {

			unoUserJson = GetUnoUser.getByEmail(email);
			if (unoUserJson != null
					&& JSONUtilities.getString(unoUserJson, "facebookLogin") == null) {
				try {
					unoUserJson.put("facebookLogin", facebookLogin);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}

		if (unoUserJson == null) {

			String unoUserID = email;
			if (email == null) {
				unoUserID = "FB_" + facebookLogin;
			}

			unoUserJson = createUnoUser(unoUserID, facebookLogin, email);
		}

		//logger.log(Level.INFO, "unoUserJson=" + unoUserJson);

		SaveUnoUserFromFacebook.save(unoUserJson, facebookMe);

		return unoUserJson.toString();
	}

	private static JSONObject createUnoUser(final String unoUserID,
			final String facebookLogin, final String email) {

		JSONObject jsonObject = new JSONObject();

		try {

			jsonObject.put("ID", unoUserID);
			jsonObject.put("facebookLogin", facebookLogin);
			jsonObject.put("email", email);

		} catch (JSONException e) {
			// e.printStackTrace();
		}

		return jsonObject;
	}

}
