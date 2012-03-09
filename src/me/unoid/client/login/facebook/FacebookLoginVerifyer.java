package me.unoid.client.login.facebook;

import java.util.logging.Level;
import java.util.logging.Logger;

import me.unoid.client.UnoIDGlobalVariables;
import me.unoid.client.Utilities.EncryptText;
import me.unoid.client.login.LoginService;
import me.unoid.client.login.LoginServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class FacebookLoginVerifyer {

	private static Logger logger = Logger.getLogger("UnoIDMe");

	public static void authenticate(final String authenticationCode) {

		final LoginServiceAsync loginService = GWT.create(LoginService.class);

		if (!(authenticationCode == null || "".equals(authenticationCode))) {

			loginService.facebookLogin(authenticationCode,
					new AsyncCallback<String>() {

						public void onFailure(final Throwable caught) {
							System.out.println(caught);
							logger.log(Level.INFO, "caught=" + caught);
						}

						public void onSuccess(final String unoUserJsonString) {

							Cookies.setCookie("UnoUser",
									EncryptText.encrypt(unoUserJsonString));

							JSONObject obj = (JSONObject) JSONParser
									.parseStrict(unoUserJsonString);

							UnoIDGlobalVariables.unoUser = obj;

							FacebookLoginPanel.setLoggedUser();
						}
					});

		}
	}
}
