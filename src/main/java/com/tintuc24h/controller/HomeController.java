package com.tintuc24h.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tintuc24h.services.ICategoryService;
import com.tintuc24h.services.IPostService;

@WebServlet(urlPatterns = "/trang-chu")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	IPostService postService;
	@Inject
	ICategoryService cateService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("cates", cateService.findAll()); // set category default for every page for top menu
		request.setAttribute("latestPost", postService.getLatest(5));
		// check register success
		if (request.getParameter("action") != null && request.getParameter("action").equals("dang-ki")) {
			if (request.getParameter("status") != null && request.getParameter("status").equals("true")) {
				request.setAttribute("createStatus", "true");
			}
			if (request.getParameter("status") != null && request.getParameter("status").equals("false")) {
				request.setAttribute("createStatus", "false");
			}
		}
		// post
		request.setAttribute("covidPost", postService.findByCate(1, 5));
		request.setAttribute("SocietyPost", postService.findByCate(2, 5));
		request.setAttribute("EcomercePost", postService.findByCate(4, 5));
		request.setAttribute("CulturePost", postService.findByCate(3, 5));
		// end post
		// cate
		request.setAttribute("covidCate", cateService.findById(1));
		request.setAttribute("SocietyCate", cateService.findById(2));
		request.setAttribute("EcomerceCate", cateService.findById(4));
		request.setAttribute("CultureCate", cateService.findById(3));
		// end cate
		// post in collection bar
		request.setAttribute("covidPostInCollectionBar", postService.findByCate(1, 7));
		request.setAttribute("latestPostInCollectionBar", postService.getLatest(7));
		request.setAttribute("popularPostInCollectionBar", postService.getLatest(7));
		// end post in collection bar
		request.setAttribute("outstandingPost", postService.outstandingPost(4));
		request.setAttribute("highView", postService.getHighestView(9));
		request.setAttribute("randomPost", postService.randomPost(10));
		request.getRequestDispatcher("/views/user/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
