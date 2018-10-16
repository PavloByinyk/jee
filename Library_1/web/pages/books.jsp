<%-- 
    Document   : books
    Created on : 09.09.2018, 21:16:09
    Author     : Gottgried
--%>

<%@page import="enums.SearchType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojo.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../WEB-INF/jspf/left_menu.jspf" %>

<%request.setCharacterEncoding("UTF-8");

//    int genreId= 0;
//    
//    genreId = Integer.valueOf(request.getParameter("genre_id"));
%>

<jsp:useBean id="booksList" class="data.BookList" scope="page"/>
<jsp:useBean id="lettersList" class="mutils.LetterList" scope="page"/>

                    <div style="
                         width: 75%;
                         display:inline-block;
                         position: relative;
                         float: right;">
                        <h2 style="text-align: center">${param.name}</h2>
                            
                        
                        <div align="center" style="
                             position: relative;
                             width: 100%;">
                            <% for(char c : lettersList.getRussianLetters()){ 
                            %>
                            <a style="align-content: center" href="books.jsp?letter=<%=c%>"><%=c%></a>
                            <%}%>
                        </div>
                        
                        <div style="
                             overflow:auto;
                             height: 400px">
                            
                            <% 
                            ArrayList<Book> bookList = null;
                            if(request.getParameter("genre_id") != null){
                                int genreId = Integer.valueOf(request.getParameter("genre_id"));
                                bookList = booksList.getBooksByGenre(genreId);
                            }else if(request.getParameter("letter") != null){
                                String letter = request.getParameter("letter");
                                bookList = booksList.getBooksByLetter(letter);
                            }else if(request.getParameter("search_string") != null){
                                String searchStr = request.getParameter("search_string");
                                SearchType searchOption = request.getParameter("search_option").equals("Author") ? SearchType.AUTHOR : SearchType.TITLE;
                                bookList = booksList.getBooksBySearch(searchStr, searchOption);
                            }

                            session.setAttribute("currentBookList", bookList);
                            for(Book book : bookList){
                            %>
                            <div style="
                                 position: relative;
                                 width: 33%;
                                 height: 300px;
                                 display:inline-block;
                                 text-align: center">
                                <div style="
                                 position: relative">
                                    <p> <%= book.getName()%>  </p>
                                    <img src="<%=request.getContextPath()%>/ImageLoader?index=<%=bookList.indexOf(book)%>" width="140" height="160"/>
                                    <p style="margin: 10px"> <a href="<%=request.getContextPath()%>/PdfLoader?index=<%=bookList.indexOf(book)%>">Read</a>  </p>
                                </div>
                            </div>
                            <%}%>
                            
                        
                        </div>
                            
                    </div>



