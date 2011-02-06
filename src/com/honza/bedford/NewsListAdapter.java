package com.honza.bedford;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NewsListAdapter extends ArrayAdapter<NewsItem> {
	
	private List<NewsItem> items;
	private Context context;

	public NewsListAdapter(Context context, int textViewResourceId,
			List<NewsItem> objects) {
		super(context, textViewResourceId, objects);
		this.items = objects;
		this.context = context;
		
	}
	
	
	 @Override
     public View getView(int position, View convertView, ViewGroup parent) {
             View v = convertView;
             if (v == null) {
                 LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                 v = vi.inflate(R.layout.news_item_row, null);
             }

             NewsItem item = items.get(position);
             if (item != null) {
                     TextView tt = (TextView) v.findViewById(R.id.toptext);
                     TextView bt = (TextView) v.findViewById(R.id.bottomtext);
                     if (tt != null) {
                           tt.setText(item.getTitle());                            }
                     if(bt != null){
                           bt.setText(item.getAuthor());
                     }
             }
             return v;
     }
	
}
