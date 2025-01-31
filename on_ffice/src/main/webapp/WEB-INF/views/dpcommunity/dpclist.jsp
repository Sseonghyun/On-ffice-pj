<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 자유 게시판</title>
</head>
<script>
</script>
<body>
	<h1>부서 자유 게시판</h1>
	
	<table>
		<tr>
			<th>글번호</th>
			<th>부서번호</th>
			<th>사원번호</th>
			<th>글제목</th>
			<th>글본문</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>수정일</th>
			<th>조회수</th>
		</tr>
	</table>
	<c:if test="SELECT * FROM depart_community WHERE dp_code = ${login_session.dp_code}">
		<c:forEach items="${dpCommunityList}" var="dpcList">
			<tr>	
				<td>${dpcList.dc_num}</td>
				<td>${dpcList.dp_code}</td>
				<td>${dpcList.empno}</td>
				<td><a href="/dpcommunity/dpcdetail?dc_num=${dpcList.dc_num}">${dpcList.dtitle}</a></td>
				<td>${dpcList.dcontent}</td>
				<td>${dpcList.dwriter}</td>
				<td>${dpcList.ddate}</td>
				<td>${dpcList.dupdate}</td>
				<td>${dpcList.dhits}</td>
			</tr>
		</c:forEach>
	</c:if>
	<br/>		
	<a href="/dpcommunity/dpcwrite"><button>게시글 작성</button></a><br/>
</body>
</html>