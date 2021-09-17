package com.tintuc24h.controller;

import java.io.IOException;
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

@WebServlet(urlPatterns = "/the-loai")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	IPostService postService;
	@Inject
	ICategoryService cateService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer cateId =  Integer.parseInt(request.getParameter("id"));
		Integer page = Integer.parseInt(request.getParameter("page"));
		List<Post> posts = postService.findByCateId(cateId,page);
		Integer totalPosts = postService.findByCateId(cateId).size();
		Integer totalPage = (int) Math.ceil((double)totalPosts/10); // 10 post for a page by default
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", page);
		
		request.setAttribute("posts", posts);
		request.setAttribute("cates", cateService.findAll()); // set category default for every page for top menu 
		
		request.setAttribute("cate", cateService.findById(cateId));
		request.setAttribute("PostOfCategory", postService.countPostByCate());
		request.setAttribute("randomPost", postService.randomPost(5));
		request.setAttribute("covidPostInCollectionBar", postService.findByCate(1, 5));
		request.setAttribute("latestPostInCollectionBar", postService.getLatest(5));
		request.setAttribute("popularPostInCollectionBar", postService.getLatest(5));
		request.getRequestDispatcher("/views/user/cate.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
