package me.unoid.client.login.facebook;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

public class LoginWithFacebookButton extends Image {

	private static final String livesourceFacebookID = "194243253971053";
	//private static final String livesourceFacebookID = "158550007562379"; // _localhost

	private static final String REDIRECT_URL = "http://unoidme.appspot.com/";
	//private static final String REDIRECT_URL = "http://localhost:8080/unoid/"; // localhost

	public LoginWithFacebookButton() {

		this.setUrl(GWT.getModuleName()
				+ "/authentication/images/FacebookLogin.png");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				redirect(getAuthorizeUrl());
			}
		});
	}

	private static final String FB_OAUTH_URL = "https://graph.facebook.com/oauth/authorize";

	public static String getAuthorizeUrl() {
		final StringBuilder sb = new StringBuilder(FB_OAUTH_URL);
		sb.append("?client_id=").append(livesourceFacebookID);
		sb.append("&display=page&redirect_uri=").append(REDIRECT_URL);
		sb.append("&scope=email,user_birthday,user_about_me,user_relationships");
		return sb.toString();
	}

	// redirect the browser to the given url
	public static native void redirect(String url)/*-{
		$wnd.location = url;
	}-*/;
}
