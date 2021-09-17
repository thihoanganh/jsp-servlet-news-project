package com.tintuc24h.models;

public class Category {
	public Integer Id;
	public String Name;
	public Integer TotalPost;
	public String CateSlug;
	
	
	
	
	public String getCateSlug() {
		return CateSlug;
	}
	public void setCateSlug(String cateSlug) {
		CateSlug = cateSlug;
	}
	public Integer getTotalPost() {
		return TotalPost;
	}
	public void setTotalPost(Integer totalPost) {
		TotalPost = totalPost;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	
}
