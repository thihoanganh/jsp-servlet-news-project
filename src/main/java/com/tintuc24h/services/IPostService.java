package com.tintuc24h.services;

import java.util.List;

import com.tintuc24h.models.Category;
import com.tintuc24h.models.Post;

public interface IPostService {
	List<Post> findAll(Integer page,Integer size);
	List<Post> findAll();
	Post findById(Integer id);
	List<Post> findByCateId(Integer id,Integer page);
	List<Post> findByCateId(Integer id);
	List<Post> search(String key);
	List<Post> paginate(Integer page);
	List<Post> paginateByCate(Integer page,Integer cateId,Integer size);
	List<Post> findByCate(Integer id);
	List<Post> findByCateLimit(Integer id,Integer limit);
	Boolean create(Post post);
	Boolean switchTrending(Integer id, Boolean trending);
	Boolean update(Post post);
	Boolean delete(Integer id);
	List<Post> getLatest(Integer limit);
	List<Post> getHighestViewAWeek(Integer limit);
	List<Post> getHighestView(Integer limit);
	List<Post> findByCate(Integer cateId,Integer limit);
	List<Category> countPostByCate();
	List<Post> findByTag(String tag,Integer page);
	Boolean createComment(Integer postId,Integer userId,String content) ;
	List<Post> randomPost(Integer limit);
	List<Post> outstandingPost(Integer limit);
	List<Post> search(Integer page,String key); //this regulate 10 items for a page
	List<Post> getRelatedPost(Integer postId); // default limit 10 post
	
}
