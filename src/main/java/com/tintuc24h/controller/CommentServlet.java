package com.tintuc24h.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.tintuc24h.models.Comment;
import com.tintuc24h.services.ICommentService;
import com.tintuc24h.services.IPostService;
import com.tintuc24h.services.IUserSerivce;

@WebServlet(urlPatterns = "/Comment")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Inject IUserSerivce userService;
       @Inject IPostService postService;
       @Inject ICommentService cmtService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if(action!=null && action.equals("total")) {
			Integer totalCmt = cmtService.getTotalComment(Integer.parseInt(request.getParameter("postid")));
			response.getWriter().print(totalCmt);
		}else if(action!=null && action.equals("next")) {
			List<Comment> cmts = cmtService.findByPostId(Integer.parseInt(request.getParameter("postid")),Integer.parseInt(request.getParameter("page")));
			response.getWriter().print(new Gson().toJson(cmts));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String fname = (String) session.getAttribute("fname");
		String username = (String) session.getAttribute("user");
		if (username!= null) {
			Integer userId = userService.isUserExist(username);
			String content = request.getParameter("content");
			Integer postId = Integer.parseInt(request.getParameter("postid"));
			Boolean  rs = postService.createComment(postId, userId, content);
			if(rs) {
				response.getWriter().print(fname);
			}else {
				response.getWriter().print("failure");
			}
		} else {
			response.getWriter().print("failure");
		}
	}

}
