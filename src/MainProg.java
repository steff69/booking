/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainProg  extends Application {

    @Override
  public void start(Stage primaryStage) throws Exception {
        
            Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/GUI/chambre.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Accueil Booking");
             //   primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setScene(scene);
        primaryStage.show();
       primaryStage.setResizable(true);
    }
    
  public static void main(String[] args) {
      launch(args);
     }
    
}
