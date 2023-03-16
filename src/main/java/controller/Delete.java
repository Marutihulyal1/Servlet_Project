package controller;

import java.io.IOException;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import dao.Userdao;
import dto.User;

@WebServlet("/delete")
public class Delete extends HttpServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		
	Userdao userdao=new Userdao();
	 User u=userdao.find(email);
	userdao.delete(u);
	
	List<User> list=userdao.fetchAll();
	req.setAttribute("list", list);
	
	req.setAttribute("list", list);
	req.getRequestDispatcher("result.jsp").forward(req, res);
	 
	


		
	}

}
