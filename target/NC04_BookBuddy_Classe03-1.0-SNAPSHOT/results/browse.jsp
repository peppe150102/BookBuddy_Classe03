<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <% session.setAttribute("pagina", "Esplora" ); %>
    <%@ page import="model.MaterialeDidattico" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="../components/navbar.jsp" />
        <jsp:include page="../components/userbar.jsp" />
        <jsp:include page="/SfogliaMateriale" />
        <!DOCTYPE html>
        <html lang="en">

        <head>
          <link rel="stylesheet" href="../style.css">
          <script src="https://cdn.tailwindcss.com"></script>
          <meta charset="UTF-8">
          <meta http-equiv="X-UA-Compatible" content="IE=edge">
          <title> Book Buddy | Sfoglia </title>
        </head>

        <body class="main-bg flex flex-row gap-3">
          <!-- Creare un loop per iterare per tutti i materiali didattici e mostrarli
          in una card con pulsanti per aggiungere in libreria, aggiungere in preferiti
          o scaricare il materiale didattico -->
        </body>

        </html>