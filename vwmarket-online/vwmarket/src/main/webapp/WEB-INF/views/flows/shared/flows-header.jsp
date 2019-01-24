<%--
  Created by IntelliJ IDEA.
  User: pbyin
  Date: 27.12.2018
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/assets/css"/>
<spring:url var="js" value="/assets/js"/>
<spring:url var="images" value="/assets/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>vmmarket - ${title}</title>

    <!-- Bootstrap core CSS -->
    <%--<link href="<c:url value="/assets/css/bootstrap.min.css"/>" rel="stylesheet">--%>
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Readable Theme -->
    <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">
    <%--<link href="<c:url value="/assets/css/myapp.css"/>" rel="stylesheet">--%>
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <script>
        window.menu = '${title}';
        window.contextRoot = '${contextRoot}'
    </script>

</head>

<body>

<div class="wrapper">

    <%--&lt;%&ndash;Navigation&ndash;%&gt;--%>
    <%--<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">--%>
        <%--<div class="container">--%>
            <%--<div class="navbar-header">--%>
                <%--<a class="navbar-brand" href="${flowExecutionUrl}&_eventId_home">Home</a>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</nav>--%>

        <jsp:include page="flows-navbar.jsp"/>
        <div class="content">

