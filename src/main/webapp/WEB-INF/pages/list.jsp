<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout title="Список деталей">
    <div class="container-fluid">
            <table class="table table-hover text-centered">
                <tr>
                        <%--<th>Id</th>--%>
                    <th>Наименование</th>
                    <th>Количество</th>
                    <th>Необходимость</th>
                        <%--<th>Created</th>--%>
                    <th>Действия</th>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                            <%--<td>${item.id}</td>--%>
                        <td>${item.name}</td>
                        <td>${item.quantity}</td>
                        <td><input type="checkbox" <c:if test="${item.required}">checked</c:if> disabled></td>
                            <%--<td><c:out value="${item.created}"/></td>--%>
                        <td>
                            <span><a href="update?id=${item.id}">Редактировать</a></span>
                            <span><a href="delete?id=${item.id}">Удалить</a></span>

                        </td>
                    </tr>
                </c:forEach>
            </table>
    </div>


</t:layout>