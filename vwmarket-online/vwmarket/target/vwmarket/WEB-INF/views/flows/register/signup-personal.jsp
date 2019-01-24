<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: pbyin--%>
  <%--Date: 27.12.2018--%>
  <%--Time: 10:09--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>

<%--<spring:url var="css" value="/assets/css"/>--%>
<%--<spring:url var="js" value="/assets/js"/>--%>
<%--<spring:url var="images" value="/assets/images"/>--%>

<%--<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>--%>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>

<%--<head>--%>

    <%--<meta charset="utf-8">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>

    <%--<title>vmmarket - ${title}</title>--%>

    <%--<!-- Bootstrap core CSS -->--%>
    <%--&lt;%&ndash;<link href="<c:url value="/assets/css/bootstrap.min.css"/>" rel="stylesheet">&ndash;%&gt;--%>
    <%--<link href="${css}/bootstrap.min.css" rel="stylesheet">--%>

    <%--<!-- Bootstrap Readable Theme -->--%>
    <%--<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">--%>

    <%--<!-- Custom styles for this template -->--%>
    <%--<link href="${css}/myapp.css" rel="stylesheet">--%>
    <%--&lt;%&ndash;<link href="<c:url value="/assets/css/myapp.css"/>" rel="stylesheet">&ndash;%&gt;--%>
    <%--<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">--%>

    <%--<script>--%>
        <%--window.menu = '${title}';--%>
        <%--window.contextRoot = '${contextRoot}'--%>
    <%--</script>--%>

<%--</head>--%>

<%--<body>--%>

<%--<div class="wrapper">--%>

    <%--&lt;%&ndash;Navigation&ndash;%&gt;--%>
    <%--<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">--%>
        <%--<div class="container">--%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../shared/flows-header.jsp"/>
            <%--<div class="navbar-header">--%>
                <%--<a class="navbar-brand" href="${flowExecutionUrl}&_eventId_home">Home</a>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</nav>--%>

    <%--<div class="content">--%>
<div class="container">


    <div class="row">

        <div class="col-md-6 col-md-offset-3">

            <div class="panel panel-primary">

                <div class="panel-heading">
                    <h4>Sign Up - Personal</h4>
                </div>

                <div class="panel-body">

                    <sf:form
                            method="POST"
                            modelAttribute="user"
                            class="form-horizontal"
                            id="registerForm"
                    >


                        <div class="form-group">
                            <label class="control-label col-md-4">First Name</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="firstName" class="form-control"
                                          placeholder="First Name" />
                                <sf:errors path="firstName" cssClass="help-block" element="em"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="control-label col-md-4">Last Name</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="lastName" class="form-control"
                                          placeholder="Last Name" />
                                <sf:errors path="lastName" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Email</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="email" class="form-control"
                                          placeholder="abc@zyx.com" />
                                <sf:errors path="email" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Contact Number</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="contactNumber" class="form-control"
                                          placeholder="XXXXXXXXXX" maxlength="10" />
                                <sf:errors path="contactNumber" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Password</label>
                            <div class="col-md-8">
                                <sf:input type="password" path="password" class="form-control"
                                          placeholder="Password" />
                                <sf:errors path="password" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Confirm Password</label>
                            <div class="col-md-8">
                                <sf:input type="password" path="confirmPassword" class="form-control"
                                          placeholder="Re-type password" />
                                <sf:errors path="confirmPassword" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4">Select Role</label>
                            <div class="col-md-8">
                                <label class="radio-inline">
                                    <sf:radiobutton path="role" value="USER" checked="checked"/> User
                                </label>
                                <label class="radio-inline">
                                    <sf:radiobutton path="role" value="SUPPLIER"/> Supplier
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" name="_eventId_billing" class="btn btn-primary">
                                    Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
                                </button>
                            </div>
                        </div>


                    </sf:form>


                </div>


            </div>


        </div>


    </div>


</div>
<jsp:include page="../shared/flows-footer.jsp"/>
    <%--</div>--%>
    <%--<!-- Footer -->--%>
    <%--<%@include file="../../shared/footer.jsp" %>--%>

    <%--<!-- Bootstrap core JavaScript -->--%>
    <%--<script src="${js}/jquery.js"></script>--%>
    <%--<script src="${js}/bootstrap.bundle.min.js"></script>--%>
    <%--<script src="${js}/jquery.dataTables.js"></script>--%>
    <%--<script src="${js}/dataTables.bootstrap.js"></script>--%>
    <%--<script src="${js}/myappp.js"></script>--%>
    <%--<script src="${js}/bootbox.min.js"></script>--%>
    <%--<script src="${js}/jquery.validate.js"></script>--%>
<%--</div>--%>
<%--</body>--%>

<%--</html>--%>

