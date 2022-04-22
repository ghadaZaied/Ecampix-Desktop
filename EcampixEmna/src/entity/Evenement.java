/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 
 */
public class Evenement {
    private int id;
    private String type;
    private Date date_debut;
    private Date date_fin;
    private String lieu;

    public Evenement() {
    }

    public Evenement(String type, Date date_debut, Date date_fin, String lieu) {
        this.type = type;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.lieu = lieu;
    }

    public Evenement(int id, String type, Date date_debut, Date date_fin, String lieu) {
        this.id = id;
        this.type = type;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.lieu = lieu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", type=" + type + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", lieu=" + lieu + '}'+"\n";
    }

    
    
}
