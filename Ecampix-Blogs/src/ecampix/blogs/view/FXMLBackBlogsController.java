/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecampix.blogs.view;

import ecampix.blogs.controller.BlogController;
import ecampix.blogs.model.Blog;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class FXMLBackBlogsController implements Initializable {

    @FXML
    private AnchorPane blogAnchorPane;    
    @FXML
    private TableView<Blog> tabBlogs;
    @FXML
    private TableColumn<Blog, String> dateClmn;
    @FXML
    private TableColumn<Blog, String> nomUtClmn;
    @FXML
    private TableColumn<Blog, String> titreClmn;
    @FXML
    private TableColumn<Blog, String> descrClmn;
    @FXML
    private TableColumn<Blog, String> imgClmn;
    @FXML
    private TableColumn<Blog, Integer> idBlogClmn;
    @FXML
    private Button ajbtn;
    @FXML
    private Button modbtn;
    @FXML
    private Button suppbtn;
    @FXML
    private TextField nomUtf;
    @FXML
    private TextField titref;
    @FXML
    private TextField descf;
    @FXML
    private TextField imgf;
    @FXML
    private TextField idB;
    @FXML
    private Button goCmnt;


    @FXML
    private void handleButtonAction(ActionEvent event){
        if(event.getSource() == modbtn){
            BlogController bc = new BlogController();
            Blog b = makeBlog(true);
             if(validator() && confirmation()){
            bc.modifyBlog(makeBlog(true));
            refreshData();
             }
        }
        else if(event.getSource() == ajbtn){
           BlogController bc = new BlogController();
           Blog b = makeBlog(false);
           if(validator()){
           bc.addBlog(b);
           refreshData();}
        }
        else if(event.getSource() == suppbtn){
            BlogController bc = new BlogController();
            if(confirmation()){
            bc.deleteBlog((int)Float.parseFloat(idB.getText()));}
            refreshData();
            clearInputs();
        }
        else if(event.getSource() == goCmnt){
            try {
                AnchorPane commentPane = FXMLLoader.load(getClass().getResource("FXMLBackComments.fxml"));
                blogAnchorPane.getChildren().setAll(commentPane);
            } catch (IOException ex) {
                System.out.print("Probleme lors de changer la fenetre.");
            }
        }
    }
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showBlogs();
        idB.setVisible(false);
        tabBlogs.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1){
            onSelectedRow();
            }
       
        });
    }
    
    public void showBlogs(){
        BlogController bc = new BlogController();
        ObservableList<Blog> blogs = bc.getBlogs();
        idBlogClmn.setCellValueFactory(new PropertyValueFactory<Blog, Integer>("idBlog"));
        idBlogClmn.setVisible(false); // ;)
        dateClmn.setCellValueFactory(new PropertyValueFactory<Blog, String>("date_blog"));
        nomUtClmn.setCellValueFactory(new PropertyValueFactory<Blog, String>("nom_ut_blog"));
        titreClmn.setCellValueFactory(new PropertyValueFactory<Blog, String>("titre_blog"));
        descrClmn.setCellValueFactory(new PropertyValueFactory<Blog, String>("desc_blog"));
        imgClmn.setCellValueFactory(new PropertyValueFactory<Blog, String>("image_blog"));
        tabBlogs.setItems(blogs);
    }
    
    public void onSelectedRow(){
        if(tabBlogs.getSelectionModel().getSelectedItem() != null)
        { 
        Blog b = tabBlogs.getSelectionModel().getSelectedItem();    
        nomUtf.setText(b.getNom_ut_blog());
        titref.setText(b.getTitre_blog());
        descf.setText(b.getDesc_blog());
        imgf.setText(b.getImage_blog());
        idB.setText(String.valueOf(b.getIdBlog()));
        }
    }
    
    public Blog makeBlog(Boolean modify){
        Blog b = new Blog();
        LocalDate dateBlog = LocalDate.now();
        if(modify){
        b.setIdBlog((int)Float.parseFloat(idB.getText()));
        }
        b.setDate_blog(dateBlog.toString());
        b.setTitre_blog(titref.getText());
        b.setDesc_blog(descf.getText());
        b.setImage_blog(imgf.getText());
        b.setNom_ut_blog(nomUtf.getText());
        return b;
    }
    
    public void refreshData(){
        showBlogs();
    }
    
    public void clearInputs(){
        nomUtf.clear();
        titref.clear();
        descf.clear();
        imgf.clear();
        idB.clear();
    }
    
    public boolean validator(){
        if(nomUtf.getText().isEmpty()){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Controle de Saisie !");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez taper votre nom svp.");
            alert.showAndWait();
            return false;
        }
        else if(titref.getText().isEmpty()){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Controle de Saisie !");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez choisir un titre svp.");
            alert.showAndWait();
            return false;            
        }
        else if(descf.getText().isEmpty()){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Controle de Saisie !");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez choisir une description svp.");
            alert.showAndWait();
            return false;            
        }
        else if(imgf.getText().isEmpty()){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Controle de Saisie !");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez taper un lien d'image svp.");
            alert.showAndWait();
            return false;            
        }
        else if(imgf.getText().contains("http://") == false){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Controle de Saisie !");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez taper un lien d'image valide svp.");
            alert.showAndWait();
            return false;            
        }       
        else{
            return true;
        }
    }
    
    public boolean confirmation(){
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de Modification/Suppression");
            alert.setHeaderText(null);
            alert.setContentText("Voulez-vous vraiment supprimer ou mettre à jour cette ligne ?");
            Optional <ButtonType> action = alert.showAndWait();
            if(action.get() == ButtonType.OK)
                return true;
            else
                return false;
    }

}
