package me.unoid.client.facebook;

import me.unoid.client.LoginService;
import me.unoid.client.LoginServiceAsync;
import me.unoid.client.github.SetLoggedIn;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class FacebookLoginVerifyer {

	public static void authenticate(final String authenticationCode) {

		final LoginServiceAsync loginService = GWT.create(LoginService.class);

		if (!(authenticationCode == null || "".equals(authenticationCode))) {

			loginService.facebookLogin(authenticationCode,
					new AsyncCallback<String>() {

						public void onFailure(final Throwable caught) {
							System.out.println(caught);
						}

						public void onSuccess(final String jsonResults) {

							SetLoggedIn.authenticated(jsonResults);
						}
					});

		}
	}
}
