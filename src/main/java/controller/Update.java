package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Userdao;
import dto.User;

@WebServlet("/update")
public class Update extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user =new User();
		user.setEmail(req.getParameter("email"));
		user.setMobno(Long.parseLong(req.getParameter("mobb")));
		user.setName(req.getParameter("name"));
		user.setPassword(req.getParameter("pwd"));
		
		Userdao ud=new Userdao();
		ud.updateUser(user);
		
		List<User> list=ud.fetchAll();
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("result.jsp").forward(req, resp);
	}

}
