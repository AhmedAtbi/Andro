package com.example.gestioncontact;

public class User {
    private String login,mdp;
    private  int id;

    public User(int id,String login, String mdp) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;

    }

    public User(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }


}
