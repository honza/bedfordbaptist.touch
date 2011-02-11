package com.honza.bedford;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

public class EventsActivity extends Activity {
	
	private static EventsListAdapter adapter;
	private ListView lv;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.events);
        lv = (ListView) findViewById(R.id.news_list);
        new DownloadEventsTask().execute();
	}

	public void updateList(){
		lv.setAdapter(adapter);
	}
	
	private class DownloadEventsTask extends
			AsyncTask<Void, Void, List<EventItem>> {

		private final ProgressDialog dialog = new ProgressDialog(
				EventsActivity.this);

		protected void onPreExecute() {
			this.dialog.setMessage("Loading...");
			this.dialog.show();
		}

		protected void onPostExecute(List<EventItem> items) {
			if (this.dialog.isShowing()) {
				this.dialog.dismiss();
			}
			EventsActivity.adapter = new EventsListAdapter(EventsActivity.this,
					R.layout.news_item_row, items);
			EventsActivity.this.updateList();
		}

		@Override
		protected List<EventItem> doInBackground(Void... params) {
			Downloader d = new Downloader();
			return d.getEvents();
		}

	}
}
