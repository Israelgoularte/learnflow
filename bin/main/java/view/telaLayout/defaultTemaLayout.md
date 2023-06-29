package main.java.view.telaLayout;

import java.util.LinkedList;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import main.java.controller.FacadeController;
import main.java.model.TemaModel;
import main.java.model.UsuarioModel;
import main.java.view.components.ComponentsAbstractFactory;
import main.java.view.components.buttonAction.AtualizarPaginaAction;
import main.java.view.components.buttonAction.MudarPaginaAction;
import main.java.view.style.MyStyleConstantsFactory;
import main.java.view.telaLayout.factorys.TelaLayoutInterface;

public abstract class DefaultLayout implements TelaLayoutInterface {

    /**
     * Cria o cabeçalho do layout.
     *
     * @return o nó HBox que representa o cabeçalho do layout
     */
    @Override
    public HBox createHeader() {
        Label textSlogan = ComponentsAbstractFactory.factory.createLabel("header_label_app_name", "Learn Flow");
        textSlogan.setOnMouseClicked(e -> {
            if (!(this instanceof LoginLayout || this instanceof CadastroLayout)) {
                FacadeController.getInstance().reinicializarGerenteTemas();
                new MudarPaginaAction("home").active();
            }
        });
        HBox hboxHeader = ComponentsAbstractFactory.factory.createHBox("header");
        hboxHeader.getChildren().add(textSlogan);
        return hboxHeader;
    }

    /**
     * Cria o rodapé do layout.
     *
     * @return o nó HBox que representa o rodapé do layout
     */
    @Override
    public HBox createFooter() {
        Label desenvolvedor = ComponentsAbstractFactory.factory.createLabel("secondary", "Desenvolvido por Israel Goularte");
        Label fraseBottom = ComponentsAbstractFactory.factory.createLabel("secondary", "Bons Estudos!");
        HBox hboxFooter = ComponentsAbstractFactory.factory.createHBox("footer");
        hboxFooter.getChildren().addAll(fraseBottom, desenvolvedor);
        return hboxFooter;
    }

    /**
     * Cria a raiz padrão do layout.
     *
     * @return o nó BorderPane que representa a raiz padrão do layout
     */
    @Override
    public BorderPane createDefaultRoot() {
        BorderPane root = ComponentsAbstractFactory.factory.createBorderPane("root");
        root.setTop(createHeader());
        root.setCenter(createMain());
        root.setBottom(createFooter());
        return root;
    }

    /**
     * Cria a navegação do layout.
     *
     * @return o nó Parent que representa a navegação do layout
     */
    @Override
    public Parent createNav() {
        MenuBar menuBarEsquerdo = ComponentsAbstractFactory.factory.createMenuBar("left");
        menuBarEsquerdo.getMenus().addAll(createMenuTema(), createMenuLembrete(), createMenuQuestionarios());

        MenuBar loginbar = ComponentsAbstractFactory.factory.createMenuBar("right");
        loginbar.getMenus().addAll(createMenuLogin(), createMenuConfig());

        Label lblusuario = ComponentsAbstractFactory.factory.createLabel("menu_usuario", "Usuario");

        HBox menubarDireiro = ComponentsAbstractFactory.factory.createHBox("right");
        menubarDireiro.getChildren().addAll(lblusuario, loginbar);

        HBox navBox = ComponentsAbstractFactory.factory.createHBox("nav");
        navBox.getChildren().addAll(menuBarEsquerdo, menubarDireiro);
        return navBox;
    }

    /**
     * Cria o menu de questionários.
     *
     * @return o nó Menu que representa o menu de questionários
     */
    public Menu createMenuQuestionarios() {
        Menu questionarios = ComponentsAbstractFactory.factory.createMenu("normal", "Questionario");
        return questionarios;
    }

    /**
     * Cria o menu de lembretes.
     *
     * @return o nó Menu que representa o menu de lembretes
     */
    public Menu createMenuLembrete() {
        Menu lembretes = ComponentsAbstractFactory.factory.createMenu("normal", "Lembretes");
        return lembretes;
    }

