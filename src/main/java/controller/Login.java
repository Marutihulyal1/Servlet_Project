package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter;

import dao.Userdao;
import dto.User;


@WebServlet("/Login")
public class Login extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String email=req.getParameter("em");
		String password=req.getParameter("pwd");
		
		Userdao ud=new Userdao();
		User us=ud.find(email);
		
		if(us==null)
		{
			res.getWriter().print("<h1>Invalid email id</h1>");
			req.getRequestDispatcher("Login.html").include(req, res);
		}
		else
		{
			if(us.getPassword().equals(password))
			{
				
//				res.getWriter().print("Login Successfully");
//				List<User> list=ud.fetchAll();
//				for(User uu : list)
//				{
//					res.getWriter().print("<h1>Username: "+uu.getEmail()+"</h1>");
//					res.getWriter().print("<h1>MobNo: "+uu.getMobno()+"</h1>");
//					res.getWriter().print("<h1>Name: "+uu.getName()+"</h1>");
//					res.getWriter().print("<h1>+"+"Password: "+uu.getPassword()+"</h1>");
//					res.getWriter().print("<h1>-----------------------</h1>");
					
//					res.getWriter().print(("<table border=\"1\">"
//							+"<tr>"
				
				List<User> list=ud.fetchAll();
				req.setAttribute("list", list);
					
					req.getRequestDispatcher("result.jsp").forward(req, res);
				}
			else
			{
				res.getWriter().print("<h1>Invalid password</h1>");
				req.getRequestDispatcher("Login.html").include(req, res);
			}
		}
		
	}

}
