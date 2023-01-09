package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.MaterialeDidattico;
import model.OttieneDao;
import model.Studenti;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "MostraLibreria", value = "/MostraLibreria")
public class MostraLibreria extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Studenti s = (Studenti) request.getSession().getAttribute("studente");
        OttieneDao o = new OttieneDao();
        ArrayList<MaterialeDidattico> materiale = (ArrayList<MaterialeDidattico>) o.doRetrieveByEmail(s);
        PrintWriter output = response.getWriter();

        for (MaterialeDidattico m : materiale) {
            output.println(m.getNome());
        }
        request.setAttribute("listaLibri", materiale);

    }
}