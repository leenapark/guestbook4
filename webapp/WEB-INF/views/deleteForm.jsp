<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>비밀번호 확인</h1>

	<c:if test="${param.result != null}">
		<p>비밀 번호가 틀렸습니다. 다시 입력해주세요.</p>
	</c:if>
	
	<form action="${pageContext.request.contextPath }/guest/delete" method="post">
		비밀번호<input type="password" name="password">
		<input type="text" name="no" value="${param.no }">
		<button type="submit">확인</button>

	</form>
	<br>
	<a href="${pageContext.request.contextPath }/guest/list">메인으로 돌아가기</a>
	
</body>
</html>