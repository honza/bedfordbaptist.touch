package com.honza.bedford;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;

public class NewsActivity extends ListActivity {
	
	private List<NewsItem> items;
	private NewsListAdapter adapter;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        items = new ArrayList<NewsItem>();
        NewsItem it = new NewsItem("Honza", "Some cool post", "today");
        items.add(it);
        
        adapter = new NewsListAdapter(this, R.layout.news_item_row, items);
        
        setListAdapter(this.adapter);
	}
}
