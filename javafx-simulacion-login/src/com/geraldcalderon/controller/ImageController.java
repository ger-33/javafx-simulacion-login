package com.geraldcalderon.controller;

import javafx.scene.image.Image;

public class ImageController {

    public Image getImageLogin(String nombreImagen) {

        switch(nombreImagen){

            case "logo":
                System.out.println(getClass().getResource("/com/geraldcalderon/resources/fotoperfil.png"));
                return new Image(getClass().getResourceAsStream(
                        "/com/geraldcalderon/resources/fotoperfil.png"));

            default:
                return new Image(getClass().getResourceAsStream(
                        "/com/geraldcalderon/resources/fotoperfil.png"));
        }

    }

}