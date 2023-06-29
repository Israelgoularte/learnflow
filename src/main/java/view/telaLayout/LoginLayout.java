package view.telaLayout;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.components.ComponentsAbstractFactory;
import view.components.buttonAction.MudarPaginaAction;
import view.components.buttonAction.LoginAction;

public class LoginLayout extends DefaultLayout {

    /**
     * Cria o conteúdo principal da tela de login.
     *
     * @return O elemento pai do conteúdo principal.
     */
    @Override
    public Parent createMain() {
        Label lbltituloPagina = ComponentsAbstractFactory.factory.createLabel("primary", "Efetue o Login");
        Label lblemail = ComponentsAbstractFactory.factory.createLabel("secondary", "Email:");
        TextField fieldEmail = ComponentsAbstractFactory.factory.createTextField("email");
        Label lblsenha = ComponentsAbstractFactory.factory.createLabel("secondary", "Senha:");
        PasswordField fieldSenha = ComponentsAbstractFactory.factory.createPasswordField("senha");
        fieldSenha.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                new LoginAction(fieldEmail, fieldSenha).active();
            }
        });

        GridPane gridPane = ComponentsAbstractFactory.factory.createGridPane("default");

        gridPane.add(lblemail, 0, 0);
        gridPane.add(fieldEmail, 1, 0);
        gridPane.add(lblsenha, 0, 1);
        gridPane.add(fieldSenha, 1, 1);

        // Hbox com botões login e cadastrar-se
        Button btnLogin = ComponentsAbstractFactory.factory.createButton("primary", "Login");

        btnLogin.setOnAction(e -> {
            new LoginAction(fieldEmail, fieldSenha).active();
        });

        Button btnCadastro = ComponentsAbstractFactory.factory.createButton("secondary", "Cadastre-se");
        btnCadastro.setOnAction(e -> {
            new MudarPaginaAction("cadastro").active();
        });

        HBox hbxButtons = ComponentsAbstractFactory.factory.createHBox("default");
        hbxButtons.getChildren().addAll(btnLogin, btnCadastro);

        // Vbox com label, grid e hbox
        VBox vboxCentral = ComponentsAbstractFactory.factory.createVBox("main");
        vboxCentral.getChildren().addAll(lbltituloPagina, gridPane, hbxButtons);

        return vboxCentral;
    }

}
