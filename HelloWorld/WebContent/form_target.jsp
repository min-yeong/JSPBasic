<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>From Result</title>
</head>
<body>
	<h1>Request Information</h1>
	<ul>
		<li>Request Method : <%= request.getMethod() %>
		<li>Context Path : <%=request.getContextPath() %>
	</ul>
	
	<h3>HTTP Headers</h3>
	<%
	Enumeration<String> headerNames = request.getHeaderNames();
	%>
	<ul>
	<% 
	while(headerNames.hasMoreElements()) {
	String headerName = headerNames.nextElement();
	%>
	<li><%= headerName %> :
		<%= request.getHeader(headerName) %></li>
	<% } %>
	</ul>
	
	<h3>Parameters</h3>
	<ul>
	<%
	Enumeration<String> paramNames = request.getParameterNames();
	while(paramNames.hasMoreElements()) {
		String paramName = paramNames.nextElement(); %>
	<li><%= paramName %> :
		<%
		if(paramName.equals("pet")) {
			//배열로 넘어올것(checkbox))
			String[] pets = request.getParameterValues("pet");%> 
			<%= String.join(",", pets) %>
		<%} 
		else {  %>
		<%= request.getParameter(paramName) %>
			<% 	
			} %>
		</li> <% 
		} %>
	</ul>
</body>
</html>