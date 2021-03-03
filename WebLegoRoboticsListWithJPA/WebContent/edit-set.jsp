<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Set</title>
</head>
<body>
<form action="editSetServlet" method="post">
Store: <input type="text" name="set" value="${setToEdit.name}">
Year: <input type="text" name="year" value="${setToEdit.year}">
<input type="hidden" name="id" value="${setToEdit.id}">
<input type="submit" value="Save Edited Item">
</form>
</body>
</html>