<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!-- page isErrorPage="true"로 설정시 exception 내장 객체를 사용할 수 있다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<h1>뭔가 잘못됐습니다.</h1>
	<!-- 발생한 Exception정보를 표시해주고 싶은 경우 -->
	<p>ERROR CODE : <%= response.getStatus() %>
	<p>Cause : <%= exception.getMessage() %>
</body>
</html>