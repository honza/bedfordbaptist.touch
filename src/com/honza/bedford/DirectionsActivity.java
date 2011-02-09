package com.honza.bedford;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DirectionsActivity extends Activity {
	
	private EditText et;
	private Button btn;
	
	@Override
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.directions);
	        et = (EditText) findViewById(R.id.directions_field);
	        btn = (Button) findViewById(R.id.directions_button);
	        
	        btn.setOnClickListener(new OnClickListener(){
	        	public void onClick(View v){
	        		String addr = et.getText().toString();
	        		
	        		Intent intent = new Intent(android.content.Intent.ACTION_VIEW, 
	        		Uri.parse("http://maps.google.com/maps?saddr=" + addr + "&daddr=44.73814498281224,-63.65286469459534"));
	        		startActivity(intent);
	        	}
	        });
	 }
}
