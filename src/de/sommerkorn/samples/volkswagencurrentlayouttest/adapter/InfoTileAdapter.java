package de.sommerkorn.samples.volkswagencurrentlayouttest.adapter;

import java.util.ArrayList;

import de.sommerkorn.samples.volkswagencurrentlayouttest.R;
import de.sommerkorn.samples.volkswagencurrentlayouttest.model.InfoTileModel;
import de.sommerkorn.samples.volkswagencurrentlayouttest.model.InfoTileModel.InfoTileType;
import android.R.bool;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AnalogClock;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InfoTileAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<InfoTileModel> listOfInfoTiles;

	TextView contentText;

	public InfoTileAdapter(Context context, ArrayList<InfoTileModel> list) {
		super();
		this.context = context;
		this.listOfInfoTiles = list;
	}

	@Override
	public int getCount() {
		int count = 0;
		for (InfoTileModel model : this.listOfInfoTiles) {
			if(model.isActive()) {
				count++;
			}
		}
		return count;
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
//		if (!this.listOfInfoTiles.get(index).isActive())
//			return null;
		
		View layout = convertView;
		View tile = null;
		
		final ViewHolder holder;	

		if (layout == null) {

			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			layout = (LinearLayout) mInflater.inflate(R.layout.info_tile, null);
			tile = layout.findViewById(R.id.infoTile);
			
			holder = new ViewHolder();
			
			TextView titleText = (TextView) tile.findViewById(R.id.infoTileTitleText);
			titleText.setText(listOfInfoTiles.get(index).getTitle());
			
			//----------- CLOCK TILE -----------
			if(this.listOfInfoTiles.get(index).getType() == InfoTileType.CLOCK_TILE) {
				
				AnalogClock clockView = new AnalogClock(tile.getContext());
				clockView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
						LayoutParams.WRAP_CONTENT));
				holder.view = clockView;
			}
			
			//----------- IMAGE TILE -----------
			if(this.listOfInfoTiles.get(index).getType() == InfoTileType.IMAGE_TILE) {
				ImageView imageView = new ImageView(tile.getContext());
				
				imageView.setScaleType(ScaleType.CENTER_INSIDE);
				imageView.setLayoutParams(new LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				imageView.setImageResource(R.drawable.arnold);
				
				holder.view = imageView;
			}
			

			((LinearLayout)tile).addView(holder.view);
			
			layout.setTag(holder);
		} else {
			holder = (ViewHolder) layout.getTag();
		}

		return layout;
	}
	
	static class ViewHolder {
		View view;
	}
}
