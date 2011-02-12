package com.honza.bedford;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class SermonsActivity extends Activity {
	
	private static SermonListAdapter adapter;
	private ListView lv;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sermons);
        lv = (ListView) findViewById(R.id.news_list);
        new DownloadNewsTask().execute();
	}
	
	public void updateList(){
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
				Log.v("Bedford", "onclick");
				SermonItem item = SermonsActivity.adapter.getItem(position);
				Intent i = new Intent();
				i.setClassName("com.honza.bedford", "com.honza.bedford.SermonListenActivity");
				i.putExtra("title", item.getTitle());
				i.putExtra("preacher", item.getPreacher());
				i.putExtra("date", item.getDate());
				i.putExtra("name", item.getName());
			    startActivity(i);  
			}
			
		});
	}
	
	private class DownloadNewsTask extends AsyncTask<Void, Void, List<SermonItem>>{
		
		private final ProgressDialog dialog = new ProgressDialog(SermonsActivity.this);

		protected void onPreExecute(){
			this.dialog.setMessage("Loading...");
			this.dialog.show();
		}
		
		protected void onPostExecute(List<SermonItem> items){
			if (this.dialog.isShowing()) {
				this.dialog.dismiss();
			}
			SermonsActivity.adapter = new SermonListAdapter(SermonsActivity.this, R.layout.news_item_row, items);
			SermonsActivity.this.updateList();
		}

		@Override
		protected List<SermonItem> doInBackground(Void... params) {
			Downloader d = new Downloader();
			return d.getSermons();
		}
		
	}
}
