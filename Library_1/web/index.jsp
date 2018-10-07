<%-- 
    Document   : index
    Created on : 23.12.2017, 18:06:36
    Author     : Gottgried
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/styles.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    
    <body>
        <form name="username" action="pages/mainboard.jsp" method="POST"> 
            
            <div style="width: 1200px; height: 800px; margin:0 auto;">
                <div><p>Welcome to the hell</p></div>
                <div >
                <div style="width:50%;background:red; padding-top: 10px; float:left; text-align: right"  >Good luck</div>
                <div style="width:50%;background:blue;padding-top: 10px; float:left; text-align: left"  >Joiking</div>
                </div>
                
                
                <div class="class1" style="padding: 20px">Put your name here 
                    <div style="float: left">
                        <input class="class1" type="text" name="username" value="" size="20"/>
                    </div>
                </div>
                
                <div style="clear: both" text-a><input class="class1" type="submit" value="Sign in"/></div>
            </div>
        </form>
        
    </body>

</html>