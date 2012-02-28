package me.unoid.client.Utilities;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class ConvertJson {

	public static String getStringValue(JSONObject obj, String key) {

		JSONValue value = null;
		try {
			value = obj.get(key);
		} catch (Exception e) {
			return null;
		}
		return convertToString(value);
	}

	public static String convertToString(JSONValue value) {

		if (value != null && value.isString() != null) {

			return value.isString().stringValue();
		}

		return null;
	}

	public static String convertToNumber(JSONValue value) {

		if (value != null && value.isNumber() != null) {

			return value.isNumber().toString();
		}

		return null;
	}
}
