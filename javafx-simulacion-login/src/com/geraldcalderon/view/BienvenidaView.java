package com.geraldcalderon.view;

import com.geraldcalderon.controller.ImageController;
import com.geraldcalderon.model.Usuario;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BienvenidaView extends BorderPane {

    private static BienvenidaView instanciaBienvenidaView;

    private HBox barraVentana;
    private Button btnCerrar;
    private Label lblTitulo;

    private ImageView imgLogo;
    private Label lblBienvenido;
    private Label lblNombre;
    private Label lblRol;

    private Button btnSalir;

    private VBox cajaVertical;

    private final String RUTA_ESTILOS = "/com/geraldcalderon/styles/";

    private BienvenidaView(Usuario usuario) {

        this.getStylesheets().add(RUTA_ESTILOS + "loginStyles.css");

        this.setPadding(new Insets(20));

        this.setBorder(new Border(new BorderStroke(
                Color.DARKSALMON,
                BorderStrokeStyle.SOLID,
                new CornerRadii(25),
                new BorderWidths(2))));

        this.setStyle(
                "-fx-background-color: linear-gradient(from 0% 50% to 100% 50%,"
                + "#020024 0%,"
                + "#090979 0%,"
                + "#00d4ff 100%);"
                + "-fx-background-radius:25;"
        );

        barraVentana = new HBox();

        btnCerrar = new Button("X");
        lblTitulo = new Label("BIENVENIDO");

        barraVentana.setAlignment(Pos.CENTER_LEFT);
        barraVentana.getChildren().addAll(btnCerrar, lblTitulo);

        this.setTop(barraVentana);

        imgLogo = new ImageView(new ImageController().getImageLogin("logo"));
        imgLogo.setFitWidth(120);
        imgLogo.setFitHeight(120);

        lblBienvenido = new Label("¡Bienvenido!");
        lblBienvenido.setFont(new Font(24));
        lblBienvenido.setTextFill(Color.WHITE);

        lblNombre = new Label(usuario.getNombreCompleto());
        lblNombre.setFont(new Font(22));
        lblNombre.setTextFill(Color.WHITE);

        lblRol = new Label("Rol: " + usuario.getRol());
        Label lblMensaje = new Label("Inicio de sesión exitoso");
        lblMensaje.setTextFill(Color.WHITE);
        lblMensaje.setFont(new Font(14));
        lblRol.setFont(new Font(16));
        lblRol.setTextFill(Color.WHITE);

        btnSalir = new Button("Cerrar Sesión");

        cajaVertical = new VBox(15);

        cajaVertical.setAlignment(Pos.CENTER);

        cajaVertical.getChildren().addAll(
                imgLogo,
                lblBienvenido,
                lblNombre,
                lblRol,
                lblMensaje,
                btnSalir
        );

        this.setCenter(cajaVertical);

        btnCerrar.setOnAction(e -> System.exit(0));

        btnSalir.setOnAction(e -> System.exit(0));

    }

    public static BienvenidaView getInstanciaBienvenida(Usuario usuario) {

        if (instanciaBienvenidaView == null) {
            instanciaBienvenidaView = new BienvenidaView(usuario);
        }

        return instanciaBienvenidaView;
    }
}
