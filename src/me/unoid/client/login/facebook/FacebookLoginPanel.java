package me.unoid.client.login.facebook;

import me.unoid.client.UnoIDGlobalVariables;
import me.unoid.client.login.AnchorLogout;
import me.unoid.client.me.MyPhoto;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class FacebookLoginPanel {

	public static HorizontalPanel hpFacebookLogin = new HorizontalPanel();

	public static void setPanel() {

		hpFacebookLogin.setWidth("200px");
		hpFacebookLogin.setSpacing(5);
		hpFacebookLogin.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		if (UnoIDGlobalVariables.unoUser == null) {

			hpFacebookLogin.clear();

			hpFacebookLogin.add(new LoginWithFacebookButton());

		} else {

			setLoggedUser();
		}
	}

	public static void setLoggedUser() {

		hpFacebookLogin.clear();

		hpFacebookLogin.add(new MyPhoto(UnoIDGlobalVariables.unoUser));

		Label space3 = new Label(" ");
		space3.setWidth("50px");
		hpFacebookLogin.add(space3);

		hpFacebookLogin.add(new AnchorLogout());
	}
}
