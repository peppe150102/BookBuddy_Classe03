package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.Studenti;
import model.MaterialeDidattico;
import model.OttieneDao;

import java.io.IOException;

@WebServlet(name = "RimuoviPreferito", value = "/RimuoviPreferito")
public class RimuoviPreferito extends HttpServlet{
      @Override 
      protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Studenti s = (Studenti) request.getSession().getAttribute("studente");
                MaterialeDidattico md = (MaterialeDidattico) request.getSession().getAttribute("id");
                OttieneDao o = new OttieneDao();
                o.removePreferito(s, md);
                
    }
}

