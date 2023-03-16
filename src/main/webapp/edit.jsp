<%@page import="dto.User"%>
<%@page import="dao.Userdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>

<%String email=request.getParameter("email"); 
Userdao userdao=new Userdao();
User user=userdao.find(email);
%>


<form action="update" method="post">
<table border="3px">

        <tr>
            <th>
                <label for="m">Name</label>
            </th>
            <td>
                <input type="text" name="name" id="m" value="<%=user.getName()%>">
            </td>
        </tr>
        
        <tr>
            <th>
                <label for="m1">Email</label>
            </th>
            <td>
                <input type="text" name="email" id="m1" value="<%=user.getEmail()%>"readonly="readonly"">
            </td>
        </tr>
        
          <tr>
            <th>
                <label for="m2">MobNo</label>
            </th>
            <td>
                <input type="text" name="mobb" id="m2" value="<%=user.getMobno() %>">
            </td>
        </tr>
        
        <tr>
            <th>
                <label for="m3">Password</label>
            </th>
            <td>
                <input type="text" name="pwd" id="m3" value="<%=user.getPassword() %>">
            </td>
        </tr>
        
        <td>
          <button>Update</button>
        </td>
        
  
        
 </table>
 </form>
        
        

</body>
</html>