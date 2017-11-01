<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board detail</title>
</head>

<body>

<jsp:include page="./menu.jsp"></jsp:include>


    <br>
    <table border="1">
			<tr>
				<td>
				${detailVO.b_no }
				</td>
			</tr>
			<tr>
				<td>
				${detailVO.b_title }
				</td>
			</tr>
			<tr>
				<td>
				${detailVO.b_writer }
				</td>
			</tr>
			<tr>
				<td>
				${detailVO.reg_date }
				</td>
			</tr>
			<tr>
				<td>
				${detailVO.b_contents }
			    </td>
	    	</tr>
	    	
	    	<tr>
	    	  <td>
	    		<c:set var="fileNm" value="${detailVO.file_path.substring(detailVO.file_path.lastIndexOf('/')+1, detailVO.file_path.length())  }"/>
	    		<a href="./boardFileDown?fileName=${fileNm }">
<%-- 	    		${detailVO.file_path.substring(lastIndexOf('/')+1, detailVO.file_path.length())  } --%>
	    			${fileNm }
	    		</a>
	    		<td>
	    	</tr>
		</table>

</body>
</html>