package com.user.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class progress {
	 private int progressId;
	    private int learnerId;
	    private int lessonId;
	    private BigDecimal progressPercentage;
	    private boolean completed;
	    private Timestamp lastUpdated;
		public progress() {
			super();
			// TODO Auto-generated constructor stub
		}
		public progress(int progressId, int learnerId, int lessonId, BigDecimal progressPercentage, boolean completed,
				Timestamp lastUpdated) {
			super();
			this.progressId = progressId;
			this.learnerId = learnerId;
			this.lessonId = lessonId;
			this.progressPercentage = progressPercentage;
			this.completed = completed;
			this.lastUpdated = lastUpdated;
		}
		public int getProgressId() {
			return progressId;
		}
		public void setProgressId(int progressId) {
			this.progressId = progressId;
		}
		public int getLearnerId() {
			return learnerId;
		}
		public void setLearnerId(int learnerId) {
			this.learnerId = learnerId;
		}
		public int getLessonId() {
			return lessonId;
		}
		public void setLessonId(int lessonId) {
			this.lessonId = lessonId;
		}
		public BigDecimal getProgressPercentage() {
			return progressPercentage;
		}
		public void setProgressPercentage(BigDecimal progressPercentage) {
			this.progressPercentage = progressPercentage;
		}
		public boolean isCompleted() {
			return completed;
		}
		public void setCompleted(boolean completed) {
			this.completed = completed;
		}
		public Timestamp getLastUpdated() {
			return lastUpdated;
		}
		public void setLastUpdated(Timestamp lastUpdated) {
			this.lastUpdated = lastUpdated;
		}
		@Override
		public String toString() {
			return "progress [progressId=" + progressId + ", learnerId=" + learnerId + ", lessonId=" + lessonId
					+ ", progressPercentage=" + progressPercentage + ", completed=" + completed + ", lastUpdated="
					+ lastUpdated + "]";
		}
	    
	 
	    
}
