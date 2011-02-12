package com.honza.bedford;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        GridView gridview = (GridView) findViewById(R.id.HomeMenu);
        gridview.setAdapter(new HomeMenuAdapter(this));
        
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            	Intent i = new Intent();
                switch(position){
                	case 0:
                		i.setClassName("com.honza.bedford", "com.honza.bedford.EventsActivity");
                		break;
                	case 1:
                		i.setClassName("com.honza.bedford", "com.honza.bedford.SermonsActivity");
                		break;
                	case 2:
                		i.setClassName("com.honza.bedford", "com.honza.bedford.NewsActivity");
                		break;
                	case 3:
                		i.setClassName("com.honza.bedford", "com.honza.bedford.DirectionsActivity");
                		break;
                }
                startActivity(i);
            }

			
        });
    }
}