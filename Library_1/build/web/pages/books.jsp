<%-- 
    Document   : books
    Created on : 09.09.2018, 21:16:09
    Author     : Gottgried
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="pojo.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../WEB-INF/jspf/left_menu.jspf" %>

<%request.setCharacterEncoding("UTF-8");

    int genreId= 0;
    
    genreId = Integer.valueOf(request.getParameter("genre_id"));
%>

<jsp:useBean id="booksList" class="data.BookList" scope="page"/>

<div>
    <h3>${param.name}</h3>
    
    <% 
        ArrayList bookList = booksList.getBooksByGenre(genreId);
        session.setAttribute("currentBookList", bookList);
        for(Book book : booksList.getBooksByGenre(genreId)){
    %>
    <div>
    <p> <%= book.getName()%>  </p>
    <img src="<%=request.getContextPath()%>/ImageLoader?index=<%=bookList.indexOf(book)%>" width="190" height="250"/>
    </div>
    <%}%>
    
    
</div>