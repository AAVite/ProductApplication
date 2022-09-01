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
 out.println(ub.getfName()+"&nbsp&nbsp"+ub.getlName()+
		 "&nbsp&nbsp"+ub.getAddr()+"&nbsp&nbsp"+
		 "&nbsp&nbsp"+ub.getmId()+"&nbsp&nbsp"+ub.getPhNo()+"<br>");
 String s1=(String)application.getAttribute("logintype");
 if(s1.equals("UserBean"))
 {
	 %>
	 <jsp:include page="link1.html"/>
	 <% 
 }else
 {
	 %>
	 <jsp:include page="link2.html"/>
	 <% 
 }
%>
</body>
</html>