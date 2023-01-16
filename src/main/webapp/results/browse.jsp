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
          <div class="home flex flex-row items-center content-evenly px-12 py-8 gap-16 text-white flex-wrap">
            <%-- Corpo della card del materiale --%>
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
                  <%-- Pulsanti della card per studente loggato e non --%>
                    <div class="card-button flex flex-col absolute bottom-0 right-0">
                      <% if(session.getAttribute("studente")!=null){%>
                        <a href="${pageContext.request.contextPath}/AggiungiALibreria"
                          class="p-2 bg-[#4c5a9a] hover:bg-[#323c66]"><img class="button-img w-[1.3rem]"
                            src="../imgs/icons8-add-book-libera-30.png" alt="Aggiungi in libreria"></a>
                        <a href="${pageContext.request.contextPath}/AggiungiPreferito"
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
        </body>

        </html>