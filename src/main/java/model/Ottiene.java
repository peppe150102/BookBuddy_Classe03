package model;

public class Ottiene {
    private String email;
    private int id;
    private boolean preferito;

    public Ottiene(String email, int id, boolean preferito) {
        this.email = email;
        this.id = id;
        this.preferito = preferito;
    }

    public Ottiene() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPreferito() {
        return preferito;
    }

    public void setPreferito(boolean preferito) {
        this.preferito = preferito;
    }

}
