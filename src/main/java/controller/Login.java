package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Studenti;
import model.StudentiDao;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mail = request.getParameter("email_log");
        String passw = request.getParameter("password_log");
        HttpSession session = request.getSession();
        StudentiDao u = new StudentiDao();
        String resp = "/index.jsp";
        Studenti studente;
        try {
            studente = u.checkLogin(mail, passw);
            if (studente.getNome_utente() == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(resp);
                dispatcher.forward(request, response);
            } else {
                session.setAttribute("studente", studente);
                response.sendRedirect(request.getContextPath() + resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // try {
        // Studenti studente = u.checkLogin(mail, passw);
        // if (studente == null) {
        // System.out.println("OK3");
        // } else if (studente.isAdmin()) {
        // session.setAttribute("admin", studente);
        // System.out.println("OK");
        // } else {
        // session.setAttribute("studente", studente);
        // System.out.println("OK2");
        // }
        // resp = "/index.jsp";

        // response.sendRedirect(request.getContextPath() + resp);

        // } catch (Exception e) {
        // System.out.println("popipopi");
        // }

    }
}
