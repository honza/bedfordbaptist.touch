package com.honza.bedford;

import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

public class NewsActivity extends Activity {
	
	private static NewsListAdapter adapter;
	private ListView lv;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        lv = (ListView) findViewById(R.id.news_list);
        new DownloadNewsTask().execute();
	}
	
	public void updateList(){
		lv.setAdapter(adapter);
	}
	
	private class DownloadNewsTask extends AsyncTask<Void, Void, List<NewsItem>>{
		
		private final ProgressDialog dialog = new ProgressDialog(NewsActivity.this);

		protected void onPreExecute(){
			this.dialog.setMessage("Loading...");
			this.dialog.show();
		}
		
		protected void onPostExecute(List<NewsItem> items){
			if (this.dialog.isShowing()) {
				this.dialog.dismiss();
			}
			NewsActivity.adapter = new NewsListAdapter(NewsActivity.this, R.layout.news_item_row, items);
			NewsActivity.this.updateList();
		}

		@Override
		protected List<NewsItem> doInBackground(Void... params) {
			Downloader d = new Downloader();
			return d.getNews();
		}
		
	}
}
