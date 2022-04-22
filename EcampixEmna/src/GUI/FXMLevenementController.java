/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.Evenement;
import entity.Ticket;
import java.net.URL;
import java.sql.Date;

import java.time.ZoneId;

import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.ServiceEvenement;
import service.ServiceTicket;
import java.time.LocalDate;

/**
 * FXML Controller class
 *

 */
public class FXMLevenementController implements Initializable {

    @FXML
    private TextField tftype;
    @FXML
    private TableView<Evenement> tableview;
    @FXML
    private TableColumn<Evenement, Integer> columnid;
    @FXML
    private TableColumn<Evenement, String> columntype;
    @FXML
    private TableColumn<Evenement, String> columnlieu;
    @FXML
    private TableColumn<Evenement, Date> columndatedebut;
    @FXML
    private TableColumn<Evenement, Date> columndatefin;
    @FXML
    private TextField tflieu;
    @FXML
    private DatePicker dpdatedebut;
    @FXML
    private DatePicker dpdatefin;
    @FXML
    private TextField tfrecherche;
    ServiceEvenement se=new ServiceEvenement();
    ObservableList<Evenement> data=FXCollections.observableArrayList();
    @FXML
    private AnchorPane anchore;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refresh();
    }    public void fillData(){
        
        Evenement e=tableview.getSelectionModel().getSelectedItem();
        if(e!=null){
            tftype.setText(e.getType());
            tflieu.setText(e.getLieu());
            dpdatedebut.setValue(e.getDate_debut().toLocalDate());
           dpdatefin.setValue(e.getDate_fin().toLocalDate() );
            
        }
            
    }
        
        
    

           
    

   
public String controleDeSaisie(){
        String erreur="";
        if(tftype.getText().trim().isEmpty()){
            erreur+="-Remplire le champ numero\n";
        }
        if(tflieu.getText().trim().isEmpty()){
            erreur+="-Remplire le champ nombre\n";
        }
        
        
        if(dpdatedebut.getValue()==null){
            erreur+="-Remplire le champ date debut\n";
        }
        if(dpdatefin.getValue()==null){
            erreur+="-Remplire le champ date fin\n";
        }
        
        return erreur;
    }
    @FXML
    private void modifier(ActionEvent event) {
        int idmodif=tableview.getSelectionModel().getSelectedItem().getId();
        if(controleDeSaisie().length()>0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur ajout evenement");
            alert.setContentText(controleDeSaisie());
            alert.showAndWait();
        }
        else{
            Evenement e=new Evenement(
                    tftype.getText(),
                    java.sql.Date.valueOf(dpdatedebut.getValue()),
                    java.sql.Date.valueOf(dpdatefin.getValue()),
                    tflieu.getText()
                
                        );
                
                
        se.modifier(e,idmodif);
        refresh();
        }
        
    }

    @FXML
    private void ajouter(ActionEvent event) {
        if(controleDeSaisie().length()>0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur ajout evenemnt");
            alert.setContentText(controleDeSaisie());
            alert.showAndWait();
        }
        else{
            
                Evenement e =new Evenement(
                    tftype.getText(),
                    
                
                Date.valueOf(dpdatedebut.getValue()), 
                Date.valueOf(dpdatefin.getValue()),
                        tflieu.getText()
            );
            se.ajouter(e);
            refresh();
        }
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
        int idsupp=tableview.getSelectionModel().getSelectedItem().getId();
        Stage stage=(Stage) anchore.getScene().getWindow();
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Voules vouz vraiment supprimer?");
        alert.setTitle("Confirmation supprission");
        Optional<ButtonType> result=alert.showAndWait();
        if(result.get()==ButtonType.OK){
            se.supprimer(idsupp);
            refresh();
        }
        
    }
    
    

    
    public void refresh(){
        data.clear();
        data=FXCollections.observableArrayList(se.afficher());
        columnid.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnlieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        columntype.setCellValueFactory(new PropertyValueFactory<>("type"));
        columndatedebut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        columndatefin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        tableview.setItems(data);
    }
    
}
