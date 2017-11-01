<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>file up test</title>
</head>
<body>

<jsp:include page="./menu.jsp"></jsp:include>

	<form action="./fileupload" id="form1" name="form1" enctype="multipart/form-data" method="post">
		<input type="file" name="file1" >
		<input type="submit">
	</form>
</body>
</html>