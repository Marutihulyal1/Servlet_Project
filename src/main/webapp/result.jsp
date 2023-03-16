<%@page import="dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  List<User> list=(List<User>)request.getAttribute("list");%>

<table border="1">
<tr>
<th>User Name</th>
<th>User Email</th>
<th>User MobNo</th>
<th>User Password</th>
<th>Delete</th>
<th>Edit</th>
</tr>

<% for(User user:list)
{%>

<tr>

<td><%=user.getName() %></td>
<td><%=user.getEmail() %></td>
<td><%=user.getMobno() %></td>
<td><%=user.getPassword() %></td>
<td><a href="delete?email=<%=user.getEmail()%>"><button>Delete</button><a></a></td>
<td><a href="edit.jsp?email=<%=user.getEmail()%>"><button>Edit</button></a></td>

</tr>

<%} %>
</table>
<button onclick="window.print()">Print</button>

<button><a href="Login.html">Back</a></button>


</body>
</html>