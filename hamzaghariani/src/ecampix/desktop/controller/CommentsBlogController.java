/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecampix.desktop.controller;

import ecampix.desktop.model.Comment;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class CommentsBlogController implements Initializable {

    @FXML
    private Label nomUtComment;
    @FXML
    private Label cmntComment;
    @FXML
    private Label dateComment;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setComments(Comment c){
        nomUtComment.setText(c.getNom_ut_comment());
        cmntComment.setText(c.getCmnt());
        dateComment.setText(c.getDate_comment());
    }

    
    
}
