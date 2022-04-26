/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecampix.desktop.controller;

import ecampix.desktop.model.Blog;
import ecampix.desktop.model.Comment;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class SingleBlogController implements Initializable {

    @FXML
    private ImageView imgBlog;
    @FXML
    private Label titreBlog;
    @FXML
    private Label descBlog;
    @FXML
    private GridPane commentsGrid;
    private List<Comment> comments;
    @FXML
    private Label nomUtBlog;
    @FXML
    private Label dateBlog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CommentController cc = new CommentController();
        comments = new ArrayList<>(/*c.getComments()*/testingComments());
        int column = 0;
        int row = 1;
        try {
            for(Comment comment : comments){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/ecampix/desktop/view/CommentsBlog.fxml"));
            Pane cardBlog = fxmlLoader.load();
            CommentsBlogController cbc = fxmlLoader.getController();
            cbc.setComments(comment);
            
            if(column == 2){
                column = 0;
                ++row;
            }
            commentsGrid.add(cardBlog,column++,row);
            GridPane.setMargin(cardBlog, new Insets(3));
            }
        } catch (IOException ex) {
            System.out.print("Probleme lors de chargement de CARD BLOG !");
        }        
        
    }  
    
    public void setBlog(Blog b) throws IOException{
        titreBlog.setText(b.getTitre_blog());
        descBlog.setText(b.getDesc_blog());
        // URL url = new URL("https://media.sproutsocial.com/uploads/2017/02/10x-featured-social-media-image-size.png");
        Image image = new Image("https://media.sproutsocial.com/uploads/2017/02/10x-featured-social-media-image-size.png");
        imgBlog.setImage(image);   
        nomUtBlog.setText(b.getNom_ut_blog());
        dateBlog.setText(b.getDate_blog());
        System.out.print(b.getDate_blog());
    }
    
    
    public List<Comment> testingComments(){
        Comment c1 = new Comment();
        c1.setCmnt("Merci pour cet Article.");
        c1.setDate_comment("26-4-2022");
        c1.setNom_ut_comment("Hamza Ghariani");
        
        Comment c2 = new Comment();
        c2.setCmnt("Merci pour cet Article.");
        c2.setDate_comment("26-4-2022");
        c2.setNom_ut_comment("Hamza Ghariani");
        
        
        Comment c3 = new Comment();
        c3.setCmnt("Merci pour cet Article.");
        c3.setDate_comment("26-4-2022");
        c3.setNom_ut_comment("Hamza Ghariani");
        
        
        Comment c4 = new Comment();
        c4.setCmnt("Merci pour cet Article.");
        c4.setDate_comment("26-4-2022");
        c4.setNom_ut_comment("Hamza Ghariani");
        
        Comment c5 = new Comment();
        c5.setCmnt("Merci pour cet Article.");
        c5.setDate_comment("26-4-2022");
        c5.setNom_ut_comment("Hamza Ghariani");
        
        
        Comment c6 = new Comment();
        c6.setCmnt("Merci pour cet Article.");
        c6.setDate_comment("26-4-2022");
        c6.setNom_ut_comment("Hamza Ghariani");
        
        List<Comment> comments = new ArrayList<>();        
        comments.add(c1);
        comments.add(c2);
        comments.add(c3);
        comments.add(c4);
        comments.add(c5);
        comments.add(c6);    
        
        return comments;
    }
    
}
