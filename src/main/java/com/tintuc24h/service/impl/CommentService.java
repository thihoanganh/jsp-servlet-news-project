package com.tintuc24h.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.ocpsoft.prettytime.PrettyTime;

import com.tintuc24h.models.Comment;
import com.tintuc24h.services.ICommentService;
import com.tintuc24h.utils.DbConnection;

public class CommentService  implements ICommentService{
	private Connection conn = DbConnection.getConnection();
	@Override
	public List<Comment> findByPostId(Integer postId,Integer page) {
		try {
			String sql = "select c.*,u.name from comment c join users u  on c.user_id = u.id where post_id = ? order by id desc limit 5 offset (?-1)*5 ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,postId);
			ps.setInt(2,page);
			ResultSet rs = ps.executeQuery();
			List<Comment> cmts = new ArrayList<Comment>();
			while(rs.next()) {
				Comment cmt = new Comment();
				cmt.Content = rs.getString("content");
				cmt.Fname = rs.getString("name");
				PrettyTime pt = new PrettyTime(new Locale("vi"));
				cmt.TimeAgo = pt.format(rs.getTimestamp("created_date"));
				cmt.Id = rs.getInt("id");
				cmts.add(cmt);
			}
			return cmts;
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public Integer getTotalComment(Integer postId) {
		try {
			String sql = "select count(*) as total from comment where post_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,postId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt("total");
			}
			return -1;
		} catch (Exception e) {
			return -1;
		}
	}

}
