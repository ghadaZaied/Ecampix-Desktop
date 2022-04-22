/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecampix.blogs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author MSI
 */
public class EcampixBlogs extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/FXMLBackBlogs.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(" ~ Ecampix Gestion des Blogs et Commentaires ~");
        Image ico = new Image("file:C:/Users/MSI/Documents/NetBeansProjects/Ecampix-Blogs/src/ecampix/blogs/resources/Logo.png");
        stage.getIcons().add(ico);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
