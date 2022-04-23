/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecampix.desktop.controller;

import ecampix.desktop.model.Blog;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FrontEcampixController implements Initializable {

    @FXML
    private Button blogsBtn;
    @FXML
    private Button adminBtn;
    @FXML
    private GridPane blogsContainer;
    private List<Blog> blogs;
    @FXML
    private AnchorPane sideBarAnchorPane;
    @FXML
    private AnchorPane blogsAnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        blogs = new ArrayList<>(testingBlogs());
        int column = 0;
        int row = 1;
        System.out.print(blogs.size());
        try {
            for(Blog blog : blogs){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("blogCard.fxml"));
            Pane cardBlog = fxmlLoader.load();
            BlogCardController bcc = fxmlLoader.getController();
            bcc.setBlog(blog);
            
            if(column == 2){
                column = 0;
                ++row;
            }
            blogsContainer.add(cardBlog,column++,row);
            GridPane.setMargin(cardBlog, new Insets(4));
            }
        } catch (IOException ex) {
            System.out.print("Probleme lors de chargement de CARD BLOG !");
        }
    } 
    
    public List<Blog> testingBlogs(){
        Blog b1 = new Blog("20-2-2022","Hamza Ghariani","Titre 1","Description 1","image 1");
        Blog b2 = new Blog("20-2-2022","Hamza Ghariani","Titre 1","Description 1","image 1");
        Blog b3 = new Blog("20-2-2022","Hamza Ghariani","Titre 1","Description 1","image 1");
        Blog b4 = new Blog("20-2-2022","Hamza Ghariani","Titre 1","Description 1","image 1");
        Blog b5 = new Blog("20-2-2022","Hamza Ghariani","Titre 1","Description 1","image 1");
        Blog b6 = new Blog("20-2-2022","Hamza Ghariani","Titre 1","Description 1","image 1");
        Blog b7 = new Blog("20-2-2022","Hamza Ghariani","Titre 1","Description 1","image 1");
        Blog b8 = new Blog("20-2-2022","Hamza Ghariani","Titre 1","Description 1","image 1");
        Blog b9 = new Blog("20-2-2022","Hamza Ghariani","Titre 1","Description 1","image 1");
        List<Blog> blogs = new ArrayList<>();
        blogs.add(b1);
        blogs.add(b2);
        blogs.add(b3);
        blogs.add(b4);
        blogs.add(b5);
        blogs.add(b6);
        blogs.add(b7);
        blogs.add(b8);
        blogs.add(b9);
        return blogs;
    }
    
}
