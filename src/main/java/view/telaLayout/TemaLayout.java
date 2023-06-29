package view.telaLayout;

import java.util.LinkedList;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import controller.FacadeController;
import model.TemaModel;
import view.components.ComponentsAbstractFactory;
import view.components.buttonAction.MudarPaginaAction;
import view.components.buttonAction.AdicionarTemaAction;

public class TemaLayout extends HomeLayout {

    /**
     * Cria o conteúdo principal da tela de temas.
     *
     * @return O elemento pai do conteúdo principal.
     */
    @Override
    public Parent createMain() {

        Button btnVoltar = ComponentsAbstractFactory.factory.createButton("secondary", "Voltar");

        btnVoltar.setOnAction(e -> new MudarPaginaAction("home").active());

        Label lbltituloPagina = ComponentsAbstractFactory.factory.createLabel("tema_titulo", "Temas");

        HBox hboxTemas = ComponentsAbstractFactory.factory.createHBox("tema_list_box");

        createBotoesTemas(hboxTemas);

        // Cadastrar novo tema
        Label lblNomeNovoTema = ComponentsAbstractFactory.factory.createLabel("secondary", "Nome");

        TextField tfNomeNovoTema = ComponentsAbstractFactory.factory.createTextField("secondary");

        Button btnSalvarNovoTema = ComponentsAbstractFactory.factory.createButton("primary", "Salvar");

        Button btnCadastrarNovoTema = ComponentsAbstractFactory.factory.createButton("primary", "Cadastrar Novo Tema");

        Button btnCancelarNovoTema = ComponentsAbstractFactory.factory.createButton("secondary", "Cancelar");

        lblNomeNovoTema.setVisible(false);
        tfNomeNovoTema.setVisible(false);
        btnSalvarNovoTema.setVisible(false);
        btnCancelarNovoTema.setVisible(false);

        btnSalvarNovoTema.setOnAction(event -> {
            new AdicionarTemaAction(tfNomeNovoTema.getText(), null).active();
            new MudarPaginaAction("temas").active();
        });

        btnCancelarNovoTema.setOnAction(event -> {
            lblNomeNovoTema.setVisible(false);
            tfNomeNovoTema.setVisible(false);
            btnSalvarNovoTema.setVisible(false);
            btnCancelarNovoTema.setVisible(false);
            tfNomeNovoTema.setText("");
            btnCadastrarNovoTema.setDisable(false);
        });

        btnCadastrarNovoTema.setOnAction(event -> {
            lblNomeNovoTema.setVisible(true);
            tfNomeNovoTema.setVisible(true);
            btnSalvarNovoTema.setVisible(true);
            btnCancelarNovoTema.setVisible(true);
            btnCadastrarNovoTema.setDisable(true);
        });

        VBox boxNovotema = ComponentsAbstractFactory.factory.createVBox("temas_box_novo_tema");
        boxNovotema.getChildren().addAll(btnCadastrarNovoTema, lblNomeNovoTema, tfNomeNovoTema, btnSalvarNovoTema,
                btnCancelarNovoTema);
        // Fim cadastrar novo tema

        BorderPane bp = ComponentsAbstractFactory.factory.createBorderPane("main_tema");
        bp.setTop(lbltituloPagina);
        bp.setLeft(btnVoltar);
        bp.setRight(boxNovotema);
        bp.setCenter(hboxTemas);
        BorderPane.setAlignment(lbltituloPagina, Pos.CENTER);

        VBox main_tema = ComponentsAbstractFactory.factory.createVBox("main_tema");
        main_tema.getChildren().addAll(bp);
        return main_tema;
    }

    /**
     * Cria os botões para cada tema e os adiciona à caixa de temas.
     *
     * @param hboxTemas A caixa de temas onde os botões serão adicionados.
     */
    private void createBotoesTemas(HBox hboxTemas) {
        hboxTemas.getChildren().clear();
        Label lblfavoritos = ComponentsAbstractFactory.factory.createLabel("primary", "Favoritos");

        VBox listafavoritos = ComponentsAbstractFactory.factory.createVBox("tema_list_box");
        listafavoritos.getChildren().add(lblfavoritos);
        ScrollPane scrollPaneFavoritos = ComponentsAbstractFactory.factory.createScrollPane("hidden",
                listafavoritos);

        LinkedList<TemaModel> listaTemas = FacadeController.getInstance().listaDeTemasFavoritosPrincipais();

        if (listaTemas != null) {
            for (TemaModel tema : listaTemas) {
                Button button = ComponentsAbstractFactory.factory.createButton("primary", tema.getNome());
                button.setOnAction(e -> {
                    FacadeController.getInstance().setTemaSelecionado(tema);
                    new MudarPaginaAction("detalhes tema").active();
                });
                listafavoritos.getChildren().add(button);
            }
        }

        Label lbloutros = ComponentsAbstractFactory.factory.createLabel("secondary", "Outros Temas");

        VBox outros = ComponentsAbstractFactory.factory.createVBox("tema_list_box");
        outros.getChildren().add(lbloutros);

        ScrollPane scrollPaneOutros = ComponentsAbstractFactory.factory.createScrollPane("hidden", outros);

        LinkedList<TemaModel> listaTemasNaoFavoritos = FacadeController.getInstance().listaDeTemasPrincipais();

        if (listaTemasNaoFavoritos != null) {
            for (TemaModel tema : listaTemasNaoFavoritos) {
                Button button = ComponentsAbstractFactory.factory.createButton("secondary", tema.getNome());
                button.setOnAction(e -> {
                    FacadeController.getInstance().setTemaSelecionado(tema);
                    new MudarPaginaAction("detalhes tema").active();
                });
                outros.getChildren().add(button);
            }
        }

        VBox favoritos = ComponentsAbstractFactory.factory.createVBox("tema_list_box");
        favoritos.getChildren().addAll(lblfavoritos, scrollPaneFavoritos);

        VBox outrosTemas = ComponentsAbstractFactory.factory.createVBox("tema_list_box");
        outrosTemas.getChildren().addAll(lbloutros, scrollPaneOutros);

        hboxTemas.getChildren().addAll(favoritos, outrosTemas);
    }

}
