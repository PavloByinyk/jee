<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html; UTF-8" language="java" pageEncoding="UTF-8" session="false" %>

<html>
<head>
	<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet"/>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


<form:form method="POST" modelAttribute="user" action="check-user" class="box login">

	<fieldset class="boxBody">
	  <form:label path="name"><spring:message code="username"/>:</form:label>
	  <form:input path="name" placeholder="name"/>
	  <form:errors path="name" cssClass="error"/>
	  
	  <form:label path="password"><spring:message code="password"/>:</form:label>
	  <form:input path="password" placeholder="password"/>
	  <form:errors path="password" cssClass="error"/>
	 </fieldset>
	 
	 
	 
	 <footer>
	 <form:checkbox path="admin"/> <form:label path="admin">Admin</form:label>
	  
	  <input type="submit" class="btnLogin" value="Login" tabindex="4">
	</footer>

</form:form>





<footer id="main">
  <a href="http://wwww.cssjunction.com">Simple Login Form (HTML5/CSS3 Coded) by CSS Junction</a> | <a href="http://www.premiumpixels.com">PSD by Premium Pixels</a>
</footer>
</body>
</html>
