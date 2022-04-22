/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compix;

import entity.Evenement;
import entity.Ticket;
import java.sql.Date;
import java.time.LocalDate;
import service.ServiceEvenement;
import service.ServiceTicket;
import utils.Myconnexion;

/**
 *
 
 */
public class Compix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date d=new Date(2022-1900, 5, 29);
        ServiceEvenement se=new ServiceEvenement();
        ServiceTicket st=new ServiceTicket();
        Evenement e=new Evenement("cc", d, d, "bcccb");
        
        Ticket t=new Ticket(99, 8, "aaaaaaaaa", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()),5);
        //st.ajouter(t);
        //st.supprimer(10);
        //st.modifier(t, 9);
        System.out.println(se.getEventId());
        //se.ajouter(e);
        //se.supprimer(4);
        //se.modifier(e, 5);
        //System.out.println(se.afficher());
             
        
    }
    
}
