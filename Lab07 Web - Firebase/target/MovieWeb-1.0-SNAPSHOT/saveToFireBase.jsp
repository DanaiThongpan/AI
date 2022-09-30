<%-- 
    Document   : saveToFireBase
    Created on : Jul 24, 2022, 1:51:30 PM
    Author     : Danai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Movie" %>

<!-- get session object movie -->

<!DOCTYPE html>
<html>
    <head>
        <script src='https://cdn.firebase.com/js/client/2.2.1/firebase.js'></script>
        <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js'></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script  type="module">
            import { initializeApp } from "https://www.gstatic.com/firebasejs/9.9.1/firebase-app.js"
                    // Your web app's Firebase configuration
            const firebaseConfig = {
                apiKey: "Key...",
                authDomain: "Key...",
                databaseURL: "Key...",
                projectId: "Key...",
                storageBucket: "Key...",
                messagingSenderId: "Key...",
                appId: "Key..."
            };
            // Initialize Firebase
            const app = initializeApp(firebaseConfig);
        </script>        
    </head>
    <body>
        <h2>Test Firebase 'Movie' connection</h2>
        <p>
            <input type="button" value="Save" onclick="save_movie();" />
        </p>
        <script>
            //const ref = new firebase("https://movie-ba849-default-rtdb.firebaseio.com");
            const databaseRef = firebase.database().ref('movie/');

            function save_movie() {
                const uid = firebase.database().ref().child('movie').push().key;

                const data = {
                    movie_id: uid,
                    movie_name: 'บางระจัน',
                    movie_type: 'Action'
                };

                const updates = {};
                updates['/movie/' + uid] = data;
                firebase.database().ref().update(updates);

                alert('Movie is created successfully!');
                reload_page();
            }

            function reload_page() {
                window.location.reload();
            }

        </script>
    </body>
</html>
