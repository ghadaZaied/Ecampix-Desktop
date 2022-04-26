/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzaghariani.consoleForms;

import com.hamzaghariani.entities.Blog;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author MSI
 */
public class blogConsoleForm {
    public Scanner sc= new Scanner(System.in);
    public LocalDate dateBlog = LocalDate.now();
    
    public int menuForm(){
        System.out.println("** Gestion des Blogs Ecampix **");
        System.out.println("1. Afficher Blogs");
        System.out.println("2. Ajouter un blog");
        System.out.println("3. Modifer un blog");
        System.out.println("4. Supprimer un blog");
        System.out.println("0. Quitter");
        int choix= sc.nextInt();
        return choix;
    }
    
    public Blog addForm(){
                System.out.println("Donner votre nom :");                
                String nomUt=sc.nextLine();  
                sc.nextLine(); 
                System.out.println("Donner Titre Blog :");              
                String titreBlog=sc.nextLine();               
                System.out.println("Donner Description Blog :");                
                String descBlog=sc.nextLine();                
                System.out.println("Donner Image Blog :");               
                String imageBlog=sc.nextLine();
                Blog b = new Blog(dateBlog.toString(), nomUt,titreBlog,descBlog,imageBlog,0,0);
     return b;   
    }
    
    
    public Blog modifyForm(){
                System.out.println("Donner votre nom :");
                String nomUt=sc.nextLine();
                sc.nextLine(); 
                System.out.println("Donner Titre Blog :");
                String titreBlog=sc.nextLine();
                System.out.println("Donner Description Blog :");
                String descBlog=sc.nextLine();
                System.out.println("Donner Image Blog :");
                String imageBlog=sc.nextLine();
                Blog b = new Blog(dateBlog.toString(), nomUt,titreBlog,descBlog,imageBlog,0,0); 
                return b;
    }
}
