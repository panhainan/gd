package com.gd.entity;

import java.util.Date;

public class Idea {
	private long idea_id;
	private User idea_user;
	private String  idea_title;
	private String idea_content;
	private Date idea_time;
	private int idea_status;
	public Idea() {
		super();
	}
	public long getIdea_id() {
		return idea_id;
	}
	public void setIdea_id(long idea_id) {
		this.idea_id = idea_id;
	}
	public User getIdea_user() {
		return idea_user;
	}
	public void setIdea_user(User idea_user) {
		this.idea_user = idea_user;
	}
	public String getIdea_title() {
		return idea_title;
	}
	public void setIdea_title(String idea_title) {
		this.idea_title = idea_title;
	}
	public String getIdea_content() {
		return idea_content;
	}
	public void setIdea_content(String idea_content) {
		this.idea_content = idea_content;
	}
	public Date getIdea_time() {
		return idea_time;
	}
	public void setIdea_time(Date idea_time) {
		this.idea_time = idea_time;
	}
	public int getIdea_status() {
		return idea_status;
	}
	public void setIdea_status(int idea_status) {
		this.idea_status = idea_status;
	}
	@Override
	public String toString() {
		return "Idea [idea_id=" + idea_id + ", idea_user=" + idea_user
				+ ", idea_title=" + idea_title + ", idea_content="
				+ idea_content + ", idea_time=" + idea_time + ", idea_status="
				+ idea_status + "]";
	}
	
}
