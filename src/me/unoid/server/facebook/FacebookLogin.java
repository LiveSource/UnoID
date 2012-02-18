package me.unoid.server.facebook;

import me.unoid.server.URLUtilities;

import org.json.JSONException;
import org.json.JSONObject;

public class FacebookLogin {

	//private static final String SECRET_LiveSource_facebook = "5a2a037588b453a3df4058c836850da1"; // Testing
	//private static final String APPLICATION_ID_LiveSource_Facebook = "158550007562379"; // Testing

	 private static final String SECRET_LiveSource_facebook = "110a3c23f4c80ac47ddcc5c9fd9fb032";
	 private static final String APPLICATION_ID_LiveSource_Facebook = "194243253971053";

	private static final String Facebook_URL = "https://graph.facebook.com/dialog/oauth/";
	private static final String Facebook_OAUTH_URL = "https://graph.facebook.com/oauth/access_token";

	//private static final String REDIRECT_URL = "http://127.0.0.1:8888/UnoID.html?gwt.codesvr=127.0.0.1:9997"; // Testing
	 private static final String REDIRECT_URL = "http://1.unoidme.appspot.com/";

	public static JSONObject log(final String authenticationCode) {

		JSONObject json = new JSONObject();

		String authenticationToken = login(authenticationCode);

		if (authenticationToken != null
				&& authenticationToken.contains("access_token=")) {

		//	JSONObject userMe = FacebookAPI.me(authenticationToken);

			String login = null;
			String name = null;
			String email = null;
			String image = null;

		/*	try {
				login = userMe.getString("id");
				name = userMe.getString("name");
				email = userMe.getString("email");
				image = userMe.getString("id");

			} catch (JSONException e1) {
				e1.printStackTrace();
			}

			String livesourceUser = GetLiveSourceUserAPI
					.getLivesourceUser(login);
*/
			try {

				json.put("authenticationToken", authenticationToken);

				//json.put("livesourceUser", livesourceUser);

			} catch (JSONException e) {

				e.printStackTrace();
			}
		}

		return json;
	}

	public static String login(final String authenticationCode) {

		final String parameters = getAccessTokenUrlGithub(authenticationCode);

		String authenticationToken = URLUtilities.fetchURLGet(
				Facebook_OAUTH_URL, parameters);

		return authenticationToken;
	}

	private static String getAccessTokenUrlGithub(final String authCode) {

		final StringBuilder sb = new StringBuilder();

		sb.append("client_id=").append(APPLICATION_ID_LiveSource_Facebook);
		sb.append("&client_secret=").append(SECRET_LiveSource_facebook);
		sb.append("&code=").append(authCode);
		sb.append("&redirect_uri=").append(REDIRECT_URL);

		return sb.toString();
	}

	private static final String FB_GRAPH_URL = "https://graph.facebook.com/";
	private static final String FB_OAUTH_URL = FB_GRAPH_URL + "oauth/";



	public static String getAccessTokenUrl(final String authCode) {
		final StringBuilder sb = new StringBuilder(FB_OAUTH_URL);
		sb.append(
				"access_token?canvas=1&fbconnect=0&type=user_agent&client_id=")
				.append(APPLICATION_ID_LiveSource_Facebook);
		sb.append("&redirect_uri=").append(REDIRECT_URL);
		sb.append("&client_secret=").append(SECRET_LiveSource_facebook);
		sb.append("&code=").append(authCode);
		return sb.toString();
	}
}
