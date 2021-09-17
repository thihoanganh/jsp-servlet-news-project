package com.tintuc24h.service.impl;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.ocpsoft.prettytime.PrettyTime;

import com.tintuc24h.models.Category;
import com.tintuc24h.models.Post;
import com.tintuc24h.services.IPostService;
import com.tintuc24h.utils.DbConnection;

public class PostService implements IPostService {
	private Connection conn = DbConnection.getConnection();

	@Override
	public List<Post> findAll(Integer page,Integer size) {
		try {
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id order by id desc offset(?-1)*? limit ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,page);
			ps.setInt(2,size);
			ps.setInt(3,size);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.CreatedDate = rs.getTimestamp("created_date");
				if(rs.getArray("tag")!=null) {
					post.Tags = (String[])rs.getArray("tag").getArray();	
				}else {
					post.Tags = null;
				}
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean create(Post post) {
		try {
			String sql = "insert into post(title,content,excerpt,thumb,cate_id,view,trending,segment,tag) values(?,?,?,?,?,0,false,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, post.Title);
			ps.setString(2, post.Content);
			ps.setString(3, post.Excerpt);
			ps.setString(4, post.Thumb);
			ps.setInt(5, post.CateId);
			ps.setString(6, post.Segment);
			ps.setArray(7,( java.sql.Array)conn.createArrayOf("varchar",post.Tags));
			ps.execute();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Boolean switchTrending(Integer id, Boolean trending) {
		try {
			String sql = "update post set trending = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, trending);
			ps.setInt(2, id);
			ps.execute();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<Post> findByCate(Integer id) {

		try {
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id where c.id = ? order  by id desc ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.CreatedDate = rs.getTimestamp("created_date");
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Post> search(String key) {
		try {
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id where LOWER(p.title) like ? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + key.toLowerCase() + "%");
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.CreatedDate = rs.getTimestamp("created_date");
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Post> paginate(Integer page) {
		try {
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id  order by id desc limit 10 offset (?-1)*10 ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, page);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.CreatedDate = rs.getTimestamp("created_date");
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Post findById(Integer id) {

		try {
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id where p.id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.CreatedDate = rs.getTimestamp("created_date");
				post.Segment = rs.getString("segment");
				if(rs.getArray("tag")!=null) {
					post.Tags = (String[])rs.getArray("tag").getArray();	
				}
				return post;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean update(Post post) {
		try {
			PreparedStatement ps;
			if (post.Thumb == null) {
				String sql = "update post set title = ? , content = ? , excerpt = ? , cate_id = ?, tag = ? where id = ? ";
				ps = conn.prepareStatement(sql);
				ps.setInt(6, post.Id);

			} else {
				String sql = "update post set title = ? , content = ? , excerpt = ? , cate_id = ?,tag=?, thumb = ? where id = ? ";
				ps = conn.prepareStatement(sql);
				ps.setString(6, post.Thumb);
				ps.setInt(7, post.Id);
			}
			ps.setString(1, post.Title);
			ps.setString(2, post.Content);
			ps.setString(3, post.Excerpt);
			ps.setInt(4, post.CateId);
			ps.setArray(5,(java.sql.Array) conn.createArrayOf("varchar",post.Tags));
			ps.execute();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			String sql = "delete from post where id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Post> getLatest(Integer limit) {
		
		try {
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id  order by id desc limit ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, limit);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.Segment = rs.getString("segment");
				post.CreatedDate = rs.getTimestamp("created_date");
				PrettyTime p = new PrettyTime(new Locale("vi"));
				post.TimeAgo = p.format(rs.getTimestamp("created_date"));
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Post> getHighestViewAWeek(Integer limit) {
		try {
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id\r\n"
					+ "where created_date <= now() and created_date >= (now() - INTERVAL '1 week') order by view desc limit ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, limit);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.Segment = rs.getString("segment");
				post.CreatedDate = rs.getTimestamp("created_date");
				PrettyTime p = new PrettyTime(new Locale("vi"));
				post.TimeAgo = p.format(rs.getTimestamp("created_date"));
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Post> findByCate(Integer cateId, Integer limit) {
		try {
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id where c.id = ?  order by id desc limit ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cateId);
			ps.setInt(2, limit);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.Segment = rs.getString("segment");
				post.CreatedDate = rs.getTimestamp("created_date");
				post.Tags = (String[])rs.getArray("tag").getArray();
				PrettyTime p = new PrettyTime(new Locale("vi"));
				post.TimeAgo = p.format(rs.getTimestamp("created_date"));
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Category> countPostByCate() {
		try {
			String sql = "select c.id,count(c.id),c.name,c.slug from category c join post p on p.cate_id = c.id group by c.id,c.name order by c.name";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Category> cates = new ArrayList<Category>();
			while (rs.next()) {
				Category cate = new Category();
				cate.Id = rs.getInt("id");
				cate.Name = rs.getString("name");
				cate.TotalPost = rs.getInt("count");
				cate.CateSlug = rs.getString("slug");
				cates.add(cate);
			}
			return cates;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Post> paginateByCate(Integer page, Integer cateId, Integer size) {
		try {
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id where c.id = ?  order by id desc limit ? offset (?-1)*? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cateId);
			ps.setInt(2, size);
			ps.setInt(3, page);
			ps.setInt(4, size);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.CreatedDate = rs.getTimestamp("created_date");
				PrettyTime p = new PrettyTime(new Locale("vi"));
				post.TimeAgo = p.format(rs.getTimestamp("created_date"));
				post.Segment = rs.getString("segment");
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Post> getHighestView(Integer limit) {
		try {
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id order by view desc limit ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, limit);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.Segment = rs.getString("segment");
				post.CreatedDate = rs.getTimestamp("created_date");
				PrettyTime p = new PrettyTime(new Locale("vi"));
				post.TimeAgo = p.format(rs.getTimestamp("created_date"));
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Post> findByCateLimit(Integer id, Integer limit) {
		try {
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id where c.id = ? order  by id desc limit ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, limit);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.CreatedDate = rs.getTimestamp("created_date");
				post.Segment = rs.getString("segment");
				if(rs.getArray("tag")!=null) {
					post.Tags = (String[])rs.getArray("tag").getArray();	
				}else {
					post.Tags = null;
				}
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Post> findByTag(String tag, Integer page) {
		try {
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id "
					+ "where ? ilike any(tag)  or title like ?"
					+ "order  by id desc "
					+ "limit 10 "
					+ "offset (?-1)*10";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tag);
			ps.setString(2, "%"+tag+"%");
			ps.setInt(3, page);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.CreatedDate = rs.getTimestamp("created_date");
				PrettyTime p = new PrettyTime(new Locale("vi"));
				post.TimeAgo = p.format(rs.getTimestamp("created_date"));
				post.Segment = rs.getString("segment");
				if(rs.getArray("tag")!=null) {
					post.Tags = (String[])rs.getArray("tag").getArray();	
				}else {
					post.Tags = null;
				}
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean createComment(Integer postId, Integer userId, String content) {
		try {
			String sql = "insert into comment(user_id,post_id,content) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,userId);
			ps.setInt(2,postId);
			ps.setString(3,content);
			ps.execute();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Post> randomPost(Integer limit) {
		try {
			String sql = "SELECT * FROM post "
					+ "ORDER BY RANDOM() "
					+ "LIMIT ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, limit);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.CreatedDate = rs.getTimestamp("created_date");
				PrettyTime p = new PrettyTime(new Locale("vi"));
				post.TimeAgo = p.format(rs.getTimestamp("created_date"));
				post.Segment = rs.getString("segment");
				if(rs.getArray("tag")!=null) {
					post.Tags = (String[])rs.getArray("tag").getArray();	
				}else {
					post.Tags = null;
				}
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Post> search(Integer page, String key) {
		try {
			String sql = "select * from post where title ilike ? order by id desc limit 10 offset (?-1)*10";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+key+"%");
			ps.setInt(2, page);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.CreatedDate = rs.getTimestamp("created_date");
				PrettyTime p = new PrettyTime(new Locale("vi"));
				post.TimeAgo = p.format(rs.getTimestamp("created_date"));
				post.Segment = rs.getString("segment");
				if(rs.getArray("tag")!=null) {
					post.Tags = (String[])rs.getArray("tag").getArray();	
				}else {
					post.Tags = null;
				}
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Post> findByCateId(Integer id, Integer page) {
		try {
			String sql = "select p.*,c.name,c.id from post p join category c on p.cate_id = c.id where c.id = ? order by p.id desc offset (?-1)*10 limit 10 ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, page);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.CreatedDate = rs.getTimestamp("created_date");
				post.Segment = rs.getString("segment");
				if(rs.getArray("tag")!=null) {
					post.Tags = (String[])rs.getArray("tag").getArray();	
				}
				PrettyTime p = new PrettyTime(new Locale("vi"));
				post.TimeAgo = p.format(rs.getTimestamp("created_date"));
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Post> findByCateId(Integer id) {
		try {
			String sql = "select p.*,c.name,c.id from post p join category c on p.cate_id = c.id where c.id = ? order by p.id desc  ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.CreatedDate = rs.getTimestamp("created_date");
				post.Segment = rs.getString("segment");
				if(rs.getArray("tag")!=null) {
					post.Tags = (String[])rs.getArray("tag").getArray();	
				}
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Post> outstandingPost(Integer limit) {
		try {
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id where trending = true order by id desc limit ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, limit);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.Segment = rs.getString("segment");
				post.CreatedDate = rs.getTimestamp("created_date");
				PrettyTime p = new PrettyTime(new Locale("vi"));
				post.TimeAgo = p.format(rs.getTimestamp("created_date"));
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Post> findAll() {
		try {
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id  order by id desc  ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.Segment = rs.getString("segment");
				post.CreatedDate = rs.getTimestamp("created_date");
				PrettyTime p = new PrettyTime(new Locale("vi"));
				post.TimeAgo = p.format(rs.getTimestamp("created_date"));
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Post> getRelatedPost(Integer postId) {
		try {
			String subsql = "";
			String[] tags = GetTags(postId);
			for (String tag : tags) {
				subsql += " '"+tag+"' ilike any(tag) or title ilike '%"+tag+"%' or";
			}
			subsql += subsql.substring(0,subsql.lastIndexOf("or"));
			String sql = "select p.*,c.name from post p join category c on p.cate_id = c.id where "+subsql+" order  by id desc limit 10";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Post> posts = new ArrayList<Post>();
			while (rs.next()) {
				Post post = new Post();
				post.Id = rs.getInt("id");
				post.Title = rs.getString("title");
				post.Content = rs.getString("content");
				post.View = rs.getInt("view");
				post.CateId = rs.getInt("cate_id");
				post.Excerpt = rs.getString("excerpt");
				post.CateName = rs.getString("name");
				post.Thumb = rs.getString("thumb");
				post.Trending = rs.getBoolean("trending");
				post.CreatedDate = rs.getTimestamp("created_date");
				post.Segment = rs.getString("segment");
				if(rs.getArray("tag")!=null) {
					post.Tags = (String[])rs.getArray("tag").getArray();	
				}else {
					post.Tags = null;
				}
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			return null;
		}
	}
	
	private String[] GetTags(Integer postId) {
		try {
			String sql = "select tag from post where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,postId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return (String[])rs.getArray("tag").getArray();
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	} 

	

}
