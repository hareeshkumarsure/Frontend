<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body> 


<jsp:include page="/WEB-INF/views/header.jsp"/>
 
<hr>
${registerMessage}
<c:if test="${not empty errorMessage}">
<jsp:include page="login.jsp" />
</c:if>

<c:if test="${userClickedLogin==true}">
<jsp:include page="login.jsp" />
</c:if>

<c:if test="${isUserClickedRegister}">
<jsp:include page="register.jsp" />
</c:if>

<c:if test="${isAdmin==true}">
<jsp:include page="admin1.jsp" />
</c:if>

<c:if test="${adminClickedCategory==true}">
<jsp:include page="category.jsp" />
</c:if>
<c:if test="${userClickedProduct==true}">
<jsp:include page="product.jsp" />
</c:if>
<c:if test="${adminClickedSupplier==true}">
<jsp:include page="supplier.jsp" />
</c:if>

</body>
</html>
