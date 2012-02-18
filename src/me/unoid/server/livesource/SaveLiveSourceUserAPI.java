package me.unoid.server.livesource;

import me.unoid.server.URLUtilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SaveLiveSourceUserAPI {

	private static String saveLiveSourceUserUrl = "http://jsonpfy.projectnection.appspot.com/SaveDataService";

	public static String getLivesourceUser(final String application,
			final String login) {

		String livesourceUser = null;

		String parameters = "kind=User&filterField=" + application
				+ "&filterValue=" + login;

		final String jsonString = URLUtilities.fetchURLGet(
				saveLiveSourceUserUrl, parameters);

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
