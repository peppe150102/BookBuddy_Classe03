package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OttieneDao {

    public ArrayList<MaterialeDidattico> doRetrieveByEmail(Studenti s) {
        ArrayList<MaterialeDidattico> materialeDidattico = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement(
                    "SELECT MaterialeDidattico.* FROM MaterialeDidattico m,Ottiene o WHERE m.id=o.id and o.email=? ");
            ps.setString(1, s.getEmail());
            rs = ps.executeQuery();
            while (rs.next()) {
                MaterialeDidattico md = new MaterialeDidattico();
                md.setId(rs.getInt(1));
                md.setAutore(rs.getString(2));
                md.setNome(rs.getString(3));
                md.setData_publicazione(rs.getDate(4));
                md.setCorso_di_laurea(rs.getString(5));
                md.setMateria(rs.getString(6));
                md.setValutazione(rs.getDouble(7));
                md.setAppunti(rs.getBoolean(8));
                materialeDidattico.add(md);
            }
            return materialeDidattico;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materialeDidattico;
    }

    public ArrayList<MaterialeDidattico> doRetrievePreferito(Studenti s) {
        ArrayList<MaterialeDidattico> materialeDidattico = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement(
                    "SELECT m.* FROM MaterialeDidattico m, Ottiene o WHERE m.id = o.id  AND o.email=? AND o.preferito = 1 ");
            ps.setString(1, s.getEmail());
            rs = ps.executeQuery();

            while (rs.next()) {
                MaterialeDidattico md = new MaterialeDidattico();
                md.setId(rs.getInt(1));
                md.setAutore(rs.getString(2));
                md.setNome(rs.getString(3));
                md.setData_publicazione(rs.getDate(4));
                md.setCorso_di_laurea(rs.getString(5));
                md.setMateria(rs.getString(6));
                md.setValutazione(rs.getDouble(7));
                md.setAppunti(rs.getBoolean(8));
                materialeDidattico.add(md);
            }
            return materialeDidattico;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void removePreferito(Studenti s, MaterialeDidattico md) {
        PreparedStatement ps;
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement("UPDATE Ottiene SET preferito = 0 WHERE id=? AND email = ?");
            ps.setInt(1, md.getId());
            ps.setString(2, s.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeLibro(Studenti s, MaterialeDidattico md) {
        PreparedStatement ps;
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement("DELETE FROM ottiene WHERE id=? AND email =?");
            ps.setInt(1, md.getId());
            ps.setString(2, s.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPreferito(Studenti s, MaterialeDidattico md) {
        PreparedStatement ps;
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement("UPDATE Ottiene SET Preferito = 1 WHERE email = ? AND id = ?");
            ps.setString(1, s.getEmail());
            ps.setInt(2, md.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addLibreria(Studenti s, MaterialeDidattico md) {
        PreparedStatement ps;
        Ottiene o = new Ottiene();
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement("INSERT INTO ottiene values(?,?,?)");
            ps.setString(1, s.getEmail());
            ps.setInt(2, md.getId());
            ps.setBoolean(3, o.isPreferito());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
