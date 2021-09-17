package com.tintuc24h.models;

import java.sql.Timestamp;

public class Comment {
	public Integer Id;
	public Integer UserId;
	public Integer PostId;
	public String Content;
	public Timestamp CreatedDate;
	public String TimeAgo;
	public String Fname;
	
	
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getTimeAgo() {
		return TimeAgo;
	}
	public void setTimeAgo(String timeAgo) {
		TimeAgo = timeAgo;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public Integer getPostId() {
		return PostId;
	}
	public void setPostId(Integer postId) {
		PostId = postId;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Timestamp getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		CreatedDate = createdDate;
	}
	
	
}
