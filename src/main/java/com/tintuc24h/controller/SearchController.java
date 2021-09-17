package com.tintuc24h.controller;

import java.io.IOException;import java.math.MathContext;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tintuc24h.models.Post;
import com.tintuc24h.services.ICategoryService;
import com.tintuc24h.services.IPostService;

@WebServlet(urlPatterns = "/tim-kiem")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	IPostService postService;
	@Inject
	ICategoryService cateService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key = java.net.URLDecoder.decode(request.getParameter("key"), StandardCharsets.UTF_8.name()); // decode url
		Integer page = Integer.parseInt(request.getParameter("page"));
			List<Post> posts = postService.search(page,key);
			Integer totalPosts = postService.search(key).size();
			Integer totalPage = (int) Math.ceil((double)totalPosts/10); // 10 post for a page by default
			request.setAttribute("posts", posts);
			request.setAttribute("key", key);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalPosts", totalPosts);
			request.setAttribute("currentPage", page);
			request.setAttribute("cates", cateService.findAll()); // set category default for every page for top menu 
			request.setAttribute("PostOfCategory", postService.countPostByCate()); // side bar data 
			request.getRequestDispatcher("/views/user/search.jsp").forward(request, response);
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
