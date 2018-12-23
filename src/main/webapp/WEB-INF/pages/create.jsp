<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout title="Добавить новую деталь">
<form:form id="formPost" modelAttribute="newPart" method="post" action="submitNew">
    Название
    <form:input required="true" placeholder="Название детали" path="name" />
    Количество
    <form:input type="number" min="1" max="99" value="1" path="quantity"/>
    Необходимость
    <form:checkbox path="required"/>
    <button type="submit">Сохранить</button>
</form:form>
</t:layout>