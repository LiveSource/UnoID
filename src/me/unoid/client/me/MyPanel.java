package me.unoid.client.me;

import me.unoid.client.GWTEntryPoint;
import me.unoid.client.login.AnchorLogout;
import me.unoid.client.me.edit.EditEntity;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyPanel extends VerticalPanel {

	public MyPanel(final JSONObject unoUserJson) {

		this.setSpacing(20);

		this.add(new AnchorLogout());

		this.add(new AnchorUnoUserID(unoUserJson));

		MyPhoto myPhoto = new MyPhoto(unoUserJson);
		myPhoto.addDomHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				GWTEntryPoint.vpMain.clear();
				GWTEntryPoint.vpMain.add(new EditEntity(unoUserJson));
			}
		}, ClickEvent.getType());

		this.add(myPhoto);

		this.add(new Label(unoUserJson.toString()));
	}
}
