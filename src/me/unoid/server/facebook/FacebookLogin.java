package me.unoid.server.facebook;

import me.unoid.server.URLUtilities;

import org.json.JSONException;
import org.json.JSONObject;

public class FacebookLogin {

	private static final String Facebook_OAUTH_URL = "https://graph.facebook.com/oauth/access_token";

	private static final String SECRET_LiveSource_facebook = "5a2a037588b453a3df4058c836850da1"; // Testing
	private static final String APPLICATION_ID_LiveSource_Facebook = "158550007562379"; // Testing

	// private static final String SECRET_LiveSource_facebook =
	// "110a3c23f4c80ac47ddcc5c9fd9fb032";
	// private static final String APPLICATION_ID_LiveSource_Facebook =
	// "194243253971053";

	private static final String REDIRECT_URL = "http://localhost:8080/unoid/"; // Testing

	// private static final String REDIRECT_URL =
	// "http://1.unoidme.appspot.com/";

	public static JSONObject login(final String authenticationCode) {

		JSONObject json = new JSONObject();

		final String parameters = getAccessTokenUrl(authenticationCode);

		String authenticationToken = URLUtilities.fetchURLPost(
				Facebook_OAUTH_URL, parameters);

		if (authenticationToken != null
				&& authenticationToken.contains("access_token=")) {

			String unoUserID = GetUnoUserIDFromFacebook
					.get(authenticationToken);

			try {

				json.put("UnoUserID", unoUserID);

			} catch (JSONException e) {

				e.printStackTrace();
			}
		}

		return json;
	}

	private static String getAccessTokenUrl(final String authCode) {

		final StringBuilder sb = new StringBuilder();

		sb.append("client_id=").append(APPLICATION_ID_LiveSource_Facebook);
		sb.append("&client_secret=").append(SECRET_LiveSource_facebook);
		sb.append("&code=").append(authCode);
		sb.append("&redirect_uri=").append(REDIRECT_URL);

		return sb.toString();
	}

}
