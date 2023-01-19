package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Result;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ConnectionPool;

@WebServlet(name = "ScaricaFile", value = "/ScaricaFile")
public class ScaricaFile extends HttpServlet {

    private static final int BUFFER_SIZE = 4096;
    private String dbURL = "jdbc:mysql://localhost:3306/bookbuddy";
    private String dbUser = "root";
    private String dbPass = "lollypop";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Connection conn = null;

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            String sql = "SELECT * FROM MaterialeDidattico WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String nomeMateriale = rs.getString("nome");
                Blob blob = rs.getBlob("fileintero");
                InputStream inputStream = blob.getBinaryStream();
                int fileLenght = inputStream.available();
//                System.out.println("Lunghezza file = " + fileLenght);

                ServletContext context = getServletContext();

                response.setContentType("application/pdf;charset=UTF-8");
                response.setContentLength(fileLenght);
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; nome=\"%s\"", nomeMateriale);
                response.setHeader(headerKey, headerValue);

                OutputStream outStream = response.getOutputStream();

                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outStream.close();
            } else {
                response.getWriter().print("File non cercato: " + id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            response.getWriter().print(ex);
        } catch (IOException ex) {
            ex.printStackTrace();
            response.getWriter().print(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
