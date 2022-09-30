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
        <link rel="stylesheet" href="style.css" type="text/css"/>
    </head>
    <body bgcolor ='D8BFD8'>
        <div class="frem">
            <p>แก้ไขข้อมูล</p>
            <%
                Movie movie = (Movie) session.getAttribute("movie");
            %>
            <form action="AddNewMovies">
                ชื่อเรื่อง : <input type='text' name='movieName' value= "<%= movie.getMovieName()%>"><br/>
                ประเภทหนังที่ชอบ : <input type='text' name='movieType' value= "<%=movie.getMovieType()%>"><br/>
                ช่วงเวลาที่ชอบดู : <input type='text' name='movieTime' value= "<%=movie.getMovieTime()%>"><br>
                ระดับความชอบ : <input type='text' name='movieLevel' value= "<%=movie.getMovieLevel()%>"><br>
                ราคาตั๋วหนัง : <input type='text' name='moviePrice' value= "<%=movie.getMoviePrice()%>"><br>
                <h1 align="center"><input type="submit" value="แก้ไข"></h1>
                <br>
                <h1 align="center"><a href="index.html">Home</a></h1><br/>
            </form>
            <% session.removeAttribute("movie");%>
        </div>
    </body>
</html>