    /**
     * Cria o menu de temas.
     *
     * @return o nó Menu que representa o menu de temas
     */
    public Menu createMenuTema() {
        Menu temas = ComponentsAbstractFactory.factory.createMenu("normal", "Temas");
        temas.setAccelerator(KeyCombination.keyCombination("ALT+T"));

        Menu openTemas = ComponentsAbstractFactory.factory.createMenu("normal", "Open");

        Menu exportTemas = ComponentsAbstractFactory.factory.createMenu("normal", "Export to PDF");
        temas.getItems().addAll(openTemas, exportTemas);

        LinkedList<TemaModel> listaTemas = FacadeController.getInstance().listaDeTemasFavoritosPrincipais();
        if (listaTemas != null) {
            for (TemaModel tema : listaTemas) {
                MenuItem menuItemOpen = ComponentsAbstractFactory.factory.createMenuItem("normal", tema.getNome());
                menuItemOpen.setOnAction(e -> {
                    FacadeController.getInstance().setTemaSelecionado(tema);
                    new MudarPaginaAction("detalhes tema").active();
                });
                openTemas.getItems().add(menuItemOpen);
                MenuItem menuItemExport = ComponentsAbstractFactory.factory.createMenuItem("normal", tema.getNome());
                menuItemExport.setOnAction(e -> {
                    FacadeController.getInstance().exportPDF(tema);
                });
                exportTemas.getItems().add(menuItemExport);
            }
        }

        LinkedList<TemaModel> listaTemasNaoFavoritos = FacadeController.getInstance().listaDeTemasPrincipais();
        if (listaTemasNaoFavoritos != null) {
            for (TemaModel tema : listaTemasNaoFavoritos) {
                MenuItem menuItemOpen = ComponentsAbstractFactory.factory.createMenuItem("normal", tema.getNome());
                menuItemOpen.setOnAction(e -> {
                    FacadeController.getInstance().setTemaSelecionado(tema);
                    new MudarPaginaAction("detalhes tema").active();
                });
                openTemas.getItems().add(menuItemOpen);
                MenuItem menuItemExport = ComponentsAbstractFactory.factory.createMenuItem("normal", tema.getNome());
                menuItemExport.setOnAction(e -> {
                    FacadeController.getInstance().exportPDF(tema);
                });
                exportTemas.getItems().add(menuItemExport);
            }
        }
        return temas;
    }

    /**
     * Cria o menu de login.
     *
     * @return o nó Menu que representa o menu de login
     */
    public Menu createMenuLogin() {
        Menu usuarioMenu = null;
        try {
            usuarioMenu = ComponentsAbstractFactory.factory.createMenu("nomral",
                    UsuarioModel.getInstance().getNome().toUpperCase());

            MenuItem itemLogout = ComponentsAbstractFactory.factory.createMenuItem("normal", "Logout");
            itemLogout.setOnAction(e -> {
                FacadeController.getInstance().logout();
                new MudarPaginaAction("login").active();
            });

            usuarioMenu.getItems().add(0, itemLogout);
        } catch (IllegalAccessError error) {
            usuarioMenu = ComponentsAbstractFactory.factory.createMenu("normal", "Efetue o login");
            usuarioMenu.setDisable(true);
        }
        usuarioMenu.setAccelerator(KeyCombination.keyCombination("ALT+U"));
        return usuarioMenu;
    }

    /**
     * Cria o menu de configurações.
     *
     * @return o nó Menu que representa o menu de configurações
     */
    public Menu createMenuConfig() {
        MenuItem menuItemRefresh = ComponentsAbstractFactory.factory.createMenuItem("normal", "Recarregar Dados");
        menuItemRefresh.setOnAction(event -> {
            FacadeController.getInstance().recarregarDados();
            new AtualizarPaginaAction().active();
        });

        MenuItem menuItemTema1 = ComponentsAbstractFactory.factory.createMenuItem("normal", "Tema 1");
        menuItemTema1.setOnAction(event -> {
            MyStyleConstanteFactory.TEMA_1.createStyle();
            new AtualizarPaginaAction().active();
        });
        MenuItem menuItemTema2 = ComponentsAbstractFactory.factory.createMenuItem("normal", "Tema 2");
        menuItemTema2.setOnAction(event -> {
            MyStyleConstanteFactory.TEMA_2.createStyle();
            new AtualizarPaginaAction().active();

        });
        MenuItem menuItemTema3 = ComponentsAbstractFactory.factory.createMenuItem("normal", "Tema 3");
        menuItemTema3.setOnAction(event -> {
            MyStyleConstanteFactory.TEMA_3.createStyle();
            new AtualizarPaginaAction().active();

        });
        MenuItem menuItemTema4 = ComponentsAbstractFactory.factory.createMenuItem("normal", "Tema 4");
        menuItemTema4.setOnAction(event -> {
            MyStyleConstanteFactory.TEMA_4.createStyle();
            new AtualizarPaginaAction().active();

        });
        MenuItem menuItemTema5 = ComponentsAbstractFactory.factory.createMenuItem("normal", "Tema 5");
        menuItemTema5.setOnAction(event -> {
            MyStyleConstanteFactory.TEMA_5.createStyle();
            new AtualizarPaginaAction().active();

        });

        MenuItem menuItemTema6 = ComponentsAbstractFactory.factory.createMenuItem("normal", "Tema 6");
        menuItemTema6.setOnAction(event -> {
            MyStyleConstanteFactory.TEMA_6.createStyle();
            new AtualizarPaginaAction().active();

        });

        MenuItem menuItemTema7 = ComponentsAbstractFactory.factory.createMenuItem("normal", "Default");
        menuItemTema7.setOnAction(event -> {
            MyStyleConstanteFactory.DEFAULT.createStyle();
            new AtualizarPaginaAction().active();

        });

        Menu menuItemAlterarTema = ComponentsAbstractFactory.factory.createMenu("normal", "Aparencia");
        menuItemAlterarTema.getItems()
                .addAll(menuItemTema1, menuItemTema2, menuItemTema3, menuItemTema4, menuItemTema5, menuItemTema6,
                        menuItemTema7);

        Menu configuracoes = ComponentsAbstractFactory.factory.createMenu("normal", "Configurações");
        configuracoes.getItems().addAll(menuItemRefresh, menuItemAlterarTema);
        return configuracoes;
    }
}

classe original