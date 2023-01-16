package controller;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.MaterialeDidattico;
import model.OttieneDao;
import model.Studenti;

@WebServlet(name = "AggiungiPreferito", value = "/AggiungiALibreria")
public class AggiungiALibreria extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Studenti s = (Studenti) request.getSession().getAttribute("studente");
        MaterialeDidattico md = (MaterialeDidattico) request.getSession().getAttribute("id");
        OttieneDao o = new OttieneDao();
        o.addLibreria(s, md);

    }
}