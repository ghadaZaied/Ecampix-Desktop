/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecampix.desktop.controller;

import ecampix.desktop.model.Blog;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
    @FXML
    private ImageView imgBlog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void setBlog(Blog b) throws IOException{
        cardBlogTitle.setText(b.getTitre_blog());
        cardBlogDesc.setText(b.getDesc_blog());
        // URL url = new URL("https://media.sproutsocial.com/uploads/2017/02/10x-featured-social-media-image-size.png");
        Image image = new Image("https://media.sproutsocial.com/uploads/2017/02/10x-featured-social-media-image-size.png");
        imgBlog.setImage(image);
    }

    @FXML
    private void getSingleBlog(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/ecampix/desktop/view/SingleBlog.fxml"));
            Pane cardBlog = fxmlLoader.load();
            SingleBlogController sbc = fxmlLoader.getController();
            Blog b = new Blog();
            b.setTitre_blog(cardBlogTitle.getText());
            b.setDesc_blog(cardBlogDesc.getText());
            b.setNom_ut_blog("Hamza Ghariani");
           // b.setDate_blog(date_blog);
            b.setImage_blog("https://media.sproutsocial.com/uploads/2017/02/10x-featured-social-media-image-size.png");
            sbc.setBlog(b);
            Stage stage = new Stage();
            stage.setScene(new Scene(cardBlog));  
            stage.show();
    }
    
    public Blog getBlog(){
        Blog b = new Blog();
        b.setTitre_blog(cardBlogTitle.getText());
        b.setDesc_blog(cardBlogDesc.getText());
        b.setImage_blog("https://media.sproutsocial.com/uploads/2017/02/10x-featured-social-media-image-size.png");
        return b;
    }
    
    
}
