package com.honza.bedford;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SermonListAdapter extends ArrayAdapter<SermonItem> {

	private List<SermonItem> items;
	private Context context;

	public SermonListAdapter(Context context, int textViewResourceId,
			List<SermonItem> objects) {
		super(context, textViewResourceId, objects);
		this.items = objects;
		this.context = context;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.news_item_row, null);
		}

		SermonItem item = items.get(position);
		if (item != null) {
			TextView tt = (TextView) v.findViewById(R.id.toptext);
			TextView bt = (TextView) v.findViewById(R.id.bottomtext);
			if (tt != null) {
				tt.setText(item.getTitle());
			}
			if (bt != null) {
				bt.setText("By: " + item.getPreacher() + " Date: " + item.getDate());
			}
		}
		return v;
	}

}
