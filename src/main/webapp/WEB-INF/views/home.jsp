<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Home Page Main 
</h1>

<jsp:include page="./menu.jsp"></jsp:include>

<%-- <P>  The time on the server is ${serverTime}. </P> --%>
	<!-- <table border="1" width="100%">
		<tr>
		 <td>회사소개</td>
		 <td>제품안내</td>
		 <td><a href="./boardList">자유게시판</a></td>
		 <td><a href="./fileuptest">파일 업로드</a></td>
		</tr>
	</table> -->
</body>
</html>
