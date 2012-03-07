package me.unoid.client.me;

import me.unoid.client.Utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;

public class MyPhoto extends HorizontalPanel {

	public MyPhoto(JSONObject unoUserJson) {

		this.setSpacing(5);
		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		ClickHandler click = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// GWTEntryPoint.vpMain.clear();
				// GWTEntryPoint.vpMain.add(new EditEntity(unoUserJson));
			}
		};

		String imageURL = ConvertJson.getStringValue(unoUserJson, "image");
		if (imageURL != null) {

			Image image = new Image(imageURL);
			image.setSize("25px", "25px");
			image.addClickHandler(click);
			this.add(image);
		}

		String firstName = ConvertJson.getStringValue(unoUserJson, "firstName");
		String lastName = ConvertJson.getStringValue(unoUserJson, "lastName");
		HTML name = new HTML("<font size=2 color=blue><a href=#>" + firstName
				+ " " + lastName + "</a></font>");
		name.addClickHandler(click);
		this.add(name);
	}
}
