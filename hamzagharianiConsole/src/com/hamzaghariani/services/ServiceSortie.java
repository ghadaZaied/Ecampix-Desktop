/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzaghariani.services;

import com.hamzaghariani.entities.Comment;
import com.hamzaghariani.entities.Sortie;
import com.hamzaghariani.tools.DbConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI
 */
public class ServiceSortie {
    Connection cnx;
    public ServiceSortie() {
        cnx =DbConnect.getInstance().getCnx();
    }  
    
    public List<Sortie> getSorties(){
        List<Sortie> sorties = new ArrayList<>();
        String sql ="select * from sortie";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                Sortie s = new Sortie();
                s.setNom_event(rs.getString("nom_event"));
                s.setDateD_event(rs.getString("date_fin_event"));
                s.setDateF_event(rs.getString("date_debut_event"));
                s.setDescr(rs.getString("description_event"));
                s.setLieu_event(rs.getString("lieu_event"));
                s.setPrix(rs.getInt("prix_event"));
                s.setCapacite(rs.getInt("capacite_event"));
                s.setPartc(rs.getInt("participations"));
                sorties.add(s);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return sorties;
        
    }  
    
    public void showSorties()
    {
        List<Sortie> sorties = getSorties();
        int i=1;
        for (Sortie s : sorties) {
            System.out.println("Sortie ["+i+"]");
            System.out.println("Liste des Sorties :");
            System.out.println("Nom Event : "+s.getNom_event());
            System.out.println("Lieu : "+s.getLieu_event());
            System.out.println("Date Debut : "+s.getDateD_event());
            System.out.println("Date Fin : "+s.getDateF_event());
            System.out.println("Prix : "+s.getPrix());
            System.out.println("Capacite : "+s.getCapacite());
            System.out.println("Participants : "+s.getPartc());
            System.out.println("");
            i++;
        }        
    } 
    
    public void addSortie(Sortie s){
        String query ="insert into sortie(nom_event,type_event,date_debut_event,date_fin_event,lieu_event,capacite_event,description_event,logo_event,prix_event,participations) values("
                +"'"+s.getNom_event()+"',"
                +"'"+s.getType_event()+"',"
                +"'"+s.getDateD_event()+"',"
                +"'"+s.getDateF_event()+"',"
                +"'"+s.getLieu_event()+"',"
                +s.getCapacite()+","
                +"'"+s.getDescr()+"',"
                +"'"+s.getImgEv()+"',"
                +s.getPrix()+","
                +s.getPartc()
                +")";
        //System.out.println(query);
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("Sortie Ajoutée ");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }  
    
    public boolean modifySortie(Sortie s){
String sql ="update sortie set nom_event='"+s.getNom_event()+
"',type_event='"+s.getType_event()+
"',lieu_event='"+s.getLieu_event()+
"',description_event='"+s.getDescr()+
"',prix_event="+s.getPrix()+
",participations="+s.getPartc()+
",capacite_event="+s.getCapacite()+
",date_debut_event='"+s.getDateD_event()+
"',date_fin_event='"+s.getDateF_event()+
"' where id="+s.getId();;
        
                
        Statement ste;
        try{
            ste = cnx.createStatement();
            int rs = ste.executeUpdate(sql);
            System.out.println("sortie Modifier . ");
            return true;
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    public boolean deleteSortie(int id){
        String sql ="delete from sortie where id="+id;
        Statement ste;
        try{
            ste = cnx.createStatement();
            int rs = ste.executeUpdate(sql);
            System.out.println("Sortie Supprimer . ");
            return true;            
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }        
    }    
}
