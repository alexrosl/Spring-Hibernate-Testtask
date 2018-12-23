<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout title="Ничего не найдено">


<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div>
                <h1>
                    Oops!</h1>
                <h2>
                    Ничего не найдено по Вашему запросу
                </h2>
                <div>
                    <a href="/list" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        Вернуться к списку</a>
                </div>
            </div>
        </div>
    </div>
</div>
</t:layout>