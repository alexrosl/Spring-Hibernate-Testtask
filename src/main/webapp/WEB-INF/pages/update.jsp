<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout title="Обновить">
    <div class="jumbotron">
        <form:form id="forUpdate" modelAttribute="part" method="post" action="submitUpdate">
            <div class="form-group">
                <label for="nameId">Название</label>
                <form:input id="nameId" required="true" placeholder="Название детали" path="name" />
            </div>
            <div class="form-group">
                <label for="quantityId">Количество</label>
                <form:input id="quantityId" type="number" min="0" max="99" value="${part.quantity}" path="quantity"/>
            </div>
            <div class="form-group">
                <label for="requiredId">Необходимость</label>
                <form:checkbox id="requiredId" path="required"/>
            </div>
            <form:hidden path="id"/>
            <button type="submit" class="btn btn-success">Сохранить</button>
            <button class="btn btn-info"><a href="list">Отмена</a></button>
            <button class="btn btn-danger"><a href="delete?id=${part.id}">Удалить</a></button>
        </form:form>

    </div>
</t:layout>