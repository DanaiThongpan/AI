<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id ="id01"></div>
        <script type="text/javascript">
            var client = new XMLHttpRequest();
            client.open("GET", "http://localhost:8080/MoviesWeb/GetMovieService/Seobok", true);
            client.onreadystatechange = function () {
                if (client.readyState == 4) {
                    //alert(client.responseText);
                    document.write(client.responseText);
                };
            };
            client.send();
        </script>
    </body>
</html>
