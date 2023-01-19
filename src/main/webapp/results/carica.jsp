<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <jsp:include page="../components/userbar.jsp" />
    <% session.setAttribute("pagina", "Carica" ); %>
        <jsp:include page="../components/navbar.jsp" />
        <html>

        <head>
            <title>Book Buddy | Search</title>
            <link rel="stylesheet" href="../style.css">
            <script src="https://cdn.tailwindcss.com"></script>
        </head>

        <body class="main-bg flex flex-row gap-3 overflow-hidden">
            <form autocomplete="off" method="post" action="${pageContext.request.contextPath}/CaricaFile"
            enctype='multipart/form-data'
            class="flex flex-col my-[3rem] mx-[17rem] h-[44rem] w-[30rem] gap-6 rounded-3xl bg-[#323C67] text-[#9ca39f]">
            <input class="bg-transparent border-b-[white] max-w-sm text-center" type="text" required
                placeholder="Nome materiale" name="nomeMateriale" id="nomeMateriale">
            <input class="bg-transparent border-b-[white] max-w-sm text-center" type="text" required
                placeholder="Corso di laurea" name="corsoLaurea" id="corsoLaurea">
            <input class="bg-transparent border-b-[white] max-w-sm text-center" type="text" required placeholder="Materia"
                name="materia" id="materia">
            <input class="bg-transparent border-b-[white] max-w-sm text-center" type="text" placeholder="Autore"
                name="autore" id="autore">
            <input class="bg-transparent border-b-[white] max-w-sm text-center" type="text" placeholder="Data (dd-mm-yyyy)"
                name="dataPub" id="dataPub">
            <label for="appunti">Sono appunti? </label>
            <input class="bg-transparent border-b max-w-sm text-center" type="checkbox" name="appunti" id="appunti"
                onclick="EnableDisableTextBox(this)">
            <input class="bg-transparent z-40 max-w-sm text-center" type="file" required accept="application/pdf"
                name="file" id="file">
            <input class="bg-transparent border-b-[white] max-w-sm text-center" type="text"
                placeholder="Link copertina del libro" name="copertina" id="copertina">
            <button type="submit"
                class="modal-button rounded-full text-[#1d213f] text-opacity-70 profile-button px-5 py-2 text-sm mr-">Carica Materiale</button>
        </form>
        <script>
            function EnableDisableTextBox(appunti) {
                const autore = document.getElementById("autore");
                const copertina = document.getElementById("copertina");
                autore.disabled = appunti.checked;
                copertina.disabled = appunti.checked;
            }
        </script>
        </body>

        </html>