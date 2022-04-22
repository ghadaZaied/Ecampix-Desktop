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
public class Ticket {
    private int id;
    private int numero;
    private int nombre;
    private String destination;
    private Date date;
    private Date heure;
    private int id_evenement;

    public Ticket() {
    }

    public Ticket(int numero, int nombre, String destination, Date date, Date heure, int id_evenement) {
        this.numero = numero;
        this.nombre = nombre;
        this.destination = destination;
        this.date = date;
        this.heure = heure;
        this.id_evenement = id_evenement;
    }

    public Ticket(int id, int numero, int nombre, String destination, Date date, Date heure, int id_evenement) {
        this.id = id;
        this.numero = numero;
        this.nombre = nombre;
        this.destination = destination;
        this.date = date;
        this.heure = heure;
        this.id_evenement = id_evenement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", numero=" + numero + ", nombre=" + nombre + ", destination=" + destination + ", date=" + date + ", heure=" + heure + ", id_evenement=" + id_evenement + '}'+"\n";
    }

    
}
