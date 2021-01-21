<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/guest/add" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan="4"><textarea cols="65" rows="10" name="content"></textarea>
				<td>
			</tr>
			<tr>
				<td colspan="4"><button type="submit">확인</button></td>
			</tr>

		</table>
		<br>
	</form>


	<c:forEach items="${guestList}" var="gVo">

		<table border="1">
			<tr>
				<td>${gVo.no }</td>
				<td>${gVo.name }</td>
				<td>${gVo.regDate }</td>
				<td><a href="${pageContext.request.contextPath }/guest/dForm?no=${gVo.no }">삭제
				</a></td>
			</tr>
			<tr>
				<td colspan="5">${gVo.content }</td>
			</tr>
		</table>
		<br>
	</c:forEach>

</body>
</html>