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
<div>Supplier</div>
<form:form action="addsupplier" method="post" >
   
    <div class="form-group">
      <label for="inputlg">name</label>
      <form:input class="form-control" path="name" type="text" />
    </div>
    <div class="form-group">
      <label for="inputlg">address</label>
      <form:input class="form-control" path="address" type="text" />
    </div>
     <button type="submit" class="btn-btn-primary" value="submit">submit</button>
  
    </form:form>
  
   
</body>
</html>