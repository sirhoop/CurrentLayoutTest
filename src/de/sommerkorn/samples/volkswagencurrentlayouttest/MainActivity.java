package de.sommerkorn.samples.volkswagencurrentlayouttest;

import java.util.ArrayList;

import de.sommerkorn.samples.volkswagencurrentlayouttest.adapter.InfoTileAdapter;
import de.sommerkorn.samples.volkswagencurrentlayouttest.model.InfoTileModel;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TableLayout;

public class MainActivity extends Activity {

//	private TableLayout tableOfInfoTiles;
	private ListView listOfInfoTiles;
	private InfoTileAdapter infoTileAdapter;
	private ArrayList<InfoTileModel> listOfTileModels;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
				
		this.listOfInfoTiles = (ListView) this.findViewById(R.id.listOfInfoTiles);
		
		this.listOfTileModels = new ArrayList<InfoTileModel>();
		this.listOfTileModels.add(new InfoTileModel("InformationTile 1"));
		this.listOfTileModels.add(new InfoTileModel("Aktuelle Kalenderinfos"));
		this.listOfTileModels.add(new InfoTileModel("Speisepläne"));
		
		this.infoTileAdapter = new InfoTileAdapter(getApplicationContext(), this.listOfTileModels);
		
		this.listOfInfoTiles.setAdapter(infoTileAdapter);
		
//		this.tableOfInfoTiles = (TableLayout) findViewById(R.id.listOfInfoTiles);
//
//		View infoTile = this.getLayoutInflater().inflate(R.id.infoTile,
//				this.tableOfInfoTiles);
//
//		this.tableOfInfoTiles.addView(infoTile);

	}

}
