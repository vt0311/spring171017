<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>board list</title>
</head>
<body>

<h1>
	Home Page Main 
</h1>

<jsp:include page="./menu.jsp"></jsp:include>

  <c:set var="fblistArr" value="${fblistArr}" />
  
  <!--  <table border="1" width="100%">
		<tr>
		 <td>ȸ��Ұ�</td>
		 <td>��ǰ�ȳ�</td>
		 <td><a href="./boardList">�����Խ���</a></td>
		 <td><a href="./fileuptest">���� ���ε�</a></td>
		</tr>
	</table> -->
	
	<br>
	
	<p>
		<form action="./boardWriteForm">
			<input type="submit" value="�۾���">
		</form>
	</p>
	
	<br>
	
   <table border="1" >
    <c:forEach var="vo" items="${fblistArr}" varStatus="status">
		<tr>
			<td><c:out value="${vo.b_no}"/></td>
			<td><a href="./boardDetail?b_no=${vo.b_no }"><c:out value='${vo.b_title}'/></a></td>
			<td><c:out value='${vo.b_writer}'/></td>
			<td><c:out value='${vo.reg_date}'/></td>
		</tr>
	 </c:forEach>
	</table>
</body>
</html>