package com.tintuc24h.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tintuc24h.models.User;
import com.tintuc24h.services.ICategoryService;
import com.tintuc24h.services.IUserSerivce;

@WebServlet(urlPatterns = "/dang-ki")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	IUserSerivce userService;
	@Inject
	ICategoryService cateService;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cates", cateService.findAll()); // set category default for every page for top menu 
		request.getRequestDispatcher("/views/notfound.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		request.setAttribute("cates", cateService.findAll()); // set category default for every page for top menu 
		User user = new User();
		user.Name = request.getParameter("name");
		user.Username = request.getParameter("username");
		user.Password = request.getParameter("password");
		user.Email = request.getParameter("email");
		user.Gender = request.getParameter("gender").equals("Male") ? true : false;
		User result = userService.create(user);
		if(result == null) {
			response.sendRedirect(request.getContextPath()+"/trang-chu?action=dang-ki&status=false");
		}else {
			response.sendRedirect(request.getContextPath()+"/trang-chu?action=dang-ki&status=true");
		}
		
	}

}
