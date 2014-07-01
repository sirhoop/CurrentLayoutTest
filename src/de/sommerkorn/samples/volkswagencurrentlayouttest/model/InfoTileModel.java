package de.sommerkorn.samples.volkswagencurrentlayouttest.model;

public class InfoTileModel {
	
	public static enum InfoTileType {CLOCK_TILE, IMAGE_TILE, CUSTOM};
	
	private String title;
	private boolean active = true;
	protected InfoTileType type = InfoTileType.CUSTOM;

	public InfoTileType getType() {
		return type;
	}

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
