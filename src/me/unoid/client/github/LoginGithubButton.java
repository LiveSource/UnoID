package me.unoid.client.github;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

public class LoginGithubButton extends Image {

	private static final String githubID = "0fc5843521cee3e10e06";

	//private static final String githubID = "51ae1237beba4135e83f"; // _localhost

	public LoginGithubButton() {

		this.setUrl(GWT.getModuleName()
				+ "/authentication/images/LoginWithGithub.png");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String url = "https://github.com/login/oauth/authorize?scope=user,repo,repos,public_repo,all_repo,email,emails&client_id="
						+ githubID;

				redirect(url);
			}
		});

	}

	// redirect the browser to the given url
	public static native void redirect(String url)/*-{
		$wnd.location = url;
	}-*/;
}
