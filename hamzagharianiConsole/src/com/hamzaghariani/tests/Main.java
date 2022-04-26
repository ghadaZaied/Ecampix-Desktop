/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzaghariani.tests;

import com.hamzaghariani.consoleForms.blogConsoleForm;
import com.hamzaghariani.entities.Blog;
import com.hamzaghariani.entities.Comment;
import com.hamzaghariani.entities.Sortie;
import com.hamzaghariani.services.ServiceBlog;
import com.hamzaghariani.services.ServiceComment;
import com.hamzaghariani.services.ServiceSortie;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author MSI
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner sc= new Scanner(System.in);
     LocalDate dateBlog = LocalDate.now();
     
        ServiceBlog sb = new ServiceBlog();
        ServiceComment sec = new ServiceComment();
        ServiceSortie ss = new ServiceSortie();
      
        while(true){
        System.out.println("** Gestion des Blogs Ecampix **");
        System.out.println("1. Afficher Blogs");
        System.out.println("2. Ajouter un blog");
        System.out.println("3. Modifer un blog");
        System.out.println("4. Supprimer un blog");
        System.out.println("** Gestion des Commentaires Ecampix **");
        System.out.println("5. Afficher Commentaires");
        System.out.println("6. Modifier Commentaire");
        System.out.println("7. Supprimer Commentaire");
        System.out.println("** Gestion des Sorties Ecampix **");
        System.out.println("8. Afficher Sorties");
        System.out.println("9. Ajouter Sortie");
        System.out.println("10. Modifier Sortie");
        System.out.println("11. Supperimer Sortie");
        System.out.println("0. Quitter");
        int choix= sc.nextInt();            
        switch(choix){
            case 1:
                sb.showBlogs();
                break;
            case 2:
                System.out.println("Donner votre nom :");      
                sc.nextLine();
                String nomUt=sc.nextLine();  
                System.out.println("Donner Titre Blog :");              
                String titreBlog=sc.nextLine();               
                System.out.println("Donner Description Blog :");                
                String descBlog=sc.nextLine();                
                System.out.println("Donner Image Blog :");               
                String imageBlog=sc.nextLine();
                Blog b = new Blog(dateBlog.toString(), nomUt,titreBlog,descBlog,imageBlog,0,0);
                sb.addBlog(b);
                break;
            case 3:
                System.out.println("Donner Titre Blog a Modifer :");
                sc.nextLine();
                String titM=sc.nextLine();
                System.out.println("Donner votre nom :");
                String nomUtM=sc.nextLine();
                System.out.println("Donner Titre Blog :");
                String titreBlogM=sc.nextLine();
                System.out.println("Donner Description Blog :");
                String descBlogM=sc.nextLine();
                System.out.println("Donner Image Blog :");
                String imageBlogM=sc.nextLine();
                Blog b2 = new Blog(dateBlog.toString(), nomUtM,titreBlogM,descBlogM,imageBlogM,0,0); 
                sb.modifyBlog(b2, titM);
                break;
            case 4:
                System.out.println("Donner Titre Blog a supprimer :");
                sc.nextLine();
                String titSupp=sc.nextLine();
                sb.deleteBlog(titSupp);
                break;
            case 5:
                sec.showComments();
                break;
            case 6:
                System.out.println("Donner id Commentaire a Modifer :");
                sc.nextLine();
                String idC=sc.nextLine();
                System.out.println("Donner votre nom :");
                String nomUtC=sc.nextLine();
                System.out.println("Ecrire votre commentaire :");
                String cmnt=sc.nextLine();
                Comment c = new Comment(nomUtC,cmnt);
                sec.modifyComment(c, (int)Float.parseFloat(idC));
                break;
            case 7:
                System.out.println("Donner id Commentaire a supprimer :");
                sc.nextLine();
                String idComment=sc.nextLine();
                sec.deleteComment((int)Float.parseFloat(idComment));
                break;
            case 8:
                ss.showSorties();
                break;
            case 9:
                Sortie s = new Sortie("Camping a Hawaria [Desktop]","Sortie","4-8-2022","9-8-2022","Hawaria",5,"Description","hawaria.jpg",55,1);
                ss.addSortie(s);
                break;
            case 10:
                Sortie s2 = new Sortie(5,"Camping a Hawaria [Desktop]","Sortie","4-8-2022","9-8-2022","Hawaria",5,"Description","hawaria.jpg",55,1);
                ss.modifySortie(s2);
                break;
            case 11:
                ss.deleteSortie(5);
                break;
            case 0:
                System.out.println("Quitter ..");
                System.exit(0);
                break;
        }
        }
        
        

        
        
    }    
}
