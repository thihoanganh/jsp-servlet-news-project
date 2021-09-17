package com.tintuc24h.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tintuc24h.models.Post;
import com.tintuc24h.models.User;
import com.tintuc24h.services.ICategoryService;
import com.tintuc24h.services.IPostService;
import com.tintuc24h.services.IUserSerivce;
import com.tintuc24h.utils.StringUtil;

@WebServlet(urlPatterns = "/admin")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Post> allPosts;
	@Inject
	IUserSerivce userService;
	@Inject
	IPostService postService;
	@Inject
	ICategoryService categoryService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {
			response.sendRedirect(request.getContextPath() + "/dang-nhap");
		}else {
			String action = request.getParameter("action");
			if (action != null && action.equals("dang-xuat")) {
				session.removeAttribute("admin");
				response.sendRedirect(request.getContextPath() + "/dang-nhap");
			} else if (action != null && action.equals("tai-khoan")) {
				List<User> users = userService.findAll();
				request.setAttribute("users", users);
				request.getRequestDispatcher("/views/admin/user.jsp").forward(request, response);
			} else if (action != null && action.equals("bai-viet")) {
				Integer page = Integer.parseInt(request.getParameter("page"));
				Integer size = 10 ;
			    allPosts = postService.findAll();
				request.setAttribute("posts", postService.findAll(page,size));
				request.setAttribute("totalPost", allPosts.size());
				request.setAttribute("totalPage", Math.ceil((double)allPosts.size()/size));
				request.setAttribute("page", page);
				request.setAttribute("cates", categoryService.findAll());
				request.getRequestDispatcher("/views/admin/post.jsp").forward(request, response);
			} else if (action != null && action.equals("tao-bai-viet")) {
				request.setAttribute("cates", categoryService.findAll());
				request.getRequestDispatcher("/views/admin/create.jsp").forward(request, response);
			} 
			else if (action != null && action.equals("chinh-sua")) {
				Integer postId = Integer.parseInt(request.getParameter("id"));
				Post post = postService.findById(postId);
				request.setAttribute("post", post);
				if(post.Tags!=null) {
					request.setAttribute("tags",String.join(",",post.Tags) );
				}else {
					request.setAttribute("tags","");
				}
				
				request.setAttribute("cates", categoryService.findAll());
				request.getRequestDispatcher("/views/admin/edit.jsp").forward(request, response);
			} 
			else if (action != null && action.equals("xoa")) {
				Integer postId = Integer.parseInt(request.getParameter("id"));
				Integer size = 10 ;
				postService.delete(postId);
				List<Post> posts = postService.findAll(1,size);
				request.setAttribute("posts",posts );
				request.setAttribute("totalPost", posts.size());
				request.setAttribute("totalPage", Math.ceil((double)posts.size()/7));
				request.setAttribute("page", 1);
				request.setAttribute("cates", categoryService.findAll());
				request.getRequestDispatcher("/views/admin/post.jsp").forward(request, response);
				
			} 
			else if (action == null || action.equals("thong-ke")) {
				request.getRequestDispatcher("/views/admin/index.jsp").forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if (action != null && action.equals("tao-bai-viet")) {
			Post post = new Post();
			String tags = request.getParameter("tags");
			post.Tags = tags.split(",");
			post.Title = request.getParameter("title");
			post.Segment = StringUtil.generateSlug(request.getParameter("title"));
			post.Content = request.getParameter("content");
			post.Excerpt = request.getParameter("excerpt");
			post.CateId = Integer.parseInt(request.getParameter("cate"));
			String uploadedFileName = UploadFile(request);
			post.Thumb = uploadedFileName;
			if (postService.create(post)) {
				request.setAttribute("success", "Tạo bài viết thành công");
			} else {
				request.setAttribute("error", "Tạo bài viết thất bại. Vui lòng thử lại");
			}
			response.sendRedirect(request.getContextPath()+"/admin?action=bai-viet&page=1");
		}else if (action != null && action.equals("filter")) {
			List<Post> posts = postService.findByCate(Integer.parseInt(request.getParameter("cateid")));
			request.setAttribute("posts", posts);
			request.setAttribute("totalPost", posts.size());
			request.setAttribute("totalPage", Math.ceil((double)posts.size()/7));
			request.setAttribute("page", 1);
			request.setAttribute("cates", categoryService.findAll());
			request.getRequestDispatcher("/views/admin/post.jsp").forward(request, response);
		}else if(action != null && action.equals("search")) {
			List<Post> posts = postService.search(request.getParameter("key"));
			request.setAttribute("posts", posts);
			request.setAttribute("totalPost", posts.size());
			request.setAttribute("totalPage", Math.ceil((double)posts.size()/7));
			request.setAttribute("page", 1);
			request.setAttribute("cates", categoryService.findAll());
			request.getRequestDispatcher("/views/admin/post.jsp").forward(request, response);
		}else if(action != null && action.equals("paginate")) {
			List<Post> posts = postService.paginate(Integer.parseInt(request.getParameter("page")));
			request.setAttribute("posts", posts);
			request.setAttribute("totalPost", allPosts.size());
			request.setAttribute("totalPage", Math.ceil((double)allPosts.size()/10));
			request.setAttribute("page", Integer.parseInt(request.getParameter("page")));
			request.setAttribute("cates", categoryService.findAll());
			request.getRequestDispatcher("/views/admin/post.jsp").forward(request, response);
		}
		else if(action != null && action.equals("chinh-sua")) {
			Post post = new Post();
			post.Title = request.getParameter("title");
			String tags = request.getParameter("tags");
			post.Tags = tags.split(",");
			post.Excerpt = request.getParameter("excerpt");
			post.Content = request.getParameter("content");
			post.Id = Integer.parseInt(request.getParameter("id"));
			post.CateId =Integer.parseInt( request.getParameter("cate"));
			String uploadFileNameString = UploadFile(request);
			if(uploadFileNameString != null) {
				post.Thumb = uploadFileNameString;
				postService.update(post);
				removeFile(request.getParameter("oldthumb"),request);
			}else {
				postService.update(post);
			}
			response.sendRedirect(request.getContextPath()+"/admin?action=bai-viet&page=1");
		}
	}

	private String UploadFile(HttpServletRequest request) {
		try {
			String appPath = request.getServletContext().getRealPath("");
			appPath = appPath.replace('\\', '/');

			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (fileName != null && fileName.length() > 0) {
					String ext = getExt(fileName);
					fileName = UUID.randomUUID().toString().replace("-", "") + "." + ext;
					String filePath = appPath + "assets/thumb/" + fileName;
					System.out.println("Write attachment to file: " + filePath);
					part.write(filePath);
					return fileName;
				}

			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
				clientFileName = clientFileName.replace("\\", "/");
				return clientFileName;
			}
		}	
		return null;
	}

	private String getExt(String name) {
		int lastIndex = name.lastIndexOf('.');
		if (lastIndex == -1) {
			return null;
		}
		return name.substring(lastIndex + 1);
	}
	
	private void removeFile(String fileName,HttpServletRequest request) {
		String appPath = request.getServletContext().getRealPath("");
		appPath = appPath.replace('\\', '/');
		String filePath = appPath + "assets/thumb/" + fileName;
		File file = new File(filePath);
		file.delete();
	}

}
