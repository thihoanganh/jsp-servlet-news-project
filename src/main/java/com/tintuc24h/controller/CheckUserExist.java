package com.tintuc24h.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tintuc24h.services.IUserSerivce;


@WebServlet(urlPatterns = "/CheckUserExist")
public class CheckUserExist extends HttpServlet {
	@Inject
	 IUserSerivce userService;
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String username = request.getParameter("username");
			Integer userId = userService.isUserExist(username);
			if (userId != -1) {
				response.getWriter().print(true);
			} else {
				response.getWriter().print(false);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
