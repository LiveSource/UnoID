package me.unoid.client.login;

import me.unoid.client.login.facebook.LoginWithFacebookButton;
import me.unoid.client.login.github.LoginGithubButton;

import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginButtons extends VerticalPanel {

	public LoginButtons() {

		this.setSpacing(20);

		this.add(new LoginWithFacebookButton());

		this.add(new LoginGithubButton());
	}
}
