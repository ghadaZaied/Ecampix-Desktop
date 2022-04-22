/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecampix.blogs.controller;

import ecampix.blogs.model.Comment;
import ecampix.blogs.model.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MSI
 */
public class CommentController {
    Connection cnx;
    public CommentController() {
    cnx =Database.getInstance().getCnx();
    }

    public ObservableList<Comment> getComments(){
        ObservableList<Comment> comments = FXCollections.observableArrayList();
        String sql ="select * from comment";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                Comment c = new Comment();
                c.setIdComment(rs.getInt("id"));
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
    
    public boolean modifyComment(Comment c){
        String sql ="update comment set date_comment='"
                +c.getDate_comment()+"',"
                +" nom_ut_comment='"+c.getNom_ut_comment()+"',"
                +" cmnt_comment='"+c.getCmnt()+"'"
                +" WHERE id="+c.getIdComment();
                ;
        Statement ste;
        try{
            ste = cnx.createStatement();
            int rs = ste.executeUpdate(sql);
            return true;
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }  
    
    public boolean deleteComment(int id){
        String sql ="delete from comment where id="+id;
        Statement ste;
        try{
            ste = cnx.createStatement();
            int rs = ste.executeUpdate(sql);
            return true;            
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }        
    }

    public void addComment(Comment c){
        String query ="insert into comment(blog_id,date_comment,nom_ut_comment,cmnt_comment) values "
                + "("+c.getId_blog()+",'"+c.getDate_comment()+"','"+c.getNom_ut_comment()+"','"+c.getCmnt()+"')";
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }     
}
