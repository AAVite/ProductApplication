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
ProductBean pb=(ProductBean)session.getAttribute("pb");
%>
<form action="update" method="post">
ProductPrice:<input type="text" name="pprice" value="<%=pb.getPrice() %>">
ProductQty:<input type="text" name="pqty" value="<%=pb.getQty() %>">
<input type="submit" value="UpdateProduct">
</form>
</body>
</html>