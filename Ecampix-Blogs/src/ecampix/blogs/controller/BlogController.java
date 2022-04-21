/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecampix.blogs.controller;

import ecampix.blogs.model.Blog;
import ecampix.blogs.model.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MSI
 */
public class BlogController {
    Connection cnx;

    public BlogController() {
        cnx =Database.getInstance().getCnx();
    }
    
    
    public ObservableList<Blog> getBlogs(){
        ObservableList<Blog> blogs = FXCollections.observableArrayList();
        String sql ="select * from blog";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                Blog b = new Blog();
                b.setIdBlog(rs.getInt("id"));
                b.setDate_blog(rs.getString("date_blog"));
                b.setDesc_blog(rs.getString("desc_blog"));
                b.setTitre_blog(rs.getString("titre_blog"));
                b.setImage_blog(rs.getString("image_blog"));
                b.setNom_ut_blog(rs.getString("nom_ut_blog"));
                blogs.add(b);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return blogs;
        
    }
    
    public void addBlog(Blog b){
        String query ="insert into blog(date_blog,nom_ut_blog,titre_blog,desc_blog,image_blog,likes_blog,views_blog) values "
                + "('"+b.getDate_blog()+"','"+b.getNom_ut_blog()+"','"+b.getTitre_blog()+"','"+b.getDesc_blog()+"','"+b.getImage_blog()+"','0','0')";
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }    

    public boolean modifyBlog(Blog b){
        String sql ="update blog set date_blog='"
                +b.getDate_blog()+"',"
                +" nom_ut_blog='"+b.getNom_ut_blog()+"',"
                +" titre_blog='"+b.getTitre_blog()+"',"
                +" desc_blog='"+b.getDesc_blog()+"',"
                +" image_blog='"+b.getImage_blog()+"'"
                +" WHERE id="+b.getIdBlog();
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
    
    
    public boolean deleteBlog(int id){
        String sql ="delete from blog where id="+id;
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
    
    public  ObservableList<String> getTitles(){
    ObservableList<String> titles = FXCollections.observableArrayList();
        String sql ="select * from blog";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                titles.add(rs.getString("titre_blog"));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return titles;    
    }
    
    public int findIdBlogByTitle(String title){
        int idBlog = 0;
        String sql ="select id from blog where titre_blog='"+title+"'";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            rs.next();
            idBlog = rs.getInt("id");  
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
        return idBlog;
    }
}
