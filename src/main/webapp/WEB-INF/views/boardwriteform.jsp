<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board write form</title>
</head>
<body>

<jsp:include page="./menu.jsp"></jsp:include>

	<br>
	
		<form action="./boardWrite" method="post" enctype="multipart/form-data">
		  <table border="1">
			<tr>
				<td>
					<input type="text" id="b_title" name="b_title" size="30" maxlength="50">
				</td>
			</tr>
			<tr>
			  <td>
				<input type="text" id="b_writer" name="b_writer" size="30" maxlength="50">
			  </td>
			</tr>
			<tr>
			    <td>
				  <textarea rows="5" cols="30" id="b_contents" name="b_contents"></textarea>
				</td>
			</tr>
			<tr>
			   <td>
			   	<input type="file" id="file1" name="file1"/>
			   </td>
			</tr>
		    <tr><td><input type="submit"/></td></tr>
		</table>
     </form>
</body>
</html>