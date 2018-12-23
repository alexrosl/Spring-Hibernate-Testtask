<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout title="Обновить">
<form:form id="forUpdate" modelAttribute="part" method="post" action="submitUpdate">
    Название
    <form:input required="true" placeholder="Название детали" path="name" />
    Количество
    <form:input type="number" min="1" max="99" value="${part.quantity}" path="quantity"/>
    Необходимость
    <form:checkbox path="required"/>
    <form:hidden path="id"/>
    <button type="submit">Сохранить</button>
</form:form>
<span><a href="list">Отмена</a></span>
<span><a href="delete?id=${newPart.id}">Удалить</a></span>
</t:layout>