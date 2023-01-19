package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Studenti;

@MultipartConfig
@WebServlet(name = "CaricaFile", value = "/CaricaFile")
public class CaricaFile extends HttpServlet {
    private String dbURL = "jdbc:mysql://localhost:3306/bookbuddy";
    private String dbUser = "root";
    private String dbPass = "lollypop";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String nomeAppunti = request.getParameter("nomeMateriale");
                LocalDate data = LocalDate.parse(request.getParameter("dataPub"),dt);
                String corsoDiLaurea = request.getParameter("corsoLaurea");
                String corso = request.getParameter("materia");
                String copertina = request.getParameter("copertina");
                boolean appunti = Boolean.parseBoolean(request.getParameter("appunti"));
                String autore = null;
                autore = request.getParameter("autore");
                InputStream stream = null;
                Studenti s = (Studenti) request.getSession().getAttribute("studente");
                
                Part file = request.getPart("file");

                Connection conn = null;
                stream = file.getInputStream();

                try {
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                    String sql = "INSERT INTO materialedidattico (autore, nome, data_pubblicazione, corso_di_laurea, materia, appunti, fileintero, copertina) values (?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs;
                    if(autore==null)
                        ps.setString(1,s.getNome_utente());
                    else
                        ps.setString(1, autore);

                    ps.setString(2, nomeAppunti);
                    ps.setDate(3, Date.valueOf(data));
                    ps.setString(4, corsoDiLaurea);
                    ps.setString(5, corso);
                    ps.setBoolean(6, appunti);
                    ps.setString(8, copertina);
                    ps.setBlob(7, stream);

                    ps.executeUpdate();
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                } catch (Exception e) {
                    System.err.println("Errore nel caricamento file");

                }
            }
}
