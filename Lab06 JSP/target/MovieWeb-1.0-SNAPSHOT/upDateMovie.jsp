<%-- 
    Document   : upDateMovie
    Created on : Jul 10, 2022, 11:41:41 AM
    Author     : Danai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Movie" %>
<!DOCTYPE html>
<html>
    <head>
        <title>upDateMovie.JSP</title>
    </head>
    <body>
        <h1>แก้ไขข้อมูล</h1>
        <%
            Movie movie = (Movie) session.getAttribute("movie");
        %>
        <form action="AddNewMovies">
            ชื่อเรื่อง : <input type='text' name='movieName' value= "<%= movie.getMovieName()%>"><br/>
            ประเภทหนังที่ชอบ : <input type='text' name='movieType' value= "<%=movie.getMovieType()%>"><br/>
            ช่วงเวลาที่ชอบดู : <input type='text' name='movieTime' value= "<%=movie.getMovieTime()%>"><br>
            ระดับความชอบ : <input type='text' name='movie1' value= "<%=movie.getMovie1()%>"><br>
            ราคาตั๋วหนัง : <input type='text' name='moviePrice' value= "<%=movie.getMoviePrice()%>"><br>
            <input type="submit" value="แก้ไข">
        </form>
        <% session.removeAttribute("movie"); %>
    </body>
</html>
