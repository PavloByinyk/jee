
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>--%>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<%--<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>--%>

<%--<html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>
    <%--<meta http-equiv="content-type" content="text/html" charset="utf-8">--%>
<%--</head>--%>
<%--<body>--%>
    <%--<h2>Create your Idea</h2>--%>

    <%--<form:form id="formCreate" modelAttribute="idea" method="post" action="submitUpdate">--%>
        <%--Id--%>
        <%--<form:input path="id" />--%>
        <%--Caption--%>
        <%--<form:input path="capture" />--%>
        <%--Content--%>
        <%--<form:textarea path="content"/>--%>
        <%--<form:button value="submit">Save</form:button>--%>
        <%----%>
    <%--</form:form>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:layout title="Редактирование идеи">
    <h1 class="text-center text-uppercase">Edit</h1>
    <div class="jumbotron">
        <form:form id="formCreate" modelAttribute="idea" method="post" action="submitUpdate">
            <div class="form-group">
                <label for="captionId">Name</label>
                <form:input path="capture" id="captionId" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label for="contentId">Description</label>
                <form:textarea path="content" id="contentId" cssClass="form-control"/>
            </div>
            <form:hidden path="id"/>
            <button type="submit" class="btn btn-success">Обновить</button>
            <a href="list" class="danger-link">Отмена</a>
        </form:form>

    </div>
</t:layout>
