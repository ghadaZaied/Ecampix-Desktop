/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Evenement;
import entity.Ticket;
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
 * @author LENOVO
 */
public class ServiceTicket implements IService<Ticket> {
     Connection cnx;
    public ServiceTicket() {
        cnx=Myconnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Ticket T) {   
        try {
            String query="INSERT INTO `ticket`"
                    + "(`numero`, `nombre`, `destination`,"
                    + " `date`, `heure`, `id_evenement`) "
                    + "VALUES ('"+T.getNumero()+"','"+T.getNombre()+"',"
                    + "'"+T.getDestination()+"','"+T.getDate()+"',"
                    + "'"+T.getHeure()+"','"+T.getId_evenement()+"')";
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void modifier(Ticket e, int id) {  
        try {
            String query="UPDATE `ticket` SET "
                    + "`numero`='"+e.getNumero()+"',"
                    + "`nombre`='"+e.getNombre()+"',"
                    + "`destination`='"+e.getDestination()+"',"
                    + "`date`='"+e.getDate()+"',"
                    + "`heure`='"+e.getHeure()+"',"
             
                    + "`id_evenement`='"+e.getId_evenement()+"' WHERE id="+id;
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int id) {
         try {
            String query="DELETE FROM `ticket` WHERE id="+id;
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Ticket> afficher() {
        List<Ticket> le =new ArrayList<>();
        try {
            String query="SELECT * FROM `ticket`";
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Ticket T=new Ticket();
                T.setNumero(rs.getInt("numero"));
                T.setNombre(rs.getInt("nombre"));
                T.setDestination(rs.getString("destination"));
                T.setDate(rs.getDate("date"));
                T.setHeure(rs.getDate("heure"));
                T.setId_evenement(rs.getInt("id_evenement"));
                T.setId(rs.getInt("id"));
                le.add(T);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return le;
    }
    }
    

