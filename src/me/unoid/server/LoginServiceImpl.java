package me.unoid.server;

import me.unoid.client.login.LoginService;
import me.unoid.server.facebook.FacebookLogin;
import me.unoid.server.github.GithubLogin;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {

	private static final long serialVersionUID = -8355612980477933670L;

	public String facebookLogin(final String authenticationCode) {

		return FacebookLogin.login(authenticationCode);
	}

	public String githubLogin(final String authenticationCode) {

		return GithubLogin.githubLogin(authenticationCode).toString();
	}

}
