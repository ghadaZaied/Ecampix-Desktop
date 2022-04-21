/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzaghariani.services;

import com.hamzaghariani.entities.Blog;
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
public class ServiceBlog {
    Connection cnx;

    public ServiceBlog() {
        cnx =DbConnect.getInstance().getCnx();
    }
    
    
    public void addBlog(Blog b){
        String query ="insert into blog(date_blog,nom_ut_blog,titre_blog,desc_blog,image_blog,likes_blog,views_blog) values "
                + "('"+b.getDate_blog()+"','"+b.getNom_ut_blog()+"','"+b.getTitre_blog()+"','"+b.getDesc_blog()+"','"+b.getImage_blog()+"',"+
                b.getLikes_blog()+","+b.getViews_blog()+")";
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("Blog Ajoutée ");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public List<Blog> getBlogs(){
        List<Blog> blogs = new ArrayList<>();
        String sql ="select * from blog";
        Statement ste;
        try {
            ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                Blog b = new Blog();
                b.setDate_blog(rs.getString("date_blog"));
                b.setDesc_blog(rs.getString("desc_blog"));
                b.setTitre_blog(rs.getString("titre_blog"));
                b.setImage_blog(rs.getString("image_blog"));
                b.setNom_ut_blog(rs.getString("nom_ut_blog"));
                b.setLikes_blog(rs.getInt("likes_blog"));
                b.setViews_blog(rs.getInt("views_blog"));
                blogs.add(b);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return blogs;
        
    }    
    
    public void showBlogs()
    {
        List<Blog> blogs = getBlogs();
        int i=1;
        for (Blog b : blogs) {
            System.out.println("Blog ["+i+"]");
            System.out.println("Liste des Blogs :");
            System.out.println("Date : "+b.getDate_blog());
            System.out.println("Par : "+b.getNom_ut_blog());
            System.out.println("Titre : "+b.getTitre_blog());
            System.out.println("Description : "+b.getDesc_blog());
            System.out.println("Image : "+b.getImage_blog());
            System.out.println("Likes : "+b.getLikes_blog());
            System.out.println("Views : "+b.getViews_blog());
            System.out.println("");
            i++;
        }        
    }
    
    public boolean findBlog(String titM){
        String sql = "select * from blog where titre_blog='"+titM+"'";
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
    
    public boolean modifyBlog(Blog b,String titM){
        String sql ="update blog set date_blog='"
                +b.getDate_blog()+"',"
                +" nom_ut_blog='"+b.getNom_ut_blog()+"',"
                +" titre_blog='"+b.getTitre_blog()+"',"
                +" desc_blog='"+b.getDesc_blog()+"',"
                +" image_blog='"+b.getImage_blog()+"'"
                +" WHERE titre_blog='"+titM+"' ";
                ;
        Statement ste;
        try{
            if(findBlog(titM)){
            ste = cnx.createStatement();
            int rs = ste.executeUpdate(sql);
            System.out.println("Blog Modifier . ");
            return true;
            }
            else
            {
                System.out.println("Blog non existe.");
                return false;
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    
    public boolean deleteBlog(String titre){
        String sql ="delete from blog where titre_blog='"+titre+"'";
        Statement ste;
        try{
            ste = cnx.createStatement();
            int rs = ste.executeUpdate(sql);
            System.out.println("Blog Supprimer . ");
            return true;            
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }        
    }
        
        
}
