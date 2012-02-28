package me.unoid.client.me;

import me.unoid.client.Utilities.ConvertJson;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class MyPhoto extends HorizontalPanel {

	public MyPhoto(JSONObject unoUserJson) {

		this.setSpacing(5);
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		String imageURL = ConvertJson.getStringValue(unoUserJson, "image");
		if (imageURL != null) {

			Image image = new Image(imageURL);
			image.setSize("25px", "25px");
			this.add(image);
		}

		String firstName = ConvertJson.getStringValue(unoUserJson, "firstName");
		String lastName = ConvertJson.getStringValue(unoUserJson, "lastName");
		this.add(new HTML("<font size=2 color=blue><a href=#>" + firstName + " "
				+ lastName + "</a></font>"));
	}
}
