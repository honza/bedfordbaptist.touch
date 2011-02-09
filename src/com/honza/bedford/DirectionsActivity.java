package com.honza.bedford;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DirectionsActivity extends Activity {

	private EditText et;
	private Button addr_btn;
	private Button gps_btn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.directions);

		et = (EditText) findViewById(R.id.directions_field);
		addr_btn = (Button) findViewById(R.id.directions_button);
		gps_btn = (Button) findViewById(R.id.gps_button);

		addr_btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String addr = et.getText().toString();
				Intent intent = new Intent(
						android.content.Intent.ACTION_VIEW,
						Uri.parse("http://maps.google.com/maps?saddr=" + addr
								+ "&daddr=44.73814498281224,-63.65286469459534"));
				startActivity(intent);
			}
		});

		gps_btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.v("Bedford", "onclick");
				LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				LocationListener mlocListener = new MyLocationListener();
				mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
			}
		});
	}

	public class MyLocationListener implements LocationListener {

		@Override
		public void onLocationChanged(Location loc){
			loc.getLatitude();
			loc.getLongitude();
			String addr = loc.getLongitude() + "," + loc.getLatitude();
			Intent intent = new Intent(
					android.content.Intent.ACTION_VIEW,
					Uri.parse("http://maps.google.com/maps?saddr=" + addr
							+ "&daddr=44.73814498281224,-63.65286469459534"));
			startActivity(intent);
		}

		@Override
		public void onProviderDisabled(String provider){
			Toast.makeText(getApplicationContext(), "Gps Disabled", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onProviderEnabled(String provider){
			Toast.makeText(getApplicationContext(), "Gps Enabled", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras){

		}

	}
}
