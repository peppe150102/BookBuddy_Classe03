<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="model.Studenti" %>
        <%@ page import="com.oracle.wls.shaded.org.apache.xml.utils.SystemIDResolver" %>
            <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
                <jsp:include page="components/userbar.jsp" />

                <% session.setAttribute("pagina", "Home" ); %>
                    <jsp:include page="components/navbar.jsp" />
                    <!DOCTYPE html>
                    <html>

                    <head>
                        <meta charset="UTF-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title> Book Buddy | Home </title>
                        <link rel="stylesheet" href="style.css">
                        <script src="https://cdn.tailwindcss.com"></script>
                    </head>

                    <body class="main-bg flex flex-row gap-3">
                        <div class="home flex flex-col items-center content-evenly p-8 gap-16">
                            <div class="search-zone">
                                <img class="search-icon" src="imgs/172546_search_icon.svg" alt="">
                                <input class="search-bar rounded-sm" placeholder="Search your favourite book"
                                    type="search" name="" id="">
                            </div>
                            <% if(session.getAttribute("studente") !=null || session.getAttribute("admin") !=null) { %>
                                <div class="banner relative rounded-lg text-white p-4">
                                    <% if(session.getAttribute("admin")!=null) {%>
                                        <h4 class="m-2">Ciao ${admin.nome_utente}!</h4>
                                        <%}else if(session.getAttribute("studente")!=null){%>
                                            <h4 class="m-2">Ciao ${studente.nome_utente}!</h4>
                                            <%}%>
                                                <p class="m-2 mb-4 mt-5">Bentornato!<br>Sei pronto a studiare? </p>
                                                <a class="rounded-full banner-button m-2 ml-4 px-5 py-2 text-sm"
                                                    href="${pageContext.request.contextPath}/results/browse.jsp">Esplora
                                                    materiale</a>
                                </div>
                                <h2 class="reco self-start">Recommended For You</h2>
                                <div class="single-recommendation flex flex-row gap-6">
                                    <img src="imgs/book-covers-big-2019101610.jpg" alt="" class="book-img w-28">
                                    <div class="book-info">
                                        <h5 class="text-cyan-600">Titolo libro</h5>
                                        <p class="text-white">by Autore | Data pubblicazione</p>
                                        <p class="text-gray-400">Lorem, ipsum dolor sit amet consectetur adipisicing
                                            elit. <br>
                                            Suscipit,
                                            temporibus reprehenderit
                                            dicta porro accusantium est! <br> Autem aliquam doloremque, nemo architecto
                                            hic nulla
                                            eligendi
                                            magni, <br> facere dolorem nostrum ipsa amet ullam!</p>
                                    </div>
                                </div>
                                <% } %>
                                    <% if(session.getAttribute("studente")==null && session.getAttribute("admin")==null)
                                        { %>
                                        <div class="banner relative rounded-lg text-white p-4">
                                            <h4 class="m-2">Benvenuto!</h4>
                                            <p class="m-2 mb-4 mt-5">Per poter accedere a tutti i servizi <br> ti
                                                consigliamo di fare il login</p>
                                            <a class="rounded-full banner-button m-2 ml-4 px-5 py-2 text-sm"
                                                href="${pageContext.request.contextPath}/results/browse.jsp">Sfoglia
                                                materiale</a>
                                        </div>
                                        <% } %>
                        </div>
                    </body>

                    </html>