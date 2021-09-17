package com.tintuc24h.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tintuc24h.models.LoginResult;
import com.tintuc24h.services.IUserSerivce;

@WebServlet(urlPatterns = "/dang-nhap")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	IUserSerivce userService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!= null) {
			response.sendRedirect(request.getContextPath()+"/trang-chu");
		}else if (session.getAttribute("admin")!= null) {
			response.sendRedirect(request.getContextPath()+"/admin");
		}else {
			if(request.getParameter("redirect")!=null) {
				request.setAttribute("returnUrl", request.getParameter("redirect")+"&id=" + request.getParameter("id"));
				request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
			}else if(request.getParameter("returnUrl")!=null && request.getParameter("returnUrl").startsWith("bai-viet")) {
				request.setAttribute("returnUrl",request.getParameter("returnUrl"));
				request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
			}else {
				request.setAttribute("returnUrl", "trang-chu");
				request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (userService.isUserBlock(username)) {
			request.setAttribute("error", "Tài khoản đã bị khóa");
			request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
		} else {
			LoginResult loginResult = userService.Login(username, password);
			if (loginResult != null) {
				if (loginResult.Role!= null && loginResult.Role.equals("admin")) {
					HttpSession session = request.getSession();
					session.setAttribute("admin", username);
					response.sendRedirect(request.getContextPath() + "/admin");
				} else {
					
						HttpSession session = request.getSession();
						session.setAttribute("user", username);
						session.setAttribute("fname", userService.findByUsername(username).Name);
						response.sendRedirect(request.getContextPath() + "/"+ request.getParameter("returnUrl"));
				}

			} else {
				request.setAttribute("error", "Tài khoản không hợp lệ");
				 if(request.getParameter("returnUrl")!=null && request.getParameter("returnUrl").startsWith("bai-viet")) {
						request.setAttribute("returnUrl",request.getParameter("returnUrl"));
					}else {
						request.setAttribute("returnUrl", "trang-chu");
					}
				request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
			}
		}
	}

}
