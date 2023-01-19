<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <% session.setAttribute("pagina", "Preferiti" ); %>
            <%@page import="model.Studenti" %>


                <jsp:include page="../components/navbar.jsp" />
                <jsp:include page="../components/userbar.jsp" />

                <html>

                <head>
                    <title>Book Buddy | Preferiti</title>
                    <link rel="stylesheet" href="../style.css">
                    <script src="https://cdn.tailwindcss.com"></script>
                </head>

                <body class="main-bg flex flex-row gap-3">
                    <% Studenti sessioneStudente=(Studenti) session.getAttribute("studente");%>
                <% if(sessioneStudente==null){ %>
                <div class="error-log w-[80ch] h-[22rem] bg-[#272f55] rounded-full p-12
                            text-center relative mt-36 ml-44">
                    <p class="text-white"> <b>Oh no! Sembra che tu non sia loggato.<br>In questo modo non potrai
                        utilizzare tutte le funzionalità </b></p>
                    <img class="user-unknown w-24 absolute left-[18rem] top-44" src="../imgs/user-unknown-1.svg" alt="">
                    <img class="user-unknown w-24 absolute rotate-[30deg] left-[21rem] top-[7rem]" src="../imgs/user-questionmark-2.svg" alt="">
                </div>
                <% } else { %>
                <div class="home flex flex-row items-center content-evenly px-12 py-8 gap-16 text-white flex-wrap">
                    <jsp:include page="/MostraPreferiti" />
                    <c:forEach items="${listaLibri}" var="MaterialeDidattico">
                        <div class="card w-[15rem] h-[23.5rem] relative bg-[#323c66]">
                            <div class="overflow-hidden">
                                <div class="photo h-[18rem] w-[15rem]">
                                    <img class="w-[20rem]" src="${MaterialeDidattico.copertina}" alt="">
                                </div>
                                <div class="card-content absolute bottom-2 left-2">
                                    <div class="content">
                                        <p class="txt4 m-0 text-lg">${MaterialeDidattico.nome}</p>
                                        <p class="txt5 m-0 text-base"><i>by ${MaterialeDidattico.autore}</i></p>
                                    </div>
                                    <div class="footer">
                                        <p class="m-0"><span class="like">${MaterialeDidattico.corso_di_laurea} -
                                                ${MaterialeDidattico.materia}</span></p>
                                    </div>
                                </div>
                            </div>
                                <%--      Pulsanti della card per studente loggato e non          --%>
                            <div class="card-button flex flex-col absolute bottom-0 right-0">
                                <% if(session.getAttribute("studente")!=null){%>
                                <a href="${pageContext.request.contextPath}/RimuoviDaLibreria?id=${MaterialeDidattico.id}"
                                   class="p-2 bg-[#4c5a9a] hover:bg-[#323c66]"><img class="button-img w-[1.3rem]"
                                                                                    src="../imgs/icons8-add-book-libera-30.png" alt="Aggiungi in libreria"></a>
                                <a href="${pageContext.request.contextPath}/RimuoviPreferito?id=${MaterialeDidattico.id}"
                                   class="p-2 bg-[#4c5a9a] hover:bg-[#323c66]"><img class="button-img w-[1.4rem]"
                                                                                    src="../imgs/icons8-add-bookmark.svg" alt="Aggiungi ai preferiti"></a>
                                <a href="${pageContext.request.contextPath}/ScaricaFile?id=${MaterialeDidattico.id}"
                                   class="p-2 bg-[#4c5a9a] hover:bg-[#323c66]"><img class="button-img w-[1.5rem]"
                                                                                    src="../imgs/icons8-return-book-50.png" alt="Download libro"></a>
                                <% }else{ %>
                                <a href="" class="p-2 bg-[#4c5a9a] hover:bg-[#323c66]"><img class="button-img w-[1.3rem]"
                                                                                            src="../imgs/icons8-add-book-libera-30.png" alt="Aggiungi in libreria"></a>
                                <a href="" class="p-2 bg-[#4c5a9a] hover:bg-[#323c66]"><img class="button-img w-[1.4rem]"
                                                                                            src="../imgs/icons8-add-bookmark.svg" alt="Aggiungi ai preferiti"></a>
                                <a href="" class="p-2 bg-[#4c5a9a] hover:bg-[#323c66]"><img class="button-img w-[1.5rem]"
                                                                                            src="../imgs/icons8-return-book-50.png" alt="Download libro"></a>
                                <% } %>
                            </div>
                        </div>

                    </c:forEach>
                </div>
                <% } %>
                <script src="../js/RegLogPop.js"></script>
                </body>

                </html>