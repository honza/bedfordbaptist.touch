package com.honza.bedford;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class HomeMenuAdapter extends BaseAdapter {
	
	private Context mContext;
	
	public HomeMenuAdapter(Context c){
		mContext = c;
	}

	@Override
	public int getCount() {
		return menuLabels.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
        	textView = new TextView(mContext);
        	textView.setLayoutParams(new GridView.LayoutParams(85, 85));
        	textView.setPadding(8, 8, 8, 8);
        } else {
            textView = (TextView) convertView;
        }

        textView.setText(menuLabels[position]);
        return textView;
	}
	
	private String[] menuLabels = {
		"Events",
		"Sermons",
		"Directions",
		"About"
	};

}
