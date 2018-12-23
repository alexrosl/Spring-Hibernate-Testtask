<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout title="Добавить новую деталь">
    <div class="jumbotron">
        <form:form id="formPost" modelAttribute="newPart" method="post" action="submitNew">
            <div class="form-group">
                <label for="nameId">Название</label>
                <form:input id="nameId" required="true" placeholder="Название детали" path="name" />
            </div>
            <div class="form-group">
                <label for="quantityId">Количество</label>
                <form:input id="quantityId" type="number" min="0" max="99" value="1" path="quantity"/>
            </div>
            <div class="form-group">
                <label for="requiredId">Необходимость</label>
                <form:checkbox id="requiredId" path="required"/>
            </div>
            <button type="submit" class="btn btn-success">Сохранить</button>
        </form:form>
    </div>

</t:layout>