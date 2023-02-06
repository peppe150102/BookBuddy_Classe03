<%@ page import="model.Studenti" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="../style.css">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/formRegLog.css">
            <script src="https://cdn.tailwindcss.com"></script>
        </head>

        <body>
            <% Studenti studente=(Studenti) session.getAttribute("studente"); %>
                <% if (studente!=null || session.getAttribute("admin")!=null) { %>
                    <div class="user-area flex flex-col gap-6 items-center w-60 mt-14 fixed top-0 right-8">
                        <img src="${pageContext.request.contextPath}/imgs/books.png" alt="" class="rounded-full w-28">
                        <% if(session.getAttribute("admin")!=null) {%>
                            <p class="text-white text-opacity-90">${studente.nome_utente}</p>
                            <% } %>
                                <% if(session.getAttribute("studente")!=null) {%>
                                    <p class="text-white text-opacity-90">${studente.nome_utente}</p>
                                    <% } %>
                                        <a class="rounded-full text-white text-opacity-70 profile-button px-5 py-2 text-sm"
                                            href="${pageContext.request.contextPath}/results/userArea.jsp">Vedi
                                            Profilo</a>
                                        <a class="rounded-full text-white text-opacity-70 profile-button px-5 py-2 text-sm"
                                            href="${pageContext.request.contextPath}/Logout">Log
                                            Out</a>
                    </div>
                    <% } %>
                        <% if (session.getAttribute("studente")==null && session.getAttribute("admin")==null) { %>
                            <div class="user-area flex flex-col gap-6 items-center w-60 mt-14 fixed top-0 right-8 z-40">
                                <p class="text-white text-opacity-90 text-center mt-[14rem]">Sembra che tu non sia
                                    loggato. <br>
                                    Effettua il login o registrati
                                </p>
                                <div class="modal">
                                    <button class="exit-button">X</button>
                                    <div class="container" id="container">
                                        <div class="form-container sign-up-container">
                                            <form method="post"
                                                action="${pageContext.request.contextPath}/Registrazione">
                                                <h1>Create Account</h1>
                                                <span>or use your email for registration</span>
                                                <input type="text" required placeholder="Name" name="nome_utente" />
                                                <input type="email" required placeholder="Email" name="email" />
                                                <input type="password" required placeholder="Password"
                                                    name="password" />
                                                <button
                                                    class="rounded-full text-white mt-2 text-opacity-70 profile-button px-5 py-2 text-sm"
                                                    type="submit">Sign Up</button>
                                            </form>
                                        </div>
                                        <div class="form-container sign-in-container">
                                            <form method="post" action="${pageContext.request.contextPath}/Login">
                                                <h1>Sign in</h1>
                                                <span>or use your account</span>
                                                <input type="email" required placeholder="Email" name="email_log" />
                                                <input type="password" required placeholder="Password"
                                                    name="password_log" />
                                                <a href="#">Forgot your password?</a>
                                                <button
                                                    class="rounded-full mt-2 text-opacity-70 profile-button px-5 py-2 text-sm"
                                                    type="submit">Sign In</button>
                                            </form>
                                        </div>
                                        <div class="overlay-container">
                                            <div class="overlay">
                                                <div class="overlay-panel overlay-left">
                                                    <h1>Welcome Back!</h1>
                                                    <p>To keep connected with us please login with your personal info
                                                    </p>
                                                    <button
                                                        class="rounded-full text-white mt-2 text-opacity-70 profile-button px-5 py-2 text-sm"
                                                        id="signIn">Sign In</button>
                                                </div>
                                                <div class="overlay-panel overlay-right">
                                                    <h1>Hello, Friend!</h1>
                                                    <p>Enter your personal details and start journey with us</p>
                                                    <button
                                                        class="rounded-full text-white mt-2 text-opacity-70 profile-button px-5 py-2 text-sm"
                                                        id="signUp">Sign Up</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <button
                                    class="modal-button rounded-full text-white text-opacity-70 profile-button px-5 py-2 text-sm mr-">Login</button>
                            </div>
                            <% } %>
                                <script src="${pageContext.request.contextPath}/js/RegLogPop.js"></script>
        </body>

        </html>