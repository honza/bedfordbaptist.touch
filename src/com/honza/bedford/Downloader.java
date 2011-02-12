package com.honza.bedford;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import android.util.Log;

public class Downloader {
	
	private final String newsUrl = "http://www.bedfordbaptist.ca/wp-content/plugins/android/news.php";
	private final String eventsUrl = "http://www.bedfordbaptist.ca/wp-content/plugins/android/calendar.php";
	private final String sermonsUrl = "http://www.bedfordbaptist.ca/wp-content/plugins/android/sermons.php";
	private String res = "";
	private boolean DEBUG = false;
	
	public List<NewsItem> getNews(){
		String json;
		if (DEBUG){
			json = "[{\"author\": \"Honza\", \"title\": \"Some cool post title yo\", \"date\": \"2011-01-23\", \"url\": \"url\"}]";
		} else {
			json = this.getJSON(this.newsUrl);
		}
		Object obj = JSONValue.parse(json);
		JSONArray array = (JSONArray) obj;
		if (array == null){
			Log.v("Bedford", "array is null");
		}
		int size = array.size();
		List<NewsItem> list = new ArrayList<NewsItem>();
		
		for (int i=0; i < size; i++){
			JSONObject x = (JSONObject) array.get(i);
			String author = x.get("author").toString();
			String title = x.get("title").toString();
			String post_date = x.get("date").toString();
			String url = x.get("url").toString();
			NewsItem item = new NewsItem(author, title, post_date, url);
			list.add(item);
		}
		
		return list;
	}
	
	public List<EventItem> getEvents(){
		String json;
		json = this.getJSON(this.eventsUrl);
		Log.v("bedford", json);
		Object obj = JSONValue.parse(json);
		JSONArray array = (JSONArray) obj;
		
		int size = array.size();
		List<EventItem> list = new ArrayList<EventItem>();
		
		for (int i=0; i < size; i++){
			JSONObject x = (JSONObject) array.get(i);
			String text = x.get("text").toString();
			String date = x.get("date").toString();
			String time = x.get("time").toString();
			EventItem item = new EventItem(text, date, time);
			list.add(item);
		}
		return list;
	}
	
	public List<SermonItem> getSermons(){
		String json;
		json = this.getJSON(this.sermonsUrl);
		Log.v("bedford", json);
		Object obj = JSONValue.parse(json);
		JSONArray array = (JSONArray) obj;
		
		int size = array.size();
		List<SermonItem> list = new ArrayList<SermonItem>();
		
		for (int i=0; i < size; i++){
			JSONObject x = (JSONObject) array.get(i);
			String title = x.get("title").toString();
			String date = x.get("datetime").toString();
			String name = x.get("name").toString();
			String preacher = x.get("preacher").toString();
			SermonItem item = new SermonItem(title, date, name, preacher);
			list.add(item);
		}
		return list;
	}
	
	private String getJSON(String url){
		String line = "";
		try {
			URL u = new URL(url);
			URLConnection conn = u.openConnection();
			conn.setDoInput(true);
			InputStream in = conn.getInputStream();
			BufferedReader input = new BufferedReader(new InputStreamReader(in));
			while ((line = input.readLine()) != null){
				res = res + line;
			}
			
		} catch (Exception e) {
			Log.v("Bedford", e.toString());
		}
		return res;
	}

}
