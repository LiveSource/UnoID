package me.unoid.client.me;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("unoID")
public interface UnoIDService extends RemoteService {
	
	String getUnoUser(final String unoUserID);
	
	void saveUnoUser(final String unoUserJsonString);
}
