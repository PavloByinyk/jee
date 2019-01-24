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

    <!-- Navigation -->
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
            </div>
        </div>
    </nav>



    <div class="content">

        <c:if test="${not empty message}">
            <div class="row">
                <div class="alert-danger">${message}</div>
            </div>
        </c:if>
        <c:if test="${not empty logout}">
            <div class="row">
                <div class="alert-success">${logout}</div>
            </div>
        </c:if>
        
        <div class="panel-body">
            <form action="${contextRoot}/login" method="POST" class="form-horizontal"
                  id="loginForm"
            >
                <div class="form-group">
                    <label for="username" class="col-md-4 control-label">Email: </label>
                    <div class="col-md-8">
                        <input type="text" name="username" id="username" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-md-4 control-label">Password: </label>
                    <div class="col-md-8">
                        <input type="password" name="password" id="password" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                        <input type="submit" value="Login" class="btn btn-primary"/>
                    </div>
                </div>
            </form>

        </div>

    </div>
    <!-- Footer -->
    <%@include file="./shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>
    <script src="${js}/jquery.dataTables.js"></script>
    <script src="${js}/dataTables.bootstrap.js"></script>
    <script src="${js}/myappp.js"></script>
    <script src="${js}/bootbox.min.js"></script>
    <script src="${js}/jquery.validate.js"></script>
</div>
</body>

</html>