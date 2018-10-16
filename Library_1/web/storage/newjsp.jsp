<%-- 
    Document   : newjsp
    Created on : 13.10.2018, 15:39:00
    Author     : Gottgried
--%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Document   : newjsp
    Created on : Sep 26, 2018, 2:57:30 PM
    Author     : pbyin
--%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="
             position: relative;
             background-color: #ddd;
             width: 100%;
             height: 100%;
             display: table;
             padding-top: 50px">
            
            <div style="
                 position: relative;
                 background-color: #bbb;
                 width: 60%;
                 height: 600px;
                 margin: 0 auto;">
            
                <div style="
                    background-color: aliceblue;
                    text-align: center;
                    position: relative;
                    padding: 20px">
                TODO write content
                </div>
                    <div style="
                         position:relative;
                         padding: 15px;">
                        <form>
                                <input style="position: relative;
                                       width: 85%" type="search" name="search">
                            
                                <div style="
                                     position: relative;
                                     width: 15%;
                                     float: right">
                                    <input style="padding-right: 5px" type="submit" value="Search">
                                    <select   id="select_data">
                                        <option value="">Author name</option>
                                        <option value="1">Value 1</option>
                                        <option value="2">Value 2</option>
                                    </select>
                                </div>
                        </form>
                    </div>
                
                    <div style="
                         width: 75%;
                         display:inline-block;
                         
                         position: relative;
                         float: right;">
                        <h2 style="text-align: center">Books List</h2>
                  
                        
                        <div style="
                             overflow:auto;
                             height: 400px">
                        <%
                            for(int i = 0; i<10; i++){
                        %>
                               
                            <div style="
                                 position: relative;
                                 width: 33%;
                                 height: 300px;
                                 display:inline-block;
                                 text-align: center">
                            <h3> Index is <%=i%>  </h3>
                            </div>
                            
                            <%}%>
                        
                        </div>
                    </div>

                
                    <div style="
                         width: 25%;
                         height: 600px;
                         display:inline-block;
                         background-color: activeborder">
                        <h2 style="text-align: center">Authors List</h2>
                        <div style="
                            position: relative;
                             display: table;">
                            <ul style="list-style-type:none;">
                                <li  style="margin: 10px 0"> <a href="#">Something1</a></li>
                                <li style="margin: 10px 0"><a href="#">Something2</a></li>
                                <li style="margin: 10px 0"><a href="#">Something3</a></li>
                                <li style="margin: 10px 0"><a href="#">Something4</a></li>
                                <li ><a href="#">Something4</a></li>
                                <li style="margin: 10px 0"><a href="#">Something4</a></li>
                                <li style="margin: 10px 0"><a href="#">Something4</a></li>
                            </ul>
                        </div>
                    </div>
                
  
            </div>    
        
        </div>
    </body>
</html>
