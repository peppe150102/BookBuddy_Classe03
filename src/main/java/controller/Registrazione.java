package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Studenti;
import model.StudentiDao;

import java.io.IOException;

@WebServlet(name = "Registrazione", value = "/Registrazione")
public class Registrazione extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Studenti x = new Studenti();
        StudentiDao y = new StudentiDao();
        x.setEmail(request.getParameter("email"));
        x.setNome_utente(request.getParameter("nome_utente"));
        x.setPass(request.getParameter("password"));
        y.doSave(x);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
