package com.honza.bedford;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeMenuAdapter extends BaseAdapter {
	
	private Context mContext;
	
	public HomeMenuAdapter(Context c){
		mContext = c;
	}

	@Override
	public int getCount() {
		return buttons.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout layout;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
        	layout = new LinearLayout(mContext);
        	layout.setLayoutParams(new GridView.LayoutParams(85, 85));
        	layout.setPadding(8, 8, 8, 8);
        	layout.setGravity(Gravity.CENTER);
        	layout.setOrientation(LinearLayout.VERTICAL);
        	
        	TextView text = new TextView(mContext);
        	text.setText(buttons[position].getText());
        	text.setGravity(Gravity.CENTER);
        	
        	ImageView icon = new ImageView(mContext);
        	icon.setImageResource(buttons[position].getIcon());
        	
        	layout.addView(icon);
        	layout.addView(text);
        	
        } else {
            layout = (LinearLayout) convertView;
        }
        
        return layout;
	}
	
	public class ButtonResource {
		private String text;
		private int icon;
		
		public ButtonResource(String s, int i) {
			text = s;
			icon = i;
		}
		
		public int getIcon(){
			return icon;
		}
		
		public String getText(){
			return text;
		}
	}
	
	public ButtonResource[] buttons = {
		new ButtonResource("Events", R.drawable.calendar),
		new ButtonResource("Sermons", R.drawable.mic),
		new ButtonResource("News", R.drawable.news),
		new ButtonResource("Directions", R.drawable.map),
	};

}
