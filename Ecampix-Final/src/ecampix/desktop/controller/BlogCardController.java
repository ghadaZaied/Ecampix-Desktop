/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecampix.desktop.controller;

import ecampix.desktop.model.Blog;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class BlogCardController implements Initializable {

    @FXML
    private Label cardBlogTitle;
    @FXML
    private Label cardBlogDesc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void setBlog(Blog b){
        cardBlogTitle.setText(b.getTitre_blog());
        cardBlogDesc.setText(b.getDesc_blog());
    }
    
}
