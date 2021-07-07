/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import tn.esprit.mustfa.Services.ServiceChambre;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.esprit.mustfa.Models.Chambre;










public class AdminChamberController implements Initializable {

    ServiceChambre serviceChambre = new ServiceChambre();
    
    @FXML
    private TextField tf_recherche;
    @FXML
    private TableView<Chambre> tableView;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private TableColumn<?, ?> hotel_id;
    @FXML
    private TableColumn<?, ?> type_chambre;
    @FXML
    private TableColumn<?, ?> vue;
    @FXML
    private TableColumn<?, ?> etage;
    @FXML
    private TableColumn<?, ?> prix;
    @FXML
    private TableColumn<?, ?> fk_chambre_hotel;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TextField idT;
    @FXML
    private TextField nomT;
    @FXML
    private TextField descriptionT;
    @FXML
    private TextField hotelT;
    @FXML
    private TextField typeT;
    @FXML
    private TextField vueT;
    @FXML
    private TextField etageT;
    @FXML
    private TextField prixT;
    @FXML
    private TextField fkT;
    @FXML
    private Button btnAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


ChargerChambre();




        ServiceChambre ser = new ServiceChambre();
        ArrayList<Chambre> liste = (ArrayList<Chambre>) ser.afficherChambres();
        ObservableList observableList = FXCollections.observableArrayList(liste);
       tableView.setItems(observableList);     // search.setVisible(false);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         description.setCellValueFactory(new PropertyValueFactory<>("description"));
        hotel_id.setCellValueFactory(new PropertyValueFactory<>("hotel_id"));
        type_chambre.setCellValueFactory(new PropertyValueFactory<>("type_chambre"));
        vue.setCellValueFactory(new PropertyValueFactory<>("vue"));
        etage.setCellValueFactory(new PropertyValueFactory<>("etage"));
       prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
      fk_chambre_hotel.setCellValueFactory(new PropertyValueFactory<>("fk_chambre_hotel"));

    


 
 
 
  btnSupprimer .setOnMouseClicked(x -> {
 Chambre cat = new Chambre();
cat = (Chambre) tableView.getSelectionModel().getSelectedItem();

        if (cat== null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Alerte");
            alert.setContentText("Il faut tout d'abord sélectionner une Chambre");
            alert.show();
        } else {

            // get Selected Item
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes vous sure de vouloir supprimer cette Chambre?", ButtonType.YES, ButtonType.NO, null);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                //remove selected item from the table list
                serviceChambre.supprimerChambre(cat);
                //bonplanService.SupprimerCategorie(cat);
                 tableView.getItems().clear();
        
            tableView.getItems().addAll(serviceChambre.afficherChambres());
            ChargerChambre();
            }
        }
        });

 
 
 
        

    }    

    @FXML
    private void SearchByName(ActionEvent event) {
        ServiceChambre bs = new ServiceChambre();
        ArrayList AL = (ArrayList) bs.afficherChambres();
        ObservableList OReservation = FXCollections.observableArrayList(AL);
        FilteredList<Chambre> filtred_c = new FilteredList<>(OReservation, e -> true);
        tf_recherche.setOnKeyReleased(e -> {
            tf_recherche.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filtred_c.setPredicate((Predicate<? super Chambre>) p -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                  //  String toLowerCaseNewValue = newValue.toLowerCase();
                    if ((p.getNom_chambre().contains(newValue)) ) {
                        return true;

                    }

                    return false;
                });
            });
        });
        tableView.setItems(filtred_c);

    }


    @FXML
    private void addChambre(ActionEvent event) throws SQLException {
    
      Chambre l = new Chambre( Integer.valueOf(idT.getText()),nomT.getText()
                    , descriptionT.getText(),Integer.valueOf(hotelT.getText()),typeT.getText() , vueT.getText(),Integer.valueOf(etageT.getText()),Integer.valueOf(prixT.getText()), Integer.valueOf(fkT.getText()));
            serviceChambre.ajouterChambre(l);
            
            
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nouvelle Chambre");
            alert.setHeaderText(null);
            alert.setContentText("Chambre  ajouté !!  ");
            alert.showAndWait();
        ChargerChambre();
    }
    
    
    
     public void ChargerChambre() {
        
        ServiceChambre serviceChambre = new ServiceChambre();
        ArrayList<Chambre> listeChambre = (ArrayList<Chambre>) serviceChambre.afficherChambres();

        ObservableList observableList = FXCollections.observableArrayList(listeChambre);
        tableView.setItems(observableList);

    }
    
    
    
}
