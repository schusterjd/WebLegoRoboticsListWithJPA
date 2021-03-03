<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lego Robotics Set List</title>
</head>
<body>
<form method="post" action="navigationServlet">
<table>
<c:forEach items="${requestScope.allSets}" var="currentset">
<tr>
	<td><input type="radio" name="id" value="${currentset.id}"></td>
	<td>${currentset.name}</td>
	<td>${currentset.year}</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToSet">
<input type="submit" value="delete" name="doThisToSet">
<input type="submit" value="add" name="doThisToSet">
</form>
<a href="index.html">Insert a new set</a>
</body>
</html>