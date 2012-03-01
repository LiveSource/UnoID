package me.unoid.client.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;

public class AnchorLogout extends HTML {

	public AnchorLogout() {

		this.setHTML("<a href=# >Logout</a>");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				Cookies.setCookie("githubAuthenticationToken", null);
				Cookies.setCookie("githubUserLogin", null);
				Cookies.setCookie("UnoUser", null);

				Window.Location.assign(GWT.getHostPageBaseURL());
			}
		});
	}

}
