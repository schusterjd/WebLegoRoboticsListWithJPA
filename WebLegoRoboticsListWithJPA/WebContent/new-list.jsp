<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
<form action="createNewListServlet" method="post">
List Name: <input type="text" name="listName"><br />
Set purchase date: <input type="text" name="month" placeholder="mm" size="4">
<input type="text" name="day" placeholder="dd" size="4"> <input type="text" name="year" placeholder="yyyy" size="4">
Owner Name: <input type="text" name="ownerName"><br />

Available Sets:<br />
<select name="allSetsToAdd" multiple size="6">
<c:forEach items="${requestScope.allSets}" var="currentitem">
	<option value="${currentitem.id}">${currentitem.name} | ${currentitem.year}</option>
</c:forEach>
</select>
<br />
<input type="submit" value="Create List and Add Items">
</form>
<a href="index.html">Go add new sets instead.</a>
</body>
</html>