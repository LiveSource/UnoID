package me.unoid.client;

import me.unoid.client.Utilities.EncryptText;
import me.unoid.client.login.LoginButtons;
import me.unoid.client.login.facebook.FacebookLoginVerifyer;
import me.unoid.client.login.github.GithubLoginVerifyer;
import me.unoid.client.me.GetUnoUser;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
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

		String unoUserID = EncryptText.decrypt(Cookies.getCookie("UnoUserID"));

		if (unoUserID == null || unoUserID.equals("null")) {

			final String authenticationCode = Location.getParameter("code");

			final String error = Location.getParameter("error_reason");

			if ((null != error && error.equals("user_denied"))
					|| (authenticationCode == null || ""
							.equals(authenticationCode))) {

				RootPanel.get().add(new LoginButtons());

			} else {

				final String loginApp = Location.getParameter("login");

				if ("github".equals(loginApp)) {

					GithubLoginVerifyer.authenticate(authenticationCode);

				} else {

					FacebookLoginVerifyer.authenticate(authenticationCode);
				}
			}

		} else {

			GetUnoUser.get(unoUserID);
		}
	}
}
