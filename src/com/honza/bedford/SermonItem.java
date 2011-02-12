package com.honza.bedford;

public class SermonItem {
	private String title;
	private String date;
	private String name;
	private String preacher;
	
	public SermonItem(String title, String date, String name, String preacher){
		this.title = title;
		this.date = date;
		this.name = name;
		this.preacher = preacher;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPreacher(String preacher) {
		this.preacher = preacher;
	}

	public String getPreacher() {
		return preacher;
	}
}
