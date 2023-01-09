package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialeDidatticoDao {
    public ArrayList<MaterialeDidattico> doRetrieveAll() {
        ArrayList<MaterialeDidattico> materiale = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement(
                    "SELECT id,autore,nome,data_pubblicazione,corso_di_laurea,materia,valutazione,appunti,copertina FROM MaterialeDidattico");
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
                md.setCopertina(rs.getString(9));
                materiale.add(md);
            }
            return materiale;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<MaterialeDidattico> doRetrieveLibri() {
        ArrayList<MaterialeDidattico> materiale = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement("SELECT * FROM MaterialeDidattico WHERE appunti = 0");
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
                md.setCopertina(rs.getString(10));
                materiale.add(md);
            }
            return materiale;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<MaterialeDidattico> doRetrieveAppunti() {
        ArrayList<MaterialeDidattico> materiale = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement("SELECT * FROM MaterialeDidattico WHERE appunti = 1");
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
                md.setCopertina(rs.getString(10));
                materiale.add(md);
            }
            return materiale;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<MaterialeDidattico> doRetrieveByNome(String temp) {
        ArrayList<MaterialeDidattico> materiale = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement("SELECT * FROM MaterialeDidattico WHERE nome like'%?%'");
            ps.setString(1, temp);
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
                md.setCopertina(rs.getString(10));
                materiale.add(md);
            }
            return materiale;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<MaterialeDidattico> doRetrievebyAutore(String temp) {
        ArrayList<MaterialeDidattico> materiale = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement("SELECT * FROM MaterialeDidattico WHERE autore like'%?%'");
            ps.setString(1, temp);
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
                md.setCopertina(rs.getString(10));
                materiale.add(md);
            }
            return materiale;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<MaterialeDidattico> doRetrieveByCorso(String temp) {
        ArrayList<MaterialeDidattico> materiale = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement("SELECT * FROM MaterialeDidattico WHERE corso_di_laurea like'%?%'");
            ps.setString(1, temp);
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
                md.setCopertina(rs.getString(10));
                materiale.add(md);
            }
            return materiale;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(MaterialeDidattico md) {
        PreparedStatement ps;
        try (Connection con = ConnectionPool.getConnection()) {
            ps = con.prepareStatement("DELETE FROM MaterialeDidattico WHERE id = ?");
            ps.setInt(1, md.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
