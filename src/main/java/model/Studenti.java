package model;

public class Studenti {
    private String email, nome_utente, pass;
    private boolean admin;

    public Studenti(String email, String nome_utente, String pass, boolean admin) {
        this.email = email;
        this.nome_utente = nome_utente;
        this.pass = pass;
        this.admin = admin;
    }

    public Studenti() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome_utente() {
        return nome_utente;
    }

    public void setNome_utente(String nome_utente) {
        this.nome_utente = nome_utente;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

}
