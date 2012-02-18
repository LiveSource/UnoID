package me.unoid.server.livesource;

import me.unoid.server.URLUtilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetLiveSourceUserAPI {

	private static String getLiveSourceUserUrl = "http://jsonpfy.projectnection.appspot.com/ListDataService"
			+ "?kind=User";

	private static String getUserEmailUrl = "http://jsonpfy.projectnection.appspot.com/ListDataService";

	public static String getLivesourceUser(final String application,
			final String login) {

		String livesourceUser = null;

		String parameters = "kind=User&filterField=" + application
				+ "&filterValue=" + login;

		final String jsonString = URLUtilities.fetchURLGet(
				getLiveSourceUserUrl, parameters);

		try {
			JSONArray json = new JSONArray(jsonString);

			JSONObject user = (JSONObject) json.get(0);

			livesourceUser = user.getString("ID");

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return livesourceUser;
	}

	public static String getLivesourceUser(final String githubLogin) {

		String livesourceUser = null;

		String parameters = "kind=Entity&filterField=githubLogin&filterValue="
				+ githubLogin;

		final String jsonString = URLUtilities.fetchURLGet(getUserEmailUrl,
				parameters);

		try {
			JSONArray json = new JSONArray(jsonString);

			JSONObject user = (JSONObject) json.get(0);

			livesourceUser = user.getString("ID");

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return livesourceUser;
	}
}
