package com.honza.bedford;

public class NewsItem {
	
	private String author;
	private String title;
	private String post_date;
	
	public NewsItem(String author, String title, String post_date){
		this.author = author;
		this.title = title;
		this.post_date = post_date;
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

	public String getPost_date() {
		return post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}
}
