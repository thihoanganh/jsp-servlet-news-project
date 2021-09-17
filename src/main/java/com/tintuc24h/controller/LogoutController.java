package com.tintuc24h.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tintuc24h.services.ICategoryService;
import com.tintuc24h.services.IPostService;

@WebServlet(urlPatterns = "/dang-xuat")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Inject ICategoryService cateService;
       @Inject IPostService postService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("fname");
		
		response.sendRedirect(request.getContextPath()+"/trang-chu");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
