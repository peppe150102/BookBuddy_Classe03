<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Book Buddy | ${pagina}
    </title>
    <link rel="stylesheet" href="../style.css">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<nav class="nav-bar flex-col w-56 nav-font h-screen p-6">
    <h1 class="text-white font-logo my-5 mx-1 text-2xl text-center">Book Buddy</h1>
    <ul class="main-nav flex flex-col justify-center gap-6 py-16">
        <% if(session.getAttribute("pagina").equals("Home")) {%>
        <li class="nav-items active cursor-pointer">
            <a href="${pageContext.request.contextPath}/index.jsp" class="active">
                <img class="img-nav inline-block w-6 icon-fill active"
                     src="${pageContext.request.contextPath}/imgs/392500_estate_home_house_real_icon.svg" alt="">Home</a>
        </li>
        <% }else{ %>
        <li class="nav-items cursor-pointer">
            <a href="${pageContext.request.contextPath}/index.jsp">
                <img class="img-nav inline-block w-6 icon-fill"
                     src="${pageContext.request.contextPath}/imgs/392500_estate_home_house_real_icon.svg" alt="">Home</a>
        <% } %>
        <% if(session.getAttribute("pagina").equals("Esplora")) {%>
        <li class="nav-items cursor-pointer mr-4 ml-[-.3rem]">
            <a href="${pageContext.request.contextPath}/results/browse.jsp" class="active">
                <img class="img-nav inline-block w-8 icon-fill active"
                     src="${pageContext.request.contextPath}/imgs/1530072_globe_location_magnifying glass_navigation_position_icon.svg"
                     alt="">Esplora</a>
        </li>
        <% }else{ %>
        <li class="nav-items cursor-pointer mr-4 ml-[-.3rem]">
            <a href="${pageContext.request.contextPath}/results/browse.jsp">
                <img class="img-nav inline-block w-8 icon-fill"
                     src="${pageContext.request.contextPath}/imgs/1530072_globe_location_magnifying glass_navigation_position_icon.svg"
                     alt="">Esplora</a>
        <% } %>
        <% if(session.getAttribute("pagina").equals("Libreria")) {%>
        <li class="nav-items cursor-pointer">
            <a href="${pageContext.request.contextPath}/results/library.jsp" class="active">
                <img class="img-nav inline-block w-8 -ml-1 icon-fill active"
                     src="${pageContext.request.contextPath}/imgs/7424575_book_library_data_novel_journal_icon.svg" alt="">
                Libreria</a>
        </li>
        <% }else{ %>
        <li class="nav-items cursor-pointer">
            <a href="${pageContext.request.contextPath}/results/library.jsp">
                <img class="img-nav inline-block w-8 -ml-1 icon-fill"
                     src="${pageContext.request.contextPath}/imgs/7424575_book_library_data_novel_journal_icon.svg" alt="">
                Libreria</a>
        <% } %>
        <% if(session.getAttribute("pagina").equals("Preferiti")) {%>
        <li class="nav-items cursor-pointer">
            <a href="${pageContext.request.contextPath}/results/preferiti.jsp" class="active">
                <img class="img-nav inline-block w-6 icon-fill active"
                     src="${pageContext.request.contextPath}/imgs/2849790_bookmark_book_multimedia_tab_media_icon.svg" alt="">
                Preferiti</a>
        </li>
        <% }else{ %>
        <li class="nav-items cursor-pointer">
            <a href="${pageContext.request.contextPath}/results/preferiti.jsp">
                <img class="img-nav inline-block w-6 icon-fill"
                     src="${pageContext.request.contextPath}/imgs/2849790_bookmark_book_multimedia_tab_media_icon.svg" alt="">
                Preferiti</a>
        </li>
        <% } %>
        <% if(session.getAttribute("pagina").equals("Carica")) {%>
        <li class="nav-items cursor-pointer">
            <a href="${pageContext.request.contextPath}/results/carica.jsp" class="active">
                <img class="img-nav inline-block w-6 icon-fill active"
                     src="${pageContext.request.contextPath}/imgs/icons8-borrow-book-50.png" alt="">
                Carica File</a>
        </li>
        <% }else{ %>
        <li class="nav-items cursor-pointer">
            <a href="${pageContext.request.contextPath}/results/carica.jsp">
                <img class="img-nav inline-block w-6 icon-fill"
                     src="${pageContext.request.contextPath}/imgs/icons8-borrow-book-50.png" alt="">
                Carica File</a>
        </li>
        <% } %>
    </ul>
</nav>
</body>
</html>
