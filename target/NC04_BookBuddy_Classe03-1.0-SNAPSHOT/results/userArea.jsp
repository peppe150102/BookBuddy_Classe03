<%@ page import="model.Studenti" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../components/navbar.jsp" />
<jsp:include page="../components/userbar.jsp" />
<html>
<head>
    <link rel="stylesheet" href="../style.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title> Book Buddy | Area Utente </title>
</head>
<body class="main-bg flex flex-row gap-3 overflow-hidden">
<% Studenti studente=(Studenti) session.getAttribute("studente"); %>
<form autocomplete="off" action="${pageContext.request.contextPath}/ModificaInfo"
      method="post" class="flex flex-col gap-6 items-center
      my-[3rem] mx-[17rem] h-[44rem] w-[35rem]
      rounded-3xl bg-[#323C67] text-[#9ca39f]">
    <div class="nome flex flex-row gap-7 items-center">
        <p>Nome utente: ${studente.nome_utente}</p>
        <input type="text" name="newName" placeholder="Inserire nuovo nome" class="h-max bg-transparent border-b-[white] max-w-sm text-center"/>
    </div>

    <div class="mail flex flex-row gap-7 items-center">
        <p>E-mail: ${studente.email}</p>
        <input type="email" name="newMail" id="mail" placeholder="Inserire nuova mail" class="h-max bg-transparent border-b-[white] max-w-sm text-center"/>
    </div>

    <div class="passw flex flex-row gap-7 items-center">
        <p>Password: ${studente.pass}</p>
        <input type="password" name="newPassw" id="passw" placeholder="Inserire nuova password" class="h-max bg-transparent border-b-[white] max-w-sm text-center"/>
    </div>

    <button type="submit" class="text-[#1d213f]">Aggiorna informazioni</button>
</form>
</body>
</html>
