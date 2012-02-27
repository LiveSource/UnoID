package me.unoid.server.unouser;

import me.unoid.server.URLUtilities;

public class GetUnoUserByID {

	// http://jsonpfy.unoidme.appspot.com/GetDataService
	// ?kind=Entity
	// &ID=FB_alline.oliveira

	private static String getUnoUserUrl = "http://jsonpfy.unoidme.appspot.com/GetDataService";

	public static String get(final String unoUserID) {

		String parameters = "kind=Entity&ID=" + unoUserID;

		final String jsonString = URLUtilities.fetchURLPost(getUnoUserUrl,
				parameters);

		return jsonString;
	}
}
