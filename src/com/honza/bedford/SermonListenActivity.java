package com.honza.bedford;

import java.net.URI;
import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SermonListenActivity extends Activity {

	private MediaPlayer mp;
	private Button play;
	private Button pause;
	private TextView title;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.media);

		Intent i = getIntent();
		String title = i.getStringExtra("title");
		String name = i.getStringExtra("name");
		new PrepareSermonTask().execute(name);

		play = (Button) findViewById(R.id.play_btn);
		pause = (Button) findViewById(R.id.pause_btn);
		this.title = (TextView) findViewById(R.id.sermon_listen_text);
		this.title.setText(title);

		pause.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mp.isPlaying()) {
					mp.pause();
				}
			}

		});

		play.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!mp.isPlaying()) {
					mp.start();
				}
			}

		});

	}

	private class PrepareSermonTask extends AsyncTask<String, Void, String> {

		private final ProgressDialog dialog = new ProgressDialog(
				SermonListenActivity.this);

		protected void onPreExecute() {
			this.dialog.setMessage("Loading...");
			this.dialog.show();
		}

		protected void onPostExecute(String status) {
			if (this.dialog.isShowing()) {
				this.dialog.dismiss();
			}

		}

		@Override
		protected String doInBackground(String... params) {
			try {
				mp = new MediaPlayer();

				URI uri = new URI("http", "www.bedfordbaptist.ca",
						"/2009/07/23/in-the-past/?download&file_name="
								+ params[0], null);
				URL url = uri.toURL();

				mp.setDataSource(url.toString());
				mp.prepare();
				mp.start();
			} catch (Exception e) {
				Log.v("Bedford", e.toString());
			}
			return "";
		}

	}

}
