package me.unoid.server.unouser;

import me.unoid.server.URLUtilities;

public class SaveUnoUser {

	private static String saveUnoUserUrl = "http://jsonpfy.unoidme.appspot.com/SaveDataService";

	public static void save(final String unoUserID, final String email,
			final String facebookLogin, String image, String firstName,
			final String lastName, final String gender, final String birthday,
			final String maritalStatus, final String city) {

		String parameters = "kind=Entity&ID=" + unoUserID;

		if (email != null) {
			parameters += "&fieldsKind=String&fieldsName=email&fieldsValue="
					+ URLUtilities.encode(email);
		}

		if (image != null) {
			parameters += "&fieldsKind=String&fieldsName=image&fieldsValue="
					+ URLUtilities.encode(image);
		}

		if (facebookLogin != null) {
			parameters += "&fieldsKind=String&fieldsName=facebookLogin&fieldsValue="
					+ URLUtilities.encode(facebookLogin);
		}

		if (firstName != null) {
			parameters += "&fieldsKind=String&fieldsName=firstName&fieldsValue="
					+ URLUtilities.encode(firstName);
		}

		if (lastName != null) {
			parameters += "&fieldsKind=String&fieldsName=lastName&fieldsValue="
					+ URLUtilities.encode(lastName);
		}

		if (gender != null) {
			parameters += "&fieldsKind=String&fieldsName=gender&fieldsValue="
					+ URLUtilities.encode(gender);
		}

		if (birthday != null) {
			parameters += "&fieldsKind=String&fieldsName=birthday&fieldsValue="
					+ URLUtilities.encode(birthday);
		}

		if (maritalStatus != null) {
			parameters += "&fieldsKind=String&fieldsName=maritalStatus&fieldsValue="
					+ URLUtilities.encode(maritalStatus);
		}

		if (city != null) {
			parameters += "&fieldsKind=String&fieldsName=city&fieldsValue="
					+ URLUtilities.encode(city);
		}

		URLUtilities.fetchURLPost(saveUnoUserUrl, parameters);
	}
}
