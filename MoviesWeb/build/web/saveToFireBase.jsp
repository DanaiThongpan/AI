<%-- 
    Document   : saveToFireBase
    Created on : Jul 24, 2022, 1:51:30 PM
    Author     : Danai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Movie" %>

<% Movie movie = (Movie) session.getAttribute("movie");%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>save_movie_to_firebase</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body bgcolor ='D8BFD8'>
        <script src="https://www.gstatic.com/firebasejs/8.0.0/firebase-app.js"></script>
        <script src="https://www.gstatic.com/firebasejs/8.0.0/firebase-auth.js"></script>
        <script src="https://www.gstatic.com/firebasejs/8.0.0/firebase-database.js"></script>
        <script defer src="https://www.gstatic.com/firebasejs/8.10.1/firebase-firestore.js"></script>
        <div class="frem">
            <p>Firebase Movie connection</p>
            <h3>ชื่อเรื่อง : <input type="text" id="movieName" value="<%= movie.getMovieName()%>" ></h3>
            <h3>ประเภทหนัง : <input type="text" id="movieType" value="<%= movie.getMovieType()%>" ></h3>
            <h3>ช่วงเวลาที่ชอบดู : <input type="text" id="movieTime" value="<%= movie.getMovieTime()%>" ></h3>
            <h3>ระดับความชอบ : <input type="text" id="movieLevel" value="<%= movie.getMovieLevel()%>" ></h3>
            <h3>ราคาตั๋วหนัง : <input type="text" id="moviePrice" value="<%= movie.getMoviePrice()%>" ></h3>
            <br/>
            <button id="send">save_movie</button>
            <br>
            <br>
            <h1 align="center"><a href="index.html">Home</a></h1><br/>
        </div>
        <script type="module">
            const firebaseConfig = {
                apiKey: "AIzaSyCwQxg2qWcouQXwA0kOTncA5fGgAlt3Du8",
                authDomain: "projectmovie-26e85.firebaseapp.com",
                databaseURL: "https://projectmovie-26e85-default-rtdb.firebaseio.com",
                projectId: "projectmovie-26e85",
                storageBucket: "projectmovie-26e85.appspot.com",
                messagingSenderId: "497614587224",
                appId: "1:497614587224:web:00ffec2347c2d0bc8c512d"
            };
            firebase.initializeApp(firebaseConfig);
            var firebaseRef = firebase.database().ref('movie/');

            document.querySelector('#send').addEventListener('click', () => {
                const uid = firebase.database().ref().child('movie').push().key;
                const data = {
                    movie_id: uid,
                    movie_name: '<%= movie.getMovieName()%>',
                    movie_type: '<%= movie.getMovieType()%>',
                    movie_time: '<%=movie.getMovieTime()%>',
                    movie_level: '<%=movie.getMovieLevel()%>',
                    movie_price: '<%=movie.getMoviePrice()%>'
                };

                const updates = {};
                updates['/movie/' + uid] = data;
                firebase.database().ref().update(updates);

                
                alert('Movie is created successfully!');
                reload_page();
            });
            function reload_page() {
                window.location.reload();
            }
        </script>
    </body>
</html>
