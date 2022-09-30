<%-- 
    Document   : getMovieFromREST
    Created on : Jul 29, 2022, 11:08:16 PM
    Author     : Danai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Client</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body bgcolor ='D8BFD8'>
        <div class="frem">
            <p>Test Movie Client</p>
            <form action="ShowMovieFromREST">
                <input type="text" name="movieName"><br/>
                <br/>
                <h1 align="center"><input type="submit" value="Get Movies From REST"></h1><br/>
            </form>
        </div>
    </body>
</html>
