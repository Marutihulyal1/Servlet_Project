package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.Userdao;
import dto.User;


@WebServlet("/Sign")
public class SignUpp extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user =new User();
		user.setEmail(req.getParameter("email"));
		user.setMobno(Long.parseLong(req.getParameter("mobb")));
		user.setName(req.getParameter("name"));
		user.setPassword(req.getParameter("pwd"));
		
		Userdao ud=new Userdao();
		try
		{
		ud.save(user);
		res.getWriter().println("<h1>Account Created</h1>");
		req.getRequestDispatcher("Login.html").include(req, res);
		}
		catch(Exception e)
		{
			res.getWriter().print("<h1>Email already exit</h1>");
			req.getRequestDispatcher("SignUp.html").include(req, res);
		}
	}

}
