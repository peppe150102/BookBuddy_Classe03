package model;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentiDao {

    public Studenti checkLogin(String email, String password) throws SQLException {
        Studenti user = new Studenti();
        try (Connection con = ConnectionPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from studenti where email=? and pass=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setEmail(rs.getString(1));
                user.setNome_utente(rs.getString(2));
                user.setPass(rs.getString(3));
                user.setAdmin(rs.getBoolean(4));
            }
            return user;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public ArrayList<Studenti> doRetrieveAll() {

        ArrayList<Studenti> studenti = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;
        try (Connection con = ConnectionPool.getConnection()) {

            ps = con.prepareStatement("select * from studenti ");

            rs = ps.executeQuery();

            while (rs.next()) {
                Studenti s = new Studenti();
                s.setEmail(rs.getString(1));
                s.setNome_utente(rs.getString(2));
                s.setPass(rs.getString(3));
                s.setAdmin(rs.getBoolean(4));

                studenti.add(s);

            }
            return studenti;

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public void doSave(Studenti s) {

        PreparedStatement ps;
        try (Connection con = ConnectionPool.getConnection()) {

            ps = con.prepareStatement("insert into studenti values (?,?,?,?) ");

            ps.setString(1, s.getEmail());
            ps.setString(2, s.getNome_utente());
            ps.setString(3, s.getPass());
            ps.setBoolean(4, s.isAdmin());
            ps.executeUpdate();
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public void doDelete(Studenti s) {
        PreparedStatement ps;
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement("DELETE FROM Studenti WHERE email = ?");
            ps.setString(1, s.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUserInfo(Studenti s) {
        PreparedStatement ps;

        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement("UPDATE Studenti SET email=?, nome_utente=?, pass=? WHERE email =?");
            ps.setString(1, s.getEmail());
            ps.setString(2, s.getNome_utente());
            ps.setString(3, s.getPass());
            ps.setBoolean(4, s.isAdmin());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void addAdmin(Studenti s) {
        PreparedStatement ps;
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement("UPDATE Studenti SET admin = 1 WHERE email = ?");
            ps.setString(1, s.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void DeleteAdmin(Studenti s) {
        PreparedStatement ps;
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement("UPDATE Studenti SET admin = 0 WHERE email = ?");
            ps.setString(1, s.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
