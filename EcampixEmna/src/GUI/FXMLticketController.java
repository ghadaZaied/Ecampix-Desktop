/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.Evenement;
import entity.Ticket;
import java.net.URL;

import java.time.ZoneId;
import java.sql.Date;
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

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLticketController implements Initializable {

    @FXML
    private TextField tfnumero;
    @FXML
    private TextField tfnombre;
    @FXML
    private TextField tfdestination;
    @FXML
    private DatePicker dpDate;
    @FXML
    private TableView<Ticket> tableview;
    @FXML
    private TableColumn<Ticket, Integer> tcid;
    @FXML
    private TableColumn<Ticket, Integer> tcnumero;
    @FXML
    private TableColumn<Ticket, Integer> tcnombre;
    @FXML
    private TableColumn<Ticket, String> tcdestination;
    @FXML
    private TableColumn<Ticket, Integer> tcevenement;
    @FXML
    private TableColumn<Ticket, Date> tcdate;
    @FXML
    private ComboBox<Integer> cbevent;
    ServiceEvenement se=new ServiceEvenement();
    ServiceTicket st=new ServiceTicket();
    ObservableList<Ticket> data=FXCollections.observableArrayList();
    ObservableList<Integer> eventid=FXCollections.observableArrayList(se.getEventId());
    @FXML
    private AnchorPane anchore;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbevent.setItems(eventid);
        
        refresh();
    }    
    @FXML
    public void fillData(){
        
        Ticket t=tableview.getSelectionModel().getSelectedItem();
        if(t!=null){
            tfnumero.setText(String.valueOf(t.getNumero()));
            tfnombre.setText(String.valueOf(t.getNombre()));
            tfdestination.setText(t.getDestination());
            cbevent.setValue(t.getId_evenement());

            dpDate.setValue(t.getDate().toLocalDate());
        
        }
        
    }
    public String controleDeSaisie(){
        String erreur="";
        if(tfnumero.getText().trim().isEmpty()){
            erreur+="-Remplire le champ numero\n";
        }
        if(tfnombre.getText().trim().isEmpty()){
            erreur+="-Remplire le champ nombre\n";
        }
        if(tfdestination.getText().trim().isEmpty()){
            erreur+="-Remplire le champ distination\n";
        }
        
        if(dpDate.getValue()==null){
            erreur+="-Remplire le champ date\n";
        }
        if(cbevent.getValue()==null){
            erreur+="-Remplire le champ evenement\n";
        }
        if(!tfnombre.getText().trim().matches("[0-9]+")){
            erreur+="-Ecrire un nombre correcte\n";
        }
        if(!tfnumero.getText().trim().matches("[0-9]+")){
            erreur+="-Ecrire un numero correcte\n";
        }
        return erreur;
    }
    @FXML
    private void modifier(ActionEvent event) {
        int idmodif=tableview.getSelectionModel().getSelectedItem().getId();
        if(controleDeSaisie().length()>0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur ajout ticket");
            alert.setContentText(controleDeSaisie());
            alert.showAndWait();
        }
        else{
            Ticket t=new Ticket(
                Integer.parseInt(tfnumero.getText()),
                Integer.parseInt(tfnombre.getText()),
                tfdestination.getText(),
                java.sql.Date.valueOf(dpDate.getValue()), 
                java.sql.Date.valueOf(dpDate.getValue()),
                cbevent.getValue()
        );
        st.modifier(t,idmodif);
        refresh();
        }
        
    }

    @FXML
    private void ajouter(ActionEvent event) {
        if(controleDeSaisie().length()>0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur ajout ticket");
            alert.setContentText(controleDeSaisie());
            alert.showAndWait();
        }
        else{
            Ticket t=new Ticket(
                Integer.parseInt(tfnumero.getText()),
                Integer.parseInt(tfnombre.getText()),
                tfdestination.getText(),
                Date.valueOf(dpDate.getValue()), 
                Date.valueOf(dpDate.getValue()),
                cbevent.getValue()
            );
            st.ajouter(t);
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
            st.supprimer(idsupp);
            refresh();
        }
        
    }
    public void refresh(){
        
        data.clear();
        data=FXCollections.observableArrayList(st.afficher());
        tcid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcdestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        tcevenement.setCellValueFactory(new PropertyValueFactory<>("id_evenement"));
        tcnombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcnumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        tableview.setItems(data);
    }
}
