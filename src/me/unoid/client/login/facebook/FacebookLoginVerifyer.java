package me.unoid.client.login.facebook;

import me.unoid.client.Utilities.EncryptText;
import me.unoid.client.login.LoginService;
import me.unoid.client.login.LoginServiceAsync;
import me.unoid.client.me.GetUnoUser;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
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

						public void onSuccess(final String unoUserID) {

							Cookies.setCookie("UnoUserID",
									EncryptText.encrypt(unoUserID));

							GetUnoUser.get(unoUserID);
						}
					});

		}
	}
}
