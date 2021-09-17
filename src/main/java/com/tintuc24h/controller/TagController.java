package com.tintuc24h.controller;

import java.io.IOException;
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

@WebServlet(urlPatterns = "/tag")
public class TagController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	IPostService postService;
	@Inject
	ICategoryService cateService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tag = java.net.URLDecoder.decode(request.getParameter("name"), StandardCharsets.UTF_8.name()); // decode url
		List<Post> post = postService.findByTag(tag,1);
		request.setAttribute("post", post);
		
		request.setAttribute("tag", tag.replace(" ", ""));
		request.setAttribute("cates", cateService.findAll()); // set category default for every page for top menu 
		request.setAttribute("PostOfCategory", postService.countPostByCate()); // side bar data 
		request.getRequestDispatcher("/views/user/tag.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
