package com.honza.bedford;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
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
