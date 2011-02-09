package com.honza.bedford;

public class NewsItem {
	
	private String author;
	private String title;
	private String date;
	private String url;
	
	public NewsItem(String author, String title, String date, String url){
		this.author = author;
		this.title = title;
		this.date = date;
		this.url = url;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
