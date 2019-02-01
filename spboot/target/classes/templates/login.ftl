<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
Login page
<#--<!DOCTYPE html>-->
<#--<html xmlns="http://www.w3.org/1999/xhtml"-->
      <#--xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">-->
<#--<head>-->
    <#--<title>Spring Security Example </title>-->
<#--</head>-->
<#--<body>-->
<#--<form action="/login" method="post">-->
    <#--<div><label> User Name : <input type="text" name="username"/> </label></div>-->
    <#--<div><label> Password: <input type="password" name="password"/> </label></div>-->
    <#--<input type="hidden" name="_csrf" value="{{_csrf.token}}"/>-->
    <#--<div><input type="submit" value="Sign In"/></div>-->
<#--</form>-->
<@l.login "/login" false/>
<#--<a href="/registration">Add new user</a>-->
<#--</body>-->
<#--</html>-->
</@c.page>