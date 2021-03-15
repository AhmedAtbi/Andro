package com.example.gestioncontact;

public class Contact {
        String nom,prenom,num;
        int id;

    public Contact(int id,String nom, String prenom, String num) {
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
        this.id = id;
    }

    public Contact(String nom, String prenom, String num) {
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
