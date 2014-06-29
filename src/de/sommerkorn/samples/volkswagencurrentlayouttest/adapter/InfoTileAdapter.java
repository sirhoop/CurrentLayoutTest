package de.sommerkorn.samples.volkswagencurrentlayouttest.adapter;

import java.util.ArrayList;

import de.sommerkorn.samples.volkswagencurrentlayouttest.R;
import de.sommerkorn.samples.volkswagencurrentlayouttest.model.InfoTileModel;
import android.R.bool;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InfoTileAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<InfoTileModel> listOfInfoTiles;
	private ArrayList<Boolean> visibilityList;

	TextView contentText;

	public InfoTileAdapter(Context context, ArrayList<InfoTileModel> list) {
		this.context = context;
		this.listOfInfoTiles = list;
		this.visibilityList = new ArrayList<Boolean>(
				this.listOfInfoTiles.size());
		for (Boolean visible : visibilityList) {
			visible = true;
		}
	}

	@Override
	public int getCount() {
		return this.listOfInfoTiles.size();
	}

	@Override
	public Object getItem(int index) {
		if (this.listOfInfoTiles.get(index).isActive())
			return this.listOfInfoTiles.get(index);
		return null;
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	@Override
	public View getView(int index, View convertView, ViewGroup parentView) {
		// if (!this.listOfInfoTiles.get(index).isActive())
		// return null;

		LinearLayout tile = new LinearLayout(context);

		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			tile = (LinearLayout) mInflater.inflate(R.layout.info_tile, null);
			convertView = tile;
		}

		TextView titleTextView = (TextView) convertView
				.findViewById(R.id.infoTileTitleText);
		titleTextView.setText(this.listOfInfoTiles.get(index).getTitle());

		ImageView imageView = new ImageView(context);
		imageView.setImageResource(R.drawable.chuck);
		imageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
		imageView.setVisibility(View.VISIBLE);

		contentText = new TextView(context);
		contentText.setText("Test, Test, Test");
		contentText.setTextColor(Color.BLACK);
		contentText.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));

		tile.addView(imageView);
		
		// tile.addView(contentText);

		return convertView;
	}
}
