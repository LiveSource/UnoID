package me.unoid.server.unouser;

import me.unoid.client.me.UnoIDService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UnoIDServiceImpl extends RemoteServiceServlet implements
		UnoIDService {

	private static final long serialVersionUID = -8355612980477933670L;

	public String getUnoUser(final String unoUserID) {

		return GetUnoUserByID.get(unoUserID);
	}

}
