package me.unoid.client;

import me.unoid.client.facebook.FacebookLoginVerifyer;
import me.unoid.client.github.GithubLoginVerifyer;
import me.unoid.client.login.LoginButtons;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * 
 * @Architecture
 */
public class GWTEntryPoint implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		final String authenticationCode = Location.getParameter("code");

		final String error = Location.getParameter("error_reason");

		if ((null != error && error.equals("user_denied"))
				|| (authenticationCode == null || "".equals(authenticationCode))) {

			RootPanel.get().add(new LoginButtons());

		} else {

			final String loginApp = Location.getParameter("login");

			if ("github".equals(loginApp)) {

				GithubLoginVerifyer.authenticate(authenticationCode);

			} else {

				FacebookLoginVerifyer.authenticate(authenticationCode);
			}
		}
	}
}
