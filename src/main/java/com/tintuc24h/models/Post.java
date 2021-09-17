package com.tintuc24h.models;

import java.sql.Timestamp;
import java.util.List;

public class Post {
	public Integer Id;
	public String Title;
	public String Content;
	public String Excerpt;
	public Integer View;
	public String Thumb;
	public String CateName;
	public Boolean Trending;
	public Integer CateId;
	public Timestamp CreatedDate;
	public String Segment;
	public String TimeAgo;
	public String[] Tags;
	
	
	
	
	
	public String[] getTags() {
		return Tags;
	}
	public void setTags(String[] tags) {
		Tags = tags;
	}
	public String getTimeAgo() {
		return TimeAgo;
	}
	public void setTimeAgo(String timeAgo) {
		TimeAgo = timeAgo;
	}
	public String getSegment() {
		return Segment;
	}
	public void setSegment(String segment) {
		this.Segment = segment;
	}
	public String getCateName() {
		return CateName;
	}
	public void setCateName(String cateName) {
		CateName = cateName;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getExcerpt() {
		return Excerpt;
	}
	public void setExcerpt(String excerpt) {
		Excerpt = excerpt;
	}
	public Integer getView() {
		return View;
	}
	public void setView(Integer view) {
		View = view;
	}
	public String getThumb() {
		return Thumb;
	}
	public void setThumb(String thumb) {
		Thumb = thumb;
	}
	public Boolean getTrending() {
		return Trending;
	}
	public void setTrending(Boolean trending) {
		Trending = trending;
	}
	public Integer getCateId() {
		return CateId;
	}
	public void setCateId(Integer cateId) {
		CateId = cateId;
	}
	public Timestamp getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		CreatedDate = createdDate;
	}
	
}
