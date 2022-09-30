<%-- 
    Document   : addNewMovie
    Created on : Jul 10, 2022, 11:39:08 AM
    Author     : Danai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Movie" %>
<!DOCTYPE html>
<html>
    <head>
        <title>addNewMovie.JSP</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
    </head>
    <body bgcolor ='D8BFD8'>
        <div class="frem">
            <p>เพิ่มข้อมูลสำเร็จ</p>
            <%
                Movie movie = (Movie) session.getAttribute("movie");
            %>
            ชื่อเรื่อง : <%= movie.getMovieName()%><br/>
            ประเภทหนัง : <%=movie.getMovieType()%><br/>
            ช่วงเวลาที่ชอบดู : <%=movie.getMovieTime()%><br/>
            ระดับความชอบ : <%=movie.getMovieLevel()%><br/>
            ราคาตั๋วหนัง : <%=movie.getMoviePrice()%><br>
            <br/>
            <a href="upDateMovie.jsp">แก้ไข</a>
            <br>
            <a href="saveToFireBase.jsp">saveToFireBase.jsp</a>
            <br>
            <h1 align="center"><a href="index.html">Home</a></h1><br/>
        </div>
    </body>
</html>
