package com.tintuc24h.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tintuc24h.services.IPostService;

@WebServlet(urlPatterns = "/SwitchPostTrending")
public class SwitchPostTrending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Inject IPostService postService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		postService.switchTrending(Integer.parseInt(request.getParameter("id")), Boolean.parseBoolean(request.getParameter("status")));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
