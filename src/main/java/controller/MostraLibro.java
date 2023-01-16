package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.MaterialeDidattico;
import model.MaterialeDidatticoDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "MostraLibro", value = "/MostraLibro")
public class MostraLibro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        MaterialeDidatticoDao md = new MaterialeDidatticoDao();
        ArrayList<MaterialeDidattico> materiale = md.doRetrieveByNome(nome);

        PrintWriter output = response.getWriter();

        for (MaterialeDidattico m : materiale) {
            output.println(m.getNome());
        }
        request.setAttribute("listaLibri", materiale);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Materiale.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
