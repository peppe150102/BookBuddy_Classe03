<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <% session.setAttribute("pagina", "Libreria" ); %>
            <%@page import="model.Studenti" %>

                <jsp:include page="../components/navbar.jsp" />
                <jsp:include page="../components/userbar.jsp" />
                <html>

                <head>
                    <title>Book Buddy | Libreria</title>
                    <link rel="stylesheet" href="../style.css">
                    <script src="https://cdn.tailwindcss.com"></script>
                </head>

                <body class="main-bg flex flex-row gap-3">
                    <!--Se l'utente è loggato allora mostra tutti i libri che
                    sono associati alla sua libreria personale, altrimenti 
                    mostra una schermata che invita l'utente a fare il login/registrazione  -->
                </body>

                </html>