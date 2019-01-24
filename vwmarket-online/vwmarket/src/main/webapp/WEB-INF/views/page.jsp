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

    <meta name="_csrf" content="${_csrf.token}">
    <meta name="_csrf_header" content="${_csrf.headerName}">

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
        <%@include file="./shared/navbar.jsp" %>

            <div class="content">
                <%--Load content home page--%>
                <c:if test="${userClickHome == true}">
                    <%@include file="home.jsp" %>
                </c:if>

                <%--Load content about page--%>
                <c:if test="${userClickAbout == true}">
                    <%@include file="about.jsp" %>
                </c:if>

                <%--Load content contact page--%>
                <c:if test="${userClickContact == true}">
                    <%@include file="contact.jsp" %>
                </c:if>

                <%--Load content products list page--%>
                <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
                    <%@include file="listProducts.jsp" %>
                </c:if>

                <%--Load content product single--%>
                <c:if test="${userClickSingleProducts == true}">
                    <%@include file="singleProduct.jsp" %>
                </c:if>

                 <c:if test="${userClickShowCart == true}">
                     <%@include file="cart.jsp" %>
                 </c:if>

                    <%--Load content product single--%>
                    <c:if test="${userClickManageProducts == true}">
                        <%@include file="manageProducts.jsp" %>
                    </c:if>


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

