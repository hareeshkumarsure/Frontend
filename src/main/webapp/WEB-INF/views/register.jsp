<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="signup" method="post" >
    <%-- <div class="form-group">
      <label for="inputdefault">role</label>
      <form:input class="form-control" path="role" type="text" />
    </div> --%>
    <div class="form-group">
      <label for="inputlg">name</label>
      <form:input class="form-control" path="name" type="text" />
    </div>
    <div class="form-group">
      <label for="inputlg">Mail Id</label>
      <form:input class="form-control" path="email" type="email" />
    </div>
    <div class="form-group">
      <label for="inputlg">Phone Number</label>
      <form:input class="form-control" path="contact" type="text" />
    </div>
    <div class="form-group">
      <label for="inputlg">Password</label>
      <form:input class="form-control" path="password" type="password" />
    </div>
   
   <button type="submit" class="btn-btn-primary" value="submit">submit</button>
  
    </form:form>
   
</body>
</html>