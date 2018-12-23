<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout title="Список деталей">
    <c:if test="${!empty list}">
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
            <div class="summary">
                <span>Общее количество компьютеров, которые можно собрать, равно ${total}</span>
            </div>
        </div>
    </c:if>

    <c:if test="${empty list}">
        <header class="text-center">
            <div class="container">
                <h1 class="text-uppercase mb-0">Не найдено ни одной детали</h1>
            </div>
        </header>
    </c:if>

    <div id="pagination">
        <p >Страницы: </p>

        <c:url value="/list" var="previous">
            <c:param name="page" value="${page-1}"/>
        </c:url>
        <c:if test="${page > 1}">
            <a href="<c:out value="${previous}" />">Предыдущая</a>
        </c:if>

        <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
            <c:choose>
                <c:when test="${page == i.index}">
                    <span>${i.index}</span>
                </c:when>
                <c:otherwise>
                    <c:url value="/list" var="url">
                        <c:param name="page" value="${i.index}"/>
                    </c:url>
                    <a href="${url}">${i.index}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:url value="/list" var="next">
            <c:param name="page" value="${page + 1}"/>
        </c:url>
        <c:if test="${page + 1 <= maxPages}">
            <a href='<c:out value="${next}" />' class="pn next">Следующая</a>
        </c:if>
    </div>


</t:layout>