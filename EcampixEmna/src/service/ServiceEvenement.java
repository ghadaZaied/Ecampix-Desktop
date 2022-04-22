/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Evenement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Myconnexion;

/**
 *

 */
public class ServiceEvenement implements IService<Evenement>{
    Connection cnx;
    public ServiceEvenement() {
        cnx=Myconnexion.getInstance().getCnx();
    }
    
    @Override
    public void ajouter(Evenement e) {
        
        try {
            String query="INSERT INTO `evenement`"
                    + "( `type`, `date_debut`,"
                    + " `date_fin`, `lieu`)"
                    + " VALUES ('"+e.getType()+"','"+e.getDate_debut()+"',"
                    + "'"+e.getDate_fin()+"','"+e.getLieu()+"')";
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(Evenement t, int id) {
        try {
            String query="UPDATE `evenement` SET "
                    + "`type`='"+t.getType()+"',"
                    + "`date_debut`='"+t.getDate_debut()+"',"
                    + "`date_fin`='"+t.getDate_fin()+"',"
                    + "`lieu`='"+t.getLieu()+"' WHERE id="+id;
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String query="DELETE FROM `evenement` WHERE id="+id;
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Evenement> afficher() {
        List<Evenement> le =new ArrayList<>();
        try {
            String query="SELECT * FROM `evenement`";
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Evenement e=new Evenement();
                e.setDate_debut(rs.getDate("date_debut"));
                e.setDate_fin(rs.getDate("date_fin"));
                e.setLieu(rs.getString("lieu"));
                e.setType(rs.getString("type"));
                e.setId(rs.getInt("id"));
                le.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return le;
    }
    public List<Integer> getEventId(){
        List<Integer> le =new ArrayList<>();
        try {
            String query="SELECT * FROM `evenement`";
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                int x=0;
                
                x=(rs.getInt("id"));
                le.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return le;
    }
    
}
