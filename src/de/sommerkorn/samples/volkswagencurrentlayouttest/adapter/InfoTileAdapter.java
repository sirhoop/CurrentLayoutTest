package de.sommerkorn.samples.volkswagencurrentlayouttest.adapter;

import java.util.ArrayList;

import de.sommerkorn.samples.volkswagencurrentlayouttest.R;
import de.sommerkorn.samples.volkswagencurrentlayouttest.model.InfoTileModel;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class InfoTileAdapter extends BaseAdapter {
	
	private Context context;
	private ArrayList<InfoTileModel> listOfInfoTiles;

	public InfoTileAdapter(Context context, ArrayList<InfoTileModel> list) {
		this.context = context;
		this.listOfInfoTiles = list;
	}
	
	@Override
	public int getCount() {
		return this.listOfInfoTiles.size();
	}

	@Override
	public Object getItem(int index) {
		return this.listOfInfoTiles.get(index);
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	@Override
	public View getView(int index, View convertView, ViewGroup parentView) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.info_tile, null);
        }
        
        TextView titleTextView = (TextView) convertView.findViewById(R.id.infoTileTitleText);
        titleTextView.setText(this.listOfInfoTiles.get(index).getTitle());
        
		return convertView;
	}
}
