package com.tintuc24h.services;

import java.util.List;

import com.tintuc24h.models.Comment;

public interface ICommentService {
	List<Comment> findByPostId(Integer postId,Integer page);
	Integer getTotalComment(Integer postId);
}
