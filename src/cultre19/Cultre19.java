/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cultre19;

import entities.Concours;
import java.util.Date;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import services.ConcoursService;

/**
 *
 * @author amine
 */
public class Cultre19 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Concours c =new Concours ("concours", "images", "description",new Date (),new Date ());
        ConcoursService cs=new ConcoursService();
        cs.ajouter(c);
        cs.supprimer(3);
        
        launch(args);
    }
    
}
