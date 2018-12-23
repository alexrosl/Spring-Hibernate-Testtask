<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Добавить новую деталь</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form:form id="formPost" modelAttribute="newPart" method="post" action="submit">
    Название
    <form:input path="name" />
    Количество
    <form:input type="number" min="1" max="99" value="1" path="quantity"/>
    <button type="submit">Сохранить</button>
</form:form>
</body>
</html>
