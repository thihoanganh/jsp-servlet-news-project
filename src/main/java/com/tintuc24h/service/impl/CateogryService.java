package com.tintuc24h.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tintuc24h.models.Category;
import com.tintuc24h.services.ICategoryService;
import com.tintuc24h.utils.DbConnection;

public class CateogryService  implements ICategoryService{
	private Connection conn = DbConnection.getConnection();
	@Override
	public List<Category> findAll() {
		try {
			String sql = "select * from category order by name ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Category> cates = new ArrayList<Category>();
			while (rs.next()) {
				Category cate = new Category();
				cate.Id = rs.getInt("id");
				cate.Name = rs.getString("name");
				cate.CateSlug = rs.getString("slug");
				cates.add(cate);
			}
			return cates;
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public Category findById(Integer id) {
		try {
			String sql = "select * from category where id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category cate = new Category();
				cate.Id = rs.getInt("id");
				cate.Name = rs.getString("name");
				cate.CateSlug = rs.getString("slug");
				return cate;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
