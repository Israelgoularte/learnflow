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
import view.components.buttonAction.AdicionarUsuarioAction;

public class CadastroLayout extends DefaultLayout {

    /**
     * Cria o conteúdo principal do layout de cadastro.
     *
     * @return o nó raiz do conteúdo principal do layout de cadastro
     */
    @Override
    public Parent createMain() {
        Label lbltitulo = ComponentsAbstractFactory.factory.createLabel("primary", "Cadastre-se");

        Label lblEmail = ComponentsAbstractFactory.factory.createLabel("secondary", "Email");
        TextField txtEmail = ComponentsAbstractFactory.factory.createTextField("secondary");
        Label lblNome = ComponentsAbstractFactory.factory.createLabel("secondary", "Nome:");
        TextField txtNome = ComponentsAbstractFactory.factory.createTextField("secondary");

        Label lblSenha = ComponentsAbstractFactory.factory.createLabel("secondary", "Senha:");
        PasswordField txtSenha = ComponentsAbstractFactory.factory.createPasswordField("secondary");

        Label lblConfirmarSenha = ComponentsAbstractFactory.factory.createLabel("secondary", "Confirmar Senha:");
        PasswordField txtConfirmarSenha = new PasswordField();
        txtConfirmarSenha.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                new AdicionarUsuarioAction(txtSenha, txtConfirmarSenha, txtEmail, txtNome).active();
            }
        });

        GridPane cadastroGridPane = ComponentsAbstractFactory.factory.createGridPane("secondary");
        cadastroGridPane.addRow(0, lblEmail, txtEmail);
        cadastroGridPane.addRow(1, lblNome, txtNome);
        cadastroGridPane.addRow(2, lblSenha, txtSenha);
        cadastroGridPane.addRow(3, lblConfirmarSenha, txtConfirmarSenha);

        Button btnCadastrar = ComponentsAbstractFactory.factory.createButton("primary", "Cadastrar");
        btnCadastrar.setOnAction(e -> {
            new AdicionarUsuarioAction(txtSenha, txtConfirmarSenha, txtEmail, txtNome).active();
        });

        // Button para voltar à tela de login sem fazer cadastro.
        Button btnVoltar = ComponentsAbstractFactory.factory.createButton("secondary", "Voltar");
        btnVoltar.setOnAction(e -> {
            new MudarPaginaAction("login").active();
        });

        HBox hboxButton = ComponentsAbstractFactory.factory.createHBox("secondary");
        hboxButton.getChildren().addAll(btnCadastrar, btnVoltar);

        // VBox para agrupar todos os elementos

        VBox vboxMain = ComponentsAbstractFactory.factory.createVBox("main");
        vboxMain.getChildren().addAll(lbltitulo, cadastroGridPane, hboxButton);

        return vboxMain;
    }
}
