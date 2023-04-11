package com.ssafy.project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.project.dto.User;
import com.ssafy.project.exception.AuthenticationException;
import com.ssafy.project.exception.DuplicateUserException;
import com.ssafy.project.exception.IDNotFoundException;
import com.ssafy.project.service.IUserService;
import com.ssafy.project.service.UserServiceImpl;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IUserService userService = UserServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		String path = "/";

		try {
			if (action.equals("login")) {
				path = doLogin(request, response);
				response.sendRedirect(request.getContextPath() + path);
			}

			if (action.equals("logout")) {
				path = doLogout(request, response);
				response.sendRedirect(request.getContextPath() + path);
			}

			if (action.equals("regist")) {
				path = doRegister(request, response);
				response.sendRedirect(request.getContextPath() + path);
			}
			if (action.equals("view")) {
				path = doView(request, response);
				request.getRequestDispatcher(path).forward(request, response);
			}

			if (action.equals("update")) {
				path = doUpdate(request, response);
				response.sendRedirect(request.getContextPath() + path);
			}

		} catch (Exception e) {
			// error page 만들어야 함
		}
	}

	private String doUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, IDNotFoundException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String sido = request.getParameter("sido");
		String gugun = request.getParameter("gugun");
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setId(id);
		user.setEmail(email);
		user.setSido(sido);
		user.setGugun(gugun);

		userService.update(user);
		String str = "/UserController?action=view&id="+user.getId();
		return str;
	}

	private String doView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, IDNotFoundException {
		String id = request.getParameter("id");
		User user = userService.SearchById(id);
		request.setAttribute("userInfo", user);
		return "/auth/mypage.jsp";
	}

	private String doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, AuthenticationException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		User user = userService.login(id, password);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		return "/index.jsp";

	}

	private String doLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();

		return "/index.jsp";
	}

	private String doRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, DuplicateUserException, SQLException {

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String sido = request.getParameter("sido");
		String gugun = request.getParameter("gugun");

		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setId(id);
		user.setEmail(email);
		user.setSido(sido);
		user.setGugun(gugun);

		System.out.println(user.toString());

		userService.add(user);
		return "/index.jsp"; ///////////////////////
	}
}
