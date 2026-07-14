/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.geraldcalderon.system;
import javafx.application.Application;
import javafx.stage.Stage;
import com.geraldcalderon.controller.SceneManager;
/**
 *
 * @author informatica
 */
public class ClasePrincipal extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override 
    public void start(Stage escenarioRaiz){
        SceneManager.getInstanciaSceneManager().setEscenarioPrincipal(escenarioRaiz);
        SceneManager.getInstanciaSceneManager().ventanaLogin();
        
    }
    
}
