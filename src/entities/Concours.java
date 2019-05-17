/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author amine
 */
public class Concours {
    
    
    private int id;
    private String titre;
    private String nom_image;
    private String description;
    private Date date_debut;
    private Date date_fin;

    public Concours(int id,  String titre, String nom_image, String description, Date date_debut, Date date_fin) {
        this.id = id;
        this.titre = titre;
        this.nom_image = nom_image;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }
    public Concours(String titre, String nom_image, String description, Date date_debut, Date date_fin) {
        
        this.titre = titre;
        this.nom_image = nom_image;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }
    

    

    public Concours() {
    }

    

    @Override
    public String toString() {
        return "Concours{" + "id=" + id + ", titre=" + titre + ", description" + description + ", Date debut=" + date_debut + ", date fin=" + date_fin + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNom_image() {
        return nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }
}
