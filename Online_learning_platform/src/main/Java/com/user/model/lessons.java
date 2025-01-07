package com.user.model;

import java.sql.Timestamp;

public class lessons {
	private int lessonId;
    private String title;
    private String content;
    private int instructorId;
    private Timestamp createdAt;
	public lessons() {
		super();
		// TODO Auto-generated constructor stub
	}
	public lessons(int lessonId, String title, String content, int instructorId, Timestamp createdAt) {
		super();
		this.lessonId = lessonId;
		this.title = title;
		this.content = content;
		this.instructorId = instructorId;
		this.createdAt = createdAt;
	}
	public int getLessonId() {
		return lessonId;
	}
	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "lessons [lessonId=" + lessonId + ", title=" + title + ", content=" + content + ", instructorId="
				+ instructorId + ", createdAt=" + createdAt + "]";
	}
    
}
