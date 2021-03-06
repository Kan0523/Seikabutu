package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import service.UserService;

@WebServlet(urlPatterns = {"/signup"})
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.getRequestDispatcher("signup.jsp").forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		List<String> messages = new ArrayList<String>();
		HttpSession session = request.getSession();
		if(isValid(request,messages) == true) {

			User user = new User();
			user.setName(request.getParameter("name"));
			user.setAccount(request.getParameter("account"));
			user.setPassword(request.getParameter("password"));
			user.setEmail(request.getParameter("email"));
			user.setDescription(request.getParameter("discription"));

			new UserService().register((org.apache.catalina.User) user);

			response.sendRedirect("./");
		}else {
			session.setAttribute("errorMessages",messages);
			response.sendRedirect("signup");
		}
	}

	private boolean isValid(HttpServletRequest request,List<String>messages) {
		String account = request.getParameter("account");
		@SuppressWarnings("unused")
		String password = request.getParameter("Password");

		if(StringUtils.isEmpty(account) == true) {
			messages.add("アカウント名を入力して下さい");
		}
		if(StringUtils.isEmpty(account) == true) {
            messages.add("パスワードを入力してください");
		}
		if(messages.size() == 0) {
			return true;
		}else {
			return false;
		}
	}



}
