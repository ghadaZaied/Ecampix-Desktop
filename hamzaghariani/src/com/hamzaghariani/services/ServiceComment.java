/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzaghariani.services;

import com.hamzaghariani.entities.Comment;
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
public class ServiceComment {
    Connection cnx;
    public ServiceComment() {
        cnx =DbConnect.getInstance().getCnx();
    }
    
    public List<Comment> getComments(){
        List<Comment> comments = new ArrayList<>();
        String sql ="select * from comment";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                Comment c = new Comment();
                c.setDate_comment(rs.getString("date_comment"));
                c.setCmnt(rs.getString("cmnt_comment"));
                c.setId_blog(rs.getInt("blog_id"));
                c.setNom_ut_comment(rs.getString("nom_ut_comment"));
                comments.add(c);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return comments;
        
    }   
    
    public void showComments()
    {
        List<Comment> comments = getComments();
        int i=1;
        for (Comment c : comments) {
            System.out.println("Commentaire ["+i+"]");
            System.out.println("Liste des Commentaires :");
            System.out.println("Date : "+c.getDate_comment());
            System.out.println("Par : "+c.getNom_ut_comment());
            System.out.println("Commentaire : "+c.getCmnt());
            System.out.println("id Blog : "+c.getId_blog());
            System.out.println("");
            i++;
        }        
    }
    
    
    public boolean findComment(int id){
        String sql = "select * from comment where id="+id;
        Statement ste;
        try
        {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            int rowCount = 0;
            while(rs.next()){
            rowCount++;
            }
            if(rowCount != 0)
                return true;
            else
                return false;
                        
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }        
    }
    
    public boolean modifyComment(Comment c, int id){
        String sql ="update comment set cmnt_comment='"
                +c.getCmnt()+"',"
                +" nom_ut_comment='"+c.getNom_ut_comment()+"'"
                +" WHERE id="+id;
                ;
        Statement ste;
        try{
            if(findComment(id)){
            ste = cnx.createStatement();
            int rs = ste.executeUpdate(sql);
            System.out.println("Commentaire Modifier . ");
            return true; 
            }
            else
            {
                System.out.println("Commentaire non existe.");
                return false;                
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean deleteComment(int id){
        String sql ="delete from comment wid="+id;
        Statement ste;
        try{
            ste = cnx.createStatement();
            int rs = ste.executeUpdate(sql);
            System.out.println("Commentaire Supprimer . ");
            return true;            
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }        
    }    
}
