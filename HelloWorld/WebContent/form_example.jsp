<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTML FORM 연습</title>
</head>
<body>
	<h1>HTML FORM 예제</h1>
	<!-- action : 요청을 처리할 페이지, method=GET or POST -->
	<form action="form_target.jsp" method="POST">
	
		<!-- name 속성은 서버에서 getParameter로 접근할 이름 -->
		<input type="hidden" name="secret" value="secret value"/>
		
		<label for="text_field">텍스트필드</label>
		<input type="text" name="text_field" placeholder="여기에 텍스트를 입력하세요."/><br/>
		
		<label for="pass_field">암호필드</label>
		<input type="password" name="pass_field" placeholder="여기에 암호를 입력하세요"/><br/>
		
		<!-- 체크박스는 여러개의 항목 중 선택(중복허용), 선택값은 서버에서 배열로 받을 수 있다 -->
		<label>체크박스</label>
		<input type="checkbox" name="pet" value="dog">개
		<input type="checkbox" name="pet" value="cat">고양이
		<input type="checkbox" name="pet" value="bird">새
		<br>

		<!-- Radio: 여러 항목 중 선택(중복불가) -->		
		<label for="fruit">Radio</label>
		<input type="radio" name="friut" value="apple">사과
		<input type="radio" name="fruit" value="orange">오렌지
		<input type="radio" name="fruit" value="grape" checked>포도
		<!-- checked는 미리 선택된 상태로 출력 -->
		<br>
		
		<!-- SELECT : Drop down(펼침선택, 여러 옵션중에서 한개 선택)  -->
		<label for="sel">SELECT</label>
		<select name="telecom">
			<!-- 내부에 옵션을 가지고 있음 -->
			<option value="S">SKT</option>
			<option value="K">KT</option>
			<option value="L">LG</option>
		</select>
		<br>
		
		<textarea name="content" rows="10 cols="40">
		</textarea>
		<br>
		
		<input type="reset" value="초기화"/>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>