package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Studenti;
import model.StudentiDao;

import java.io.IOException;

@WebServlet(name = "ModificaInfo", value = "/ModificaInfo")
public class ModificaInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail, passw, nome;
        String resp = "/index.jsp";
        mail = request.getParameter("newMail");
        passw = request.getParameter("newPassw");
        nome = request.getParameter("newName");
        Studenti studente = (Studenti) request.getSession().getAttribute("studente");

        StudentiDao studentiDao = new StudentiDao();
        studentiDao.updateUserInfo(mail, passw, nome, studente.getEmail());

        studente.setEmail(mail);
        studente.setPass(passw);
        studente.setNome_utente(nome);

        response.sendRedirect(request.getContextPath() + resp);
    }
}
