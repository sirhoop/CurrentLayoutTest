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

		final ViewHolder holder;	

		if (convertView == null) {

			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = (LinearLayout) mInflater.inflate(R.layout.info_tile, null);
			
			holder = new ViewHolder();
			holder.imageView = new ImageView(convertView.getContext());
			holder.contentText = new TextView(convertView.getContext());
			
			holder.imageView.setImageResource(R.drawable.chuck);
			holder.imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
			holder.imageView.setVisibility(View.VISIBLE);

			holder.contentText.setText("Test, Test, Test");
			holder.contentText.setTextColor(Color.BLACK);
			holder.contentText.setGravity(Gravity.CENTER);
			holder.contentText.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));

			((LinearLayout)convertView).addView(holder.imageView);
			//((LinearLayout)convertView).addView(holder.contentText);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}
	
	static class ViewHolder {
		ImageView imageView;
		TextView contentText;
	}
}
