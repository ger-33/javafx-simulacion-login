
package com.geraldcalderon.controller;
 
import com.geraldcalderon.view.LoginView;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
 

/**
*
* @author informatica
*/
public class SceneManager {
    private static SceneManager instanciaSceneManager;
    private Stage escenarioPrincipal;
    private Stage escenarioSecundario;
    private Scene escenaPrincipal;
    private SceneManager() {
    }
    public void cambiarEcenaPrincipal(Pane panel, int ancho, int alto) {
        try {
            escenaPrincipal = new Scene(panel, ancho, alto);
            escenarioPrincipal.setScene(escenaPrincipal);
            escenarioPrincipal.sizeToScene();
            escenarioPrincipal.show();
        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: Ccambiar Escena Principald");
            objetoNulo.printStackTrace(); //imprime todo el camino hacia el error 
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error padre: Cambiar Escena Principal");
            errorPadre.printStackTrace();
        }
    }
    public void ventanaLogin() {
        try {
            //Metodo que oculta las opciones de ventana por defecto
            this.escenarioPrincipal.initStyle(StageStyle.TRANSPARENT);
            LoginView login = LoginView.getInstanciaLoginView();
            cambiarEcenaPrincipal(login, 450, 500);
            this.escenaPrincipal.setFill(Color.TRANSPARENT);//el fondo de la escena 
            new LoginController (login);
        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Error de objeto nulo: Ventana Login");
            objetoNulo.printStackTrace(); //imprime todo el camino hacia el error 
        } catch (Exception errorPadre) {
            JOptionPane.showMessageDialog(null, "Error padre: Ventana Login");
            errorPadre.printStackTrace();
        }
    }
    public static SceneManager getInstanciaSceneManager() {
        if (instanciaSceneManager == null) {
            instanciaSceneManager = new SceneManager();
        }
        return instanciaSceneManager;
    }
    public static void setInstanciaSceneManager(SceneManager instanciaSceneManager) {
        SceneManager.instanciaSceneManager = instanciaSceneManager;
    }
    public Stage getEscenarioPrincipal() {
        return escenarioPrincipal;
    }
    public void setEscenarioPrincipal(Stage escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    public Stage getEscenarioSecundario() {
        return escenarioSecundario;
    }
    public void setEscenarioSecundario(Stage escenarioSecundario) {
        this.escenarioSecundario = escenarioSecundario;
    }
    public Scene getEscenaPrincipal() {
        return escenaPrincipal;
    }
    public void setEscenaPrincipal(Scene escenaPrincipal) {
        this.escenaPrincipal = escenaPrincipal;
    }
}