package me.unoid.client.me;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface UnoIDServiceAsync {

	void getUnoUser(String unoUserID, AsyncCallback<String> callback);
}
