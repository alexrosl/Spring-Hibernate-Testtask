<%@ tag pageEncoding="UTF-8" description="base layout" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="title" type="java.lang.String" required="true" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"/>
    <title><c:out value="${title}"/> </title>
    <style type="text/css">
        a:hover{
            text-decoration: none;
        }
        .table {
            border-radius: 5px;
            width: 100%;
            margin: 0px auto;
            float: none;
        }
        .summary {
            text-align: center;
            color: blue;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/"><span class="glyphicon glyphicon-home"></span> Главная страница </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/list">Список деталей </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/create">Добавить новую деталь </a>
            </li>
        </ul>
        <form action="/search" method="get" class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="name">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<div class="container">
    <jsp:doBody/>
</div>

</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.2.1/js/bootstrap.min.js"></script>
</html>
