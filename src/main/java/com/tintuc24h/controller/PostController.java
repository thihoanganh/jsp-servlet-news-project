package com.tintuc24h.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tintuc24h.models.Post;
import com.tintuc24h.services.ICategoryService;
import com.tintuc24h.services.ICommentService;
import com.tintuc24h.services.IPostService;

@WebServlet(urlPatterns = "/bai-viet")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Inject IPostService postService;
       @Inject ICommentService cmtService;
       @Inject ICategoryService cateService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer postId = Integer.parseInt(request.getParameter("id"));
		Post post = postService.findById(postId);
		request.setAttribute("cates", cateService.findAll()); // set category default for every page for top menu 
		if(post != null && request.getParameter("title").equals(post.Segment)) {
			request.setAttribute("post", post);
			request.setAttribute("cmts", cmtService.findByPostId(postId,1));
			request.setAttribute("totalCmt", cmtService.getTotalComment(postId));
			request.setAttribute("cate", cateService.findById(post.CateId));
			request.setAttribute("RelatedPost", postService.getRelatedPost(postId));
			request.setAttribute("PostOfCategory", postService.countPostByCate());
			request.setAttribute("relatedPostOfCate", postService.findByCateLimit(post.CateId,5));
			request.getRequestDispatcher("/views/user/detail.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/views/notfound.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
