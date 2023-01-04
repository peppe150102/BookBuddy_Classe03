package model;

import java.sql.Blob;
import java.sql.Date;

public class MaterialeDidattico {
    public MaterialeDidattico(int id, String autore, String nome, Date data_pubblicazione, String corso_di_laurea,
            String materia,
            double valutazione, boolean appunti, Blob fileintero, String copertina) {
        this.id = id;
        this.nome = nome;
        this.autore = autore;
        this.data_publicazione = data_pubblicazione;
        this.corso_di_laurea = corso_di_laurea;
        this.materia = materia;
        this.valutazione = valutazione;
        this.appunti = appunti;
        this.fileintero = fileintero;
        this.copertina = copertina;
    }

    public MaterialeDidattico() {
    }

    private int id;
    private String autore, nome, corso_di_laurea, materia;
    private Date data_publicazione;
    private double valutazione;
    private boolean appunti;
    private Blob fileintero;
    private String copertina;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCorso_di_laurea() {
        return corso_di_laurea;
    }

    public void setCorso_di_laurea(String corso_di_laurea) {
        this.corso_di_laurea = corso_di_laurea;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Date getData_publicazione() {
        return data_publicazione;
    }

    public void setData_publicazione(Date data_publicazione) {
        this.data_publicazione = data_publicazione;
    }

    public double getValutazione() {
        return valutazione;
    }

    public void setValutazione(double valutazione) {
        this.valutazione = valutazione;
    }

    public boolean isAppunti() {
        return appunti;
    }

    public void setAppunti(boolean appunti) {
        this.appunti = appunti;
    }

    public Blob getFileintero() {
        return fileintero;
    }

    public void setFileintero(Blob fileintero) {
        this.fileintero = fileintero;
    }

    public String getCopertina() {
        return copertina;
    }

    public void setCopertina(String copertina) {
        this.copertina = copertina;
    }
}
