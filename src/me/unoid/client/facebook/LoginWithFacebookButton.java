package me.unoid.client.facebook;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

public class LoginWithFacebookButton extends Image {

	private static final String livesourceFacebookID = "194243253971053";
	//private static final String livesourceFacebookID = "158550007562379"; // _localhost

	private static final String REDIRECT_URL = "http://1.unoidme.appspot.com/";
	//private static final String REDIRECT_URL = "http://127.0.0.1:8888/UnoID.html?gwt.codesvr=127.0.0.1:9997"; // localhost

	public LoginWithFacebookButton() {

		this.setUrl(GWT.getModuleName()
				+ "/authentication/images/LoginWithFacebook.png");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String url = "https://www.facebook.com/dialog/oauth?"
						+ "client_id=" + livesourceFacebookID
						+ "&redirect_uri=" + REDIRECT_URL + "&scope=email";

				redirect(getAuthorizeUrl());
			}
		});

	}
	
	private static final String FB_GRAPH_URL = "https://graph.facebook.com/";
	private static final String FB_OAUTH_URL = FB_GRAPH_URL + "oauth/";
	
	public static String getAuthorizeUrl() {
		final StringBuilder sb = new StringBuilder(FB_OAUTH_URL);
		sb.append("authorize?client_id=").append(
				livesourceFacebookID);
		sb.append("&display=page&redirect_uri=").append(REDIRECT_URL);
		sb.append("&scope=email");
		return sb.toString();
	}

	// redirect the browser to the given url
	public static native void redirect(String url)/*-{
		$wnd.location = url;
	}-*/;
}
