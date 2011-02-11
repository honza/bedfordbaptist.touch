package com.honza.bedford;

public class EventItem {
	
	private String text;
	private String date;
	private String time;
	
	public EventItem(String text, String date, String time){
		this.setText(text);
		this.setDate(date);
		this.setTime(time);
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}

}
