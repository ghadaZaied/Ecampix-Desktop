/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzaghariani.entities;

/**
 *
 * @author MSI
 */
public class Sortie {
    int id;
    String nom_event;
    String type_event;
    String dateD_event;
    String dateF_event;
    String lieu_event;
    int capacite;
    String descr;
    String imgEv;
    int prix;
    int partc;

    public Sortie() {
    }
    
    
    

    public Sortie(int id, String nom_event, String type_event, String dateD_event, String dateF_event, String lieu_event, int capacite, String descr, String imgEv, int prix, int partc) {
        this.id = id;
        this.nom_event = nom_event;
        this.type_event = type_event;
        this.dateD_event = dateD_event;
        this.dateF_event = dateF_event;
        this.lieu_event = lieu_event;
        this.capacite = capacite;
        this.descr = descr;
        this.imgEv = imgEv;
        this.prix = prix;
        this.partc = partc;
    }

    public Sortie(String nom_event, String type_event, String dateD_event, String dateF_event, String lieu_event, int capacite, String descr, String imgEv, int prix, int partc) {
        this.nom_event = nom_event;
        this.type_event = type_event;
        this.dateD_event = dateD_event;
        this.dateF_event = dateF_event;
        this.lieu_event = lieu_event;
        this.capacite = capacite;
        this.descr = descr;
        this.imgEv = imgEv;
        this.prix = prix;
        this.partc = partc;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_event() {
        return nom_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public String getType_event() {
        return type_event;
    }

    public void setType_event(String type_event) {
        this.type_event = type_event;
    }

    public String getDateD_event() {
        return dateD_event;
    }

    public void setDateD_event(String dateD_event) {
        this.dateD_event = dateD_event;
    }

    public String getDateF_event() {
        return dateF_event;
    }

    public void setDateF_event(String dateF_event) {
        this.dateF_event = dateF_event;
    }

    public String getLieu_event() {
        return lieu_event;
    }

    public void setLieu_event(String lieu_event) {
        this.lieu_event = lieu_event;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getImgEv() {
        return imgEv;
    }

    public void setImgEv(String imgEv) {
        this.imgEv = imgEv;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getPartc() {
        return partc;
    }

    public void setPartc(int partc) {
        this.partc = partc;
    }
    
    
}
