package me.unoid.server.github;

import me.unoid.server.URLUtilities;
import me.unoid.server.livesource.GetLiveSourceUserAPI;

import org.json.JSONException;
import org.json.JSONObject;

public class GithubLogin {

	// private static final String SECRET_github =
	// "8e8ae6b7cb786bc8734f3e493d403ae7f3e6d5c0"; // Testing
	// private static final String APPLICATION_ID_github =
	// "51ae1237beba4135e83f"; // Testing

	private static final String SECRET_github = "e8da41753e1e443e28064e8835de3a89a53b9945";
	private static final String APPLICATION_ID_github = "0fc5843521cee3e10e06";

	private static final String GITHUB_URL = "https://github.com/login/oauth/authorize";
	private static final String github_OAUTH_URL = "https://github.com/login/oauth/access_token";

	// private static final String REDIRECT_URL =
	// "http://127.0.0.1:8888/LiveSourceApp.html?gwt.codesvr=127.0.0.1:9997"; //
	// Testing
	// private static final String REDIRECT_URL =
	// "http://127.0.0.1:8888/ProjectnectionWeb.html?gwt.codesvr=127.0.0.1:9997";
	// // Testing
	// private static final String REDIRECT_URL =
	// "http://127.0.0.1:8888/LiveSourceAuthentication.html?gwt.codesvr=127.0.0.1:9997";
	// // Testing
	// private static final String REDIRECT_URL = "http://www.golivesource.com";
	private static final String REDIRECT_URL = "http://livesrc.com";

	public static JSONObject githubLogin(final String authenticationCode) {

		JSONObject json = new JSONObject();

		String authenticationToken = GithubLogin.login(authenticationCode);

		if (authenticationToken != null
				&& authenticationToken.contains("access_token=")) {

			JSONObject githubUserMe = GithubAPI.me(authenticationToken);

			String githubUserLogin = null;
			String githubUserName = null;

			try {
				githubUserLogin = githubUserMe.getString("login");
				githubUserName = githubUserMe.getString("name");

			} catch (JSONException e1) {
				e1.printStackTrace();
			}

			String livesourceUser = GetLiveSourceUserAPI
					.getLivesourceUser(githubUserLogin);

			try {

				json.put("authenticationToken", authenticationToken);

				json.put("githubUserLogin", githubUserLogin);

				json.put("githubUserName", githubUserName);

				json.put("livesourceUser", livesourceUser);

			} catch (JSONException e) {

				e.printStackTrace();
			}
		}

		return json;
	}

	public static String login(final String authenticationCode) {

		final String parameters = getAccessTokenUrlGithub(URLUtilities
				.encode(authenticationCode));
		String authenticationToken = URLUtilities.fetchURLGet(github_OAUTH_URL,
				parameters);

		return authenticationToken;
	}

	private static String getAccessTokenUrlGithub(final String authCode) {

		final StringBuilder sb = new StringBuilder();

		sb.append("client_id=").append(APPLICATION_ID_github);
		sb.append("&redirect_uri=").append(URLUtilities.encode(REDIRECT_URL));
		sb.append("&client_secret=").append(SECRET_github);
		sb.append("&code=").append(authCode);

		return sb.toString();
	}

}
