package com.honza.bedford;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        GridView gridview = (GridView) findViewById(R.id.HomeMenu);
        gridview.setAdapter(new HomeMenuAdapter(this));
        
        
    }
}