package me.unoid.client.Utilities;

import com.google.gwt.json.client.JSONValue;

public class ConvertJson {

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
