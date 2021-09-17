package com.tintuc24h.services;

import java.util.List;

import com.tintuc24h.models.Category;

public interface ICategoryService {
	List<Category> findAll();
	Category findById(Integer id);
}
