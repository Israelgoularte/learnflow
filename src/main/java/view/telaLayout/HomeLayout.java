package view.telaLayout;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import controller.FacadeController;
import view.components.ComponentsAbstractFactory;
import view.components.buttonAction.MudarPaginaAction;

public class HomeLayout extends DefaultLayout {

    /**
     * Cria o layout padrão da tela inicial.
     *
     * @return O painel raiz da tela inicial.
     */
    @Override
    public BorderPane createDefaultRoot() {
        VBox novoHeader = ComponentsAbstractFactory.factory.createVBox("header");
        novoHeader.getChildren().addAll(createHeader(), createNav());

        BorderPane root = ComponentsAbstractFactory.factory.createBorderPane("root");
        root.setTop(novoHeader);
        root.setCenter(createMain());
        root.setBottom(createFooter());
        return root;
    }

    /**
     * Cria o conteúdo principal da tela inicial.
     *
     * @return O elemento pai do conteúdo principal.
     */
    @Override
    public Parent createMain() {
        Label lblMenuAcesso = ComponentsAbstractFactory.factory.createLabel("primary", "Menu de Acesso");

        Button btnTema = ComponentsAbstractFactory.factory.createButton("primary", "Temas");
        btnTema.setOnAction(e -> new MudarPaginaAction("temas").active());

        Button btnLembretes = ComponentsAbstractFactory.factory.createButton("primary", "Lembretes");
        btnLembretes.setOnAction(e -> new MudarPaginaAction("lembretes").active());
        btnLembretes.setVisible(false);

        Button btnQuestionarios = ComponentsAbstractFactory.factory.createButton("primary", "Questionarios");
        btnQuestionarios.setOnAction(e -> new MudarPaginaAction("Questionarios").active());
        btnQuestionarios.setVisible(false);

        Button btnSair = ComponentsAbstractFactory.factory.createButton("primary", "Sair");
        btnSair.setOnAction(e -> {
            FacadeController.getInstance().logout();
            new MudarPaginaAction("login").active();
        });

        VBox vbox = ComponentsAbstractFactory.factory.createVBox("main");
        vbox.getChildren().addAll(lblMenuAcesso, btnTema, btnLembretes, btnQuestionarios, btnSair);

        return vbox;
    }
}
