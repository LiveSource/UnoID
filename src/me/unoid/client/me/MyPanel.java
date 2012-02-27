package me.unoid.client.me;

import me.unoid.client.login.AnchorLogout;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyPanel extends VerticalPanel {

	public MyPanel(String jsonResults) {

		this.setSpacing(20);

		this.add(new AnchorLogout());

		this.add(new Label(jsonResults));
	}
}
