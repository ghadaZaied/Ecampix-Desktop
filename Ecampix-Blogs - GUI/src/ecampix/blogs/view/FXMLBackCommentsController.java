/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecampix.blogs.view;

import ecampix.blogs.controller.BlogController;
import ecampix.blogs.controller.CommentController;
import ecampix.blogs.model.Comment;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FXMLBackCommentsController implements Initializable {

    @FXML
    private TextField nomUtf;
    @FXML
    private TextArea comntf;
    @FXML
    private TableView<Comment> tabComment;
    @FXML
    private TableColumn<Comment, Integer> idCmntC;
    @FXML
    private TableColumn<Comment, Integer> idBlogC;
    @FXML
    private TableColumn<Comment, String> DateCmntC;
    @FXML
    private TableColumn<Comment, String> utilisateurC;
    @FXML
    private TableColumn<Comment, String> ComntC;
    @FXML
    private Button ajbtn;
    @FXML
    private Button modbtn;
    @FXML
    private Button suppbtn;
    @FXML
    private TextField idC;
    @FXML
    private Button goBlogs;
    @FXML
    private AnchorPane CommentAnchorPane;
    @FXML
    private ChoiceBox<String> titreBlogList;
    @FXML
    private TextField idBlogS;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showComments();
        idC.setVisible(false);
        idBlogS.setVisible(false);
        tabComment.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1){
            onSelectedRow();
            }
       
        });
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == modbtn){
            CommentController cc = new CommentController();
            Comment c = makeComment(true);
            if(validator() && confirmation()){
                cc.modifyComment(c);
                refreshData();
            }
            else{
              clearInputs();  
              refreshData();
            }
            
        }
        else if(event.getSource() == suppbtn){
            CommentController cc = new CommentController();
            if(confirmation()){
                cc.deleteComment((int)Float.parseFloat(idC.getText()));
                refreshData();
                clearInputs();
            }
        }
        else if(event.getSource() == ajbtn){
            CommentController cc = new CommentController();
            if(validator()){
                Comment c = makeComment(false);
                cc.addComment(c);
                refreshData();
                clearInputs();
            }
        }
        else if(event.getSource() == goBlogs){
            try {
                AnchorPane commentPane = FXMLLoader.load(getClass().getResource("FXMLBackBlogs.fxml"));
                CommentAnchorPane.getChildren().setAll(commentPane);
            } catch (IOException ex) {
                System.out.print("Probleme lors de changer la fenetre.");
            }            
        }
    }
    
    public void showComments(){
        CommentController cc = new CommentController();
        ObservableList<Comment> comments = cc.getComments();
        idCmntC.setCellValueFactory(new PropertyValueFactory<Comment, Integer>("idComment"));
        idCmntC.setVisible(false); // kel3ada ;)
        idBlogC.setCellValueFactory(new PropertyValueFactory<Comment, Integer>("id_blog"));
        DateCmntC.setCellValueFactory(new PropertyValueFactory<Comment, String>("date_comment"));
        utilisateurC.setCellValueFactory(new PropertyValueFactory<Comment, String>("nom_ut_comment"));
        ComntC.setCellValueFactory(new PropertyValueFactory<Comment, String>("cmnt"));
        tabComment.setItems(comments);
        BlogController bc = new BlogController();
        titreBlogList.setItems(bc.getTitles());
        titreBlogList.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            idBlogS.setText(String.valueOf(bc.findIdBlogByTitle(titreBlogList.getValue())));
        }); 
    }
    public void onSelectedRow(){
        if(tabComment.getSelectionModel().getSelectedItem() != null)
        { 
        Comment c = tabComment.getSelectionModel().getSelectedItem();    
        nomUtf.setText(c.getNom_ut_comment());
        comntf.setText(c.getCmnt());
        idC.setText(String.valueOf(c.getIdComment()));
        }
    } 
    
    public void refreshData(){
        showComments();
    }
    
    public boolean validator(){
    if(nomUtf.getText().isEmpty())
    {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Controle de Saisie !");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez taper votre nom svp.");
            alert.showAndWait();
            return false;    
    }
    else if(comntf.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Controle de Saisie !");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez ecrire un commentaire svp.");
            alert.showAndWait();
            return false;         
    }
    else if(badWords(comntf.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Controle de Saisie !");
            alert.setHeaderText(null);
            alert.setContentText("Votre commentaire contient mot inapproprie.");
            alert.showAndWait();
            return false;           
    }
    else if(titreBlogList.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Controle de Saisie !");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez choisir un article svp.");
            alert.showAndWait();
            return false;           
    }
    else{
        return true;
    }
    }
    
    public boolean confirmation(){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de Modification/Suppression");
            alert.setHeaderText(null);
            alert.setContentText("Voulez-vous vraiment supprimer ou mettre à jour cette ligne ?");
            Optional <ButtonType> action = alert.showAndWait();
            if(action.get() == ButtonType.OK)
                return true;
            else
                return false;
    }    
    
    public boolean badWords(String comment){
        List<String> BadWords=new ArrayList<String>();
        BadWords.add("bad");
        BadWords.add("word");
        boolean isBad = false ;
        for(String l : BadWords){
            if(comment.contains(l) == true)
                isBad = true;
        }
        
        return isBad;
    }
    
    
    
    public Comment makeComment(boolean modifier){
        Comment c = new Comment();
        LocalDate dateComment = LocalDate.now();
        c.setDate_comment(dateComment.toString());
        c.setNom_ut_comment(nomUtf.getText());
        c.setCmnt(comntf.getText());
        if(modifier)
            c.setIdComment((int)Float.parseFloat(idC.getText()));
        
        c.setId_blog((int)Float.parseFloat(idBlogS.getText()));
        return c;
    }
    
     public void clearInputs(){
        nomUtf.clear();
        comntf.clear();
    }   
}
