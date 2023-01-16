package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.MaterialeDidattico;
import model.MaterialeDidatticoDao;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SfogliaMateriale", value = "/SfogliaMateriale")
public class SfogliaMateriale extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        ArrayList<MaterialeDidattico> m = (ArrayList<MaterialeDidattico>) md.doRetrieveAll();
        request.setAttribute("listaLibri", m);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
