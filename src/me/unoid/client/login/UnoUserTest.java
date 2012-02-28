package me.unoid.client.login;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

public class UnoUserTest {

	public static String unoUserJsonString() {

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("ID", new JSONString("alline.oliveira@gmail.com"));
		jsonObject.put("facebookLogin", new JSONString("alline.oliveira"));
		jsonObject.put("email", new JSONString("alline.oliveira@gmail.com"));
		jsonObject.put("firstName", new JSONString("Alline"));
		jsonObject.put("lastName", new JSONString("Watkins"));
		jsonObject.put("image", new JSONString(
				"http://graph.facebook.com/alline.oliveira/picture"));

		return jsonObject.toString();
	}

}
