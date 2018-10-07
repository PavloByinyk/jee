<%-- 
    Document   : main
    Created on : 23.12.2017, 18:46:43
    Author     : Gottgried
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%request.setCharacterEncoding("UTF-8");%>
        <h1>Hello World!</h1>
        <%="Hello"%> 
        <p>
        <h3>
            <%=request.getParameter("username")%>
        </h3>    
        </p>
    </body>
</html>
