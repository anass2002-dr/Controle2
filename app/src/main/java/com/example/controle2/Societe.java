package com.example.controle2;

import java.io.Serializable;

public class Societe implements Serializable {


    private int ID;
    private String Nom;
    private String Secteur_Activite;
    private int nb_employe;

    public Societe(int ID, String nom, String secteur_Activite, int nb_employe) {
        this.ID = ID;
        Nom = nom;
        Secteur_Activite = secteur_Activite;
        this.nb_employe = nb_employe;
    }

    public Societe() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getSecteur_Activite() {
        return Secteur_Activite;
    }

    public void setSecteur_Activite(String secteur_Activite) {
        Secteur_Activite = secteur_Activite;
    }

    public int getNb_employe() {
        return nb_employe;
    }

    public void setNb_employe(int nb_employe) {
        this.nb_employe = nb_employe;
    }
}
