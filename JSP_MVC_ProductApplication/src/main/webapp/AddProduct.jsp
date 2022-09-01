<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
UserBean ub=(UserBean)session.getAttribute("ubean");
out.println("Page of "+ub.getfName()+"<br>");
out.println("'Product Added Successfully...<br>");
%>
<jsp:include page="link2.html"/>
</body>
</html>