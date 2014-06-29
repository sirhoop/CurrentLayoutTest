package de.sommerkorn.samples.volkswagencurrentlayouttest.model;

public class InfoTileModel {
	private String title;
	private boolean active = true;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public InfoTileModel(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
