<%-- 
    Document   : addNewMovie
    Created on : Jul 20, 2022, 3:04:26 PM
    Author     : Danai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>addNewMovie.jsp</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css"/>
    </head>
    <body bgcolor ='D8BFD8'>
        <div class="frem">
            <p>ใส่ข้อมูล</p>    
            <form action="AddNewMovies">
                ชื่อเรื่อง: <input type="text" name="movieName"><br/>
                ประเภทหนัง: <select name="movieType" id="movieType">
                    <option value="...">...</option>
                    <option value="Action movie">Action movie</option>
                    <option value="Adventure movie">Adventure movie</option>
                    <option value="War movie">War movie</option>
                    <option value="Drama movie">Drama movie</option>
                    <option value="Family movie">Family movie</option>
                </select><br/>
                ช่วงเวลาที่ชอบดู:
                <input type="checkbox"  name="movieTime" value="ยามว่าง">ยามว่าง
                <input type="checkbox"  name="movieTime" value="ตอนทำการบ้าน">ตอนทำการบ้าน
                <input type="checkbox"  name="movieTime" value="ก่อนนอน">ก่อนนอน<br/>
                ระดับความชอบ:
                <input type="radio"  name="movieLevel" value="ชอบมาก">ชอบมาก
                <input type="radio"  name="movieLevel" value="ชอบ">ชอบ
                <input type="radio"  name="movieLevel" value="ไม่ชอบ">ไม่ชอบ<br/>
                ราคาตั๋วหนัง:
                <input type="text" name="moviePrice" ><br/>
                <h1 align="center"><input type="submit" value="submit"></h1>
                <br/>
                <h1 align="center"><a href="index.html">Home</a></h1><br/>
            </form>
        </div>
    </body>
</html>
