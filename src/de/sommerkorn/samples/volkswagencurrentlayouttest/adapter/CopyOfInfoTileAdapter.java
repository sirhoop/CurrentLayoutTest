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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CopyOfInfoTileAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<InfoTileModel> listOfInfoTiles;

	TextView contentText;

	public CopyOfInfoTileAdapter(Context context, ArrayList<InfoTileModel> list) {
		super();
		this.context = context;
		this.listOfInfoTiles = list;
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
		View layout = convertView;
		View tile = null;
		
		final ViewHolder holder;	

		if (layout == null) {

			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			layout = (LinearLayout) mInflater.inflate(R.layout.info_tile, null);
			tile = layout.findViewById(R.id.infoTile);
			
			holder = new ViewHolder();
			holder.imageView = new ImageView(tile.getContext());
			holder.contentText = new TextView(tile.getContext());
			
			//Setting Title Text
			TextView titleText = (TextView) layout.findViewById(R.id.infoTileTitleText);
						
			//Creating Image

			holder.imageView.setVisibility(View.VISIBLE);
			holder.imageView.setScaleType(ScaleType.CENTER_INSIDE);
			holder.imageView.setLayoutParams(new LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			
			//Creating TextField
			
			holder.contentText.setTextColor(Color.BLACK);
			holder.contentText.setGravity(Gravity.CENTER);
			holder.contentText.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT));
			
			if(index == 0) {
				holder.imageView.setImageResource(R.drawable.arnold);
				holder.contentText.setText("Arnold Schwarzenegger");
				titleText.setText("Arnold Schwarzenegger");
			} else {
				if(index == 1) {
					holder.imageView.setImageResource(R.drawable.van_damme);
					holder.contentText.setText("Jean-Claude van Damme");
					titleText.setText("Jean-Claude van Damme");
				} else 
					if(index == 2) {
						holder.imageView.setImageResource(R.drawable.chuck);
						holder.contentText.setText("Chuck Norris");
						titleText.setText("Chuck Norris");
					}
			}

			((LinearLayout)tile).addView(holder.imageView);
			((LinearLayout)tile).addView(holder.contentText);
			
			layout.setTag(holder);
		} else {
			holder = (ViewHolder) layout.getTag();
		}

		return layout;
	}
	
	static class ViewHolder {
		ImageView imageView;
		TextView contentText;
	}
}
