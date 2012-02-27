package me.unoid.server.unouser;

import me.unoid.server.URLUtilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetUnoUser {

	// http://jsonpfy.unoidme.appspot.com/ListDataService
	// ?kind=Entity
	// &filterField=email&filterValue=alline.oliveira@gmail.com

	private static String getUnoUserEmailUrl = "http://jsonpfy.unoidme.appspot.com/ListDataService";

	public static JSONObject getByEmail(final String email) {

		String parameters = "kind=Entity&filterField=email&filterValue="
				+ email;

		final String jsonString = URLUtilities.fetchURLPost(getUnoUserEmailUrl,
				parameters);

		return getUserJson(jsonString);
	}

	public static JSONObject getByFacebookLogin(final String facebookLogin) {

		String parameters = "kind=Entity&filterField=facebookLogin&filterValue="
				+ facebookLogin;

		final String jsonString = URLUtilities.fetchURLPost(getUnoUserEmailUrl,
				parameters);

		return getUserJson(jsonString);

	}

	public static JSONObject getByGithubLogin(final String githubLogin) {

		String parameters = "kind=Entity&filterField=githubLogin&filterValue="
				+ githubLogin;

		final String jsonString = URLUtilities.fetchURLPost(getUnoUserEmailUrl,
				parameters);

		return getUserJson(jsonString);

	}

	public static String getUnoUserID(final JSONObject unoUserJson) {

		String unoUserID = null;

		try {
			unoUserID = unoUserJson.getString("ID");

		} catch (JSONException e) {
			// e.printStackTrace();
		}

		return unoUserID;
	}

	private static JSONObject getUserJson(String jsonString) {

		JSONObject userJsonObject = new JSONObject();

		if (jsonString != null && !jsonString.equals("")) {

			try {

				JSONArray json = new JSONArray(jsonString);
				userJsonObject = (JSONObject) json.get(0);

			} catch (JSONException e) {
				// e.printStackTrace();
			}
		}

		return userJsonObject;
	}

}
