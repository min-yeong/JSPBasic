<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<% // JAVA 코드
	String name = request.getParameter("name");
	// 만약 Parameter name이 없다면 Anonymous
	if (name==null) {
		name="Anonymous";
	}
	%>
	<!-- HTML주석 -->
	<%-- JSP주석 --%>
	<h1>Dynamic Web Page</h1>
	<h3>Hello, <%= name %>></h3>
	<p>이것은 JSP로 만들어진 동적 페이지입니다.</p>
</body>
</html>