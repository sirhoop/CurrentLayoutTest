package de.sommerkorn.samples.volkswagencurrentlayouttest;

import java.util.ArrayList;

import de.sommerkorn.samples.volkswagencurrentlayouttest.adapter.InfoTileAdapter;
import de.sommerkorn.samples.volkswagencurrentlayouttest.model.ClockTileModel;
import de.sommerkorn.samples.volkswagencurrentlayouttest.model.ImageTileModel;
import de.sommerkorn.samples.volkswagencurrentlayouttest.model.InfoTileModel;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TableLayout;

public class MainActivity extends Activity {

	// private TableLayout tableOfInfoTiles;
	private ListView listOfInfoTiles;
	private InfoTileAdapter infoTileAdapter;
	private ArrayList<InfoTileModel> listOfTileModels;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.listOfInfoTiles = (ListView) this
				.findViewById(R.id.listOfInfoTiles);

		this.listOfTileModels = new ArrayList<InfoTileModel>();
		this.listOfTileModels.add(new ImageTileModel("First Image Tile"));
		this.listOfTileModels.add(new ClockTileModel("Current Time Widget"));
		this.listOfTileModels.add(new ImageTileModel("Second Image Tile"));
		
//		this.listOfTileModels.get(0).setActive(false);

		this.infoTileAdapter = new InfoTileAdapter(getApplicationContext(),
				this.listOfTileModels);

		this.listOfInfoTiles.setAdapter(infoTileAdapter);
	}

}
