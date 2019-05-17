/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author revecom
 */
public class Participant {
    private int id;
    private int id_concours;
private String nom_image ;
private String nom;
private String prenom;
private String sexe;
private String information;
private int vote;


public Participant(int id, String nom_image, String nom, String prenom, String sexe, String information, int vote) {
        this.id = id;
        this.nom_image = nom_image;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.information = information;
        this.vote = vote;
    }
public Participant(int id,int id_concours, String nom_image, String nom, String prenom, String sexe, String information, int vote) {
    this.id_concours = id_concours; 
    this.id=id;
    this.nom_image = nom_image;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.information = information;
        this.vote = vote;
    }
public Participant(String nom_image, String nom, String prenom, String sexe, String information) {
        this.nom_image = nom_image;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.information = information;
        
    }
@Override
    public String toString() {
        return "id=" + id + ", nom_image=" + nom_image + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", information=" + information + ", vote=" + vote  ;
    }
    public Participant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_image() {
        return nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    
}
