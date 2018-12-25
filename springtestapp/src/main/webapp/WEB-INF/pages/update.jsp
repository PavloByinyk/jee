
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>

<html>
<head>
    <title>Title</title>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
</head>
<body>
    <h2>Create your Idea</h2>

    <form:form id="formCreate" modelAttribute="idea" method="post" action="submitUpdate">
        Id
        <form:input path="id" />
        Caption
        <form:input path="capture" />
        Content
        <form:textarea path="content"/>
        <form:button value="submit">Save</form:button>
        
    </form:form>
</body>
</html>
