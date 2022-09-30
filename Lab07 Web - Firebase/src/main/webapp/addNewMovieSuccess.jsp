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
            ระดับความชอบ : <%=movie.getMovie1()%><br/>
            ราคาตั๋วหนัง : <%=movie.getMoviePrice()%><br>
            <br/>
            <a href="upDateMovie.jsp">แก้ไข</a>
        </div>
    </body>
</html>
