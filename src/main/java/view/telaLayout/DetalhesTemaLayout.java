package view.telaLayout;

import java.util.LinkedList;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import controller.FacadeController;
import model.ArquivosModel;
import model.TemaModel;
import view.components.ComponentsAbstractFactory;
import view.components.buttonAction.AdicionarArquivo;
import view.components.buttonAction.MudarPaginaAction;
import view.mensagens.ErrorView;
import view.components.buttonAction.AtualizarArquivoAction;
import view.components.buttonAction.ExcluirTemaAction;
import view.components.buttonAction.AdicionarTemaAction;
import view.components.buttonAction.AtualizarTemaAction;
import view.components.buttonAction.ExcluirArquivo;

public class DetalhesTemaLayout extends HomeLayout{
    private TemaModel tema = FacadeController.getInstance().getTemaSelecionado();
    
    @Override
    public Parent createMain() {
        BorderPane titulo = titulo();

        //local com text da descricão do tema
        TextArea tADescricaoTema = ComponentsAbstractFactory.factory.createTextArea("detalhes_tema_descricao");
        tADescricaoTema.setText(this.tema.getDescricao());

        VBox menuTemas = menuTemas();
        
        VBox centerBox = ComponentsAbstractFactory.factory.createVBox("detalhes_temas_exibir_dados");
        
        BorderPane borderPaneBotoesDeAlteracao = edicao(tADescricaoTema,centerBox);

        ScrollPane scrollPane = exibirArquivos();
        
        centerBox.getChildren().addAll(titulo,tADescricaoTema,borderPaneBotoesDeAlteracao,scrollPane);

        BorderPane main = ComponentsAbstractFactory.factory.createBorderPane("detalhes_tema_main");

        main.setLeft(menuTemas);
        main.setCenter(centerBox);
        return main;
    }

    public BorderPane titulo(){
        //botao voltar Label titulo da pagina.
        Button btnVoltar =  ComponentsAbstractFactory.factory.createButton("secondary", "Voltar");
        btnVoltar.setOnAction(e ->{
            if(FacadeController.getInstance().voltarTema()){
                new MudarPaginaAction("detalhes tema").active();
            }
            else new MudarPaginaAction("temas").active();
        });

        Label lbltituloPagina =  ComponentsAbstractFactory.factory.createLabel("primary",this.tema.getNome());
        Label lblDescricao =  ComponentsAbstractFactory.factory.createLabel("secondary","Descrição");


        CheckBox favorito = ComponentsAbstractFactory.factory.createCheckBox("detalhes_tema_favoritos");
        favorito.setText("Favorito");

        //verifica se o tema selecionado e favorito se for marca o checkbox
        if(FacadeController.getInstance().isFavorito(tema))
            favorito.setSelected(true);
        else favorito.setSelected(false);
        
        favorito.setOnAction(e -> {
            if(favorito.isSelected()){
                if(FacadeController.getInstance().adicionarFavorito(tema))
                    ErrorView.exibirMensagem("Favoritos","Adicionado " + tema.getNome() + " a os favoritos com Sucesso!");
                else ErrorView.exibirMensagem("Favoritos","Falha ao adicionar " + tema.getNome() + " aos Favoritos");
            }
            else {
                if(FacadeController.getInstance().removerFavorito(tema))
                    ErrorView.exibirMensagem("Favoritos",tema.getNome() + "\n\nRemovido dos favoritos!");
                else ErrorView.exibirMensagem("Favoritos", "Falha ao remover " + tema.getNome() + " dos favoritos");
            }

        });        

        BorderPane borderBoxTopMain = ComponentsAbstractFactory.factory.createBorderPane("detalhes_tema_titulo_box");
        //hboxTitulo.getChildren().addAll(btnVoltar,lbltituloPagina,favorito);
        borderBoxTopMain.setLeft(btnVoltar);
        borderBoxTopMain.setTop(lbltituloPagina);
        borderBoxTopMain.setRight(favorito);
        borderBoxTopMain.setBottom(lblDescricao);
        BorderPane.setAlignment(lbltituloPagina, Pos.CENTER);
        BorderPane.setAlignment(lblDescricao, Pos.CENTER);

        return borderBoxTopMain;
    }

    public BorderPane edicao(TextArea tADescricaoTema,VBox centerBox){
        RadioButton editar = ComponentsAbstractFactory.factory.createRadioButton("primary");

        Button salvar = ComponentsAbstractFactory.factory.createButton("primary","Salvar");
        
        Button exlucir = ComponentsAbstractFactory.factory.createButton("secondary","Excluir");
        
        exlucir.setOnAction(event -> {
            new ExcluirTemaAction(tema).active();
            if(FacadeController.getInstance().voltarTema()){
                new MudarPaginaAction("detalhes tema").active();
            }
            else new MudarPaginaAction("temas").active();
        });
        
        Button cancelarAlteracoes = ComponentsAbstractFactory.factory.createButton("secondary","Cancelar Alterações");

        salvar.setOnAction(e -> {
            new AtualizarTemaAction(tema, tADescricaoTema.getText(), tema.getNome()).booleanAction();
            editar.setSelected(false);
            editar.setDisable(false);
            tADescricaoTema.setEditable(false);
            salvar.setDisable(true);
            exlucir.setDisable(true);
            cancelarAlteracoes.setDisable(true);
        });

        cancelarAlteracoes.setOnAction(event ->{
            editar.setSelected(false);
            editar.setDisable(false);
            tADescricaoTema.setText(tema.getDescricao());
            tADescricaoTema.setEditable(false);
            salvar.setDisable(true);
            exlucir.setDisable(true);
            cancelarAlteracoes.setDisable(true);
        });

        salvar.setDisable(true);
        exlucir.setDisable(true);
        cancelarAlteracoes.setDisable(true);

        editar.setText("Ativar Edição");
        editar.setOnAction(e ->{
            if(editar.isSelected()){
                salvar.setDisable(false);
                exlucir.setDisable(false);
                cancelarAlteracoes.setDisable(false);
                tADescricaoTema.setEditable(true);
                editar.setDisable(true);
            }
        });

        Label lblNomeArquivo = ComponentsAbstractFactory.factory.createLabel("secondary", "Nome Arquivo");
        TextField tfNomeArquivo = ComponentsAbstractFactory.factory.createTextField("secondary");

        Label lblLinkArquivo = ComponentsAbstractFactory.factory.createLabel("secondary", "Link:");
        TextField tfLinkArquivo = ComponentsAbstractFactory.factory.createTextField("secondary");
        tfLinkArquivo.setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.ENTER){
                new AdicionarArquivo(this.tema,tfNomeArquivo, tfLinkArquivo).active();
                centerBox.getChildren().remove(3);
            }
        });

        Button btnSalvarArquivo = ComponentsAbstractFactory.factory.createButton("secondary", "Salvar Arquivo");
        btnSalvarArquivo.setOnAction(event -> {
            new AdicionarArquivo(this.tema,tfNomeArquivo, tfLinkArquivo).active();
            centerBox.getChildren().remove(3);
        });

      
        Button btnCancelarNovoArquivo = ComponentsAbstractFactory.factory.createButton("secondary", "Cancelar");
        btnCancelarNovoArquivo.setOnAction(event -> {
            tfNomeArquivo.setText("");
            tfLinkArquivo.setText("");
            centerBox.getChildren().remove(3);
        });

        HBox boxAdicionarArquivo = ComponentsAbstractFactory.factory.createHBox("detalhes_tema_botoes_alteracao");
        boxAdicionarArquivo.getChildren().addAll(lblNomeArquivo,tfNomeArquivo,lblLinkArquivo,tfLinkArquivo,btnSalvarArquivo,btnCancelarNovoArquivo);

        Button btnArquivos = ComponentsAbstractFactory.factory.createButton("secondary", "Adicionar Novo Arquivo");
        btnArquivos.setOnAction(e->{
            centerBox.getChildren().add(3, boxAdicionarArquivo);
        });

        HBox boxBtnArquivos = ComponentsAbstractFactory.factory.createHBox("detalhes_tema_BtnArquivos");
        boxBtnArquivos.getChildren().add(btnArquivos);

        HBox boxDosButtoesDeAlteracoes = ComponentsAbstractFactory.factory.createHBox("detalhes_tema_botoes_alteracao");
        boxDosButtoesDeAlteracoes.getChildren().addAll(salvar,cancelarAlteracoes);
        BorderPane borderPaneBotoesDeAlteracao = ComponentsAbstractFactory.factory.createBorderPane("detalhes_temas_exibir_dados");
        borderPaneBotoesDeAlteracao.setLeft(editar);
        borderPaneBotoesDeAlteracao.setRight(exlucir);
        borderPaneBotoesDeAlteracao.setCenter(boxDosButtoesDeAlteracoes);
        borderPaneBotoesDeAlteracao.setBottom(boxBtnArquivos);
        return borderPaneBotoesDeAlteracao;
    }

    public VBox menuTemas(){

        Button btnCadastrarNovoSubtema = ComponentsAbstractFactory.factory.createButton("primary","Cadastrar Novo SubTema");

        Label lblfavoritos = ComponentsAbstractFactory.factory.createLabel("secondary","Favoritos");

        VBox vboxFavoritos = ComponentsAbstractFactory.factory.createVBox("detalhes_tema_favoritos");
        vboxFavoritos.getChildren().add(lblfavoritos);

        for (TemaModel tema : FacadeController.getInstance().listaDeSubTemasFavoritos(this.tema)) {
            Button btnTema = ComponentsAbstractFactory.factory.createButton("detalhes_tema_btn_primary",tema.getNome());
            btnTema.setWrapText(true);
            btnTema.setOnAction( event -> {
                FacadeController.getInstance().setTemaSelecionado(tema);
                new MudarPaginaAction("detalhes tema").active();
            });
            vboxFavoritos.getChildren().add(btnTema);
        }
        
        VBox outrosSubtemas = ComponentsAbstractFactory.factory.createVBox("detalhes_tema_outros_temas");

        Label lblOutros = ComponentsAbstractFactory.factory.createLabel("secondary","Outros Temas");
        outrosSubtemas.getChildren().add(lblOutros);
        for (TemaModel tema : FacadeController.getInstance().listaDeSubTemas(this.tema)) {
            Button btnTema = ComponentsAbstractFactory.factory.createButton("detalhes_tema_btn_secondary",tema.getNome());
            btnTema.setWrapText(true);
            btnTema.setOnAction( event -> {
                FacadeController.getInstance().setTemaSelecionado(tema);
                new MudarPaginaAction("detalhes tema").active();
                
            });
            outrosSubtemas.getChildren().add(btnTema);
        }

        ScrollPane scrollFavoritos = ComponentsAbstractFactory.factory.createScrollPane("detalhes_temas_scroll",vboxFavoritos);
        ScrollPane scrollPaneOutros = ComponentsAbstractFactory.factory.createScrollPane("detalhes_temas_scroll",outrosSubtemas);
        
        VBox menuTemas = ComponentsAbstractFactory.factory.createVBox("detalhes_tema_temas");

        //inicio box cadastrar novo subtema
        Label lblNomeNovoSubTema = ComponentsAbstractFactory.factory.createLabel("secondary", "Nome");
        TextField tfNomeNovoSubTema = ComponentsAbstractFactory.factory.createTextField("secondary");
        Button btnSalvarNovoSubTema = ComponentsAbstractFactory.factory.createButton("primary", "Salvar");
        Button btnCancelarNovoSubTema= ComponentsAbstractFactory.factory.createButton("secondary", "Cancelar");

        tfNomeNovoSubTema.setOnKeyPressed(event ->{
            if(event.getCode().equals(KeyCode.ENTER)){
                new AdicionarTemaAction(tfNomeNovoSubTema.getText(),this.tema.getTemaId()).active();
                new MudarPaginaAction("detalhes tema").active();
            }
        });
        
        btnSalvarNovoSubTema.setOnAction(event ->{
            new AdicionarTemaAction(tfNomeNovoSubTema.getText(),this.tema.getTemaId()).active();
            new MudarPaginaAction("detalhes tema").active();
        });
        btnCancelarNovoSubTema.setOnAction(event ->{
            tfNomeNovoSubTema.setText("");
            menuTemas.getChildren().clear();
            menuTemas.getChildren().addAll(btnCadastrarNovoSubtema,lblfavoritos,scrollFavoritos,lblOutros,scrollPaneOutros);   
        });

        //fim box cadastrar novo subtema

        btnCadastrarNovoSubtema.setOnAction(event -> {
            menuTemas.getChildren().clear();
            menuTemas.getChildren().addAll(lblNomeNovoSubTema,tfNomeNovoSubTema,btnSalvarNovoSubTema,btnCancelarNovoSubTema);
        });

        
        menuTemas.getChildren().addAll(btnCadastrarNovoSubtema,lblfavoritos,scrollFavoritos,lblOutros,scrollPaneOutros);   
        return menuTemas;
    }

    public ScrollPane exibirArquivos(){
        GridPane gridPane = ComponentsAbstractFactory.factory.createGridPane("detalhes_tema_arquivos");
        gridPane.getChildren().clear();
        Label lblNomeArquivo = ComponentsAbstractFactory.factory.createLabel("detalhes_tema_label_gridpane_arquivo", "Arquivo");

        Label lblLinkArquivo = ComponentsAbstractFactory.factory.createLabel("detalhes_tema_label_gridpane_link", "Link");

        Label lbleditar = ComponentsAbstractFactory.factory.createLabel("detalhes_tema_label_gridpane_editar", "Editar");

        gridPane.add(lblNomeArquivo, 0, 0);
        gridPane.add(lblLinkArquivo, 1, 0);
        gridPane.add(lbleditar, 2, 0);

        LinkedList<ArquivosModel> arquivos = FacadeController.getInstance().getListaArquivos(this.tema);

        int row =1;

        for (ArquivosModel arquivo : arquivos) {
            int rowAual = row;//define o numero da linha
            //local para colocar o nome arquivo
            //box para adicionar distanciamento dos cantos do campo.
            HBox boxNomeArquivo = ComponentsAbstractFactory.factory.createHBox("detalhes_tema_box_nome_arquivo");
            //Text para exibir o nome
            Text textNomeArquivo = ComponentsAbstractFactory.factory.createText("detalhes_tema_nome_arquivo", arquivo.getNome());
            //Textfield para editar o nome
            TextField tfNomeArquivo = ComponentsAbstractFactory.factory.createTextField("detalhes_tema_nome_arquivo");
            tfNomeArquivo.setText(textNomeArquivo.getText());

            //Hyperlink para mostrar o link do arquivo
            Hyperlink linkArquivo = ComponentsAbstractFactory.factory.createHyperlink("detalhes_tema_link_arquivo", arquivo.getLink());
            //textfield para editar o link
            TextField tfLinkArquivo = ComponentsAbstractFactory.factory.createTextField("detalhes_tema_link_arquivo");
            tfLinkArquivo.setText(linkArquivo.getText());
            

            //botoes
            RadioButton rbEditar = ComponentsAbstractFactory.factory.createRadioButton("detalhes_tema_editar_arquivo");
            Button remover = ComponentsAbstractFactory.factory.createButton("secondary", "Remover");
            Button cancelar = ComponentsAbstractFactory.factory.createButton("secondary", "Cancelar");
            Button salvar = ComponentsAbstractFactory.factory.createButton("primary","Salvar");

            //box botoes
            HBox btnbox = ComponentsAbstractFactory.factory.createHBox("detalhes_tema_BtnArquivos");
            btnbox.getChildren().addAll(salvar,cancelar,remover);

            tfLinkArquivo.setOnKeyPressed(e->{
                if(e.getCode() == KeyCode.ENTER){
                    new AtualizarArquivoAction(arquivo, tfNomeArquivo, tfLinkArquivo);
                    gridPane.getChildren().remove(tfNomeArquivo);
                    gridPane.add(boxNomeArquivo, 0,rowAual);
                    gridPane.getChildren().remove(tfLinkArquivo);
                    gridPane.add(linkArquivo,1,rowAual);
                    tfNomeArquivo.setEditable(false);
                    tfLinkArquivo.setEditable(false);
                    gridPane.getChildren().remove(btnbox);
                    rbEditar.setSelected(false);
                    rbEditar.setDisable(false);
                    linkArquivo.setText(tfLinkArquivo.getText());
                    textNomeArquivo.setText(tfNomeArquivo.getText());
                }
            });
            salvar.setOnAction(event ->{
                if(new AtualizarArquivoAction(arquivo, tfNomeArquivo, tfLinkArquivo).booleanAction()){
                    gridPane.getChildren().remove(tfNomeArquivo);
                    gridPane.add(boxNomeArquivo, 0,rowAual);
                    gridPane.getChildren().remove(tfLinkArquivo);
                    gridPane.add(linkArquivo,1,rowAual);
                    tfNomeArquivo.setEditable(false);
                    tfLinkArquivo.setEditable(false);
                    gridPane.getChildren().remove(btnbox);
                    rbEditar.setSelected(false);
                    rbEditar.setDisable(false);
                    linkArquivo.setText(tfLinkArquivo.getText());
                    textNomeArquivo.setText(tfNomeArquivo.getText());
                }
            });

            cancelar.setOnAction(e->{
                gridPane.getChildren().remove(tfNomeArquivo);
                gridPane.add(boxNomeArquivo, 0,rowAual);
                gridPane.getChildren().remove(tfLinkArquivo);
                gridPane.add(linkArquivo,1,rowAual);
                tfNomeArquivo.setEditable(false);
                tfLinkArquivo.setEditable(false);
                gridPane.getChildren().remove(btnbox);
                rbEditar.setSelected(false);
                rbEditar.setDisable(false);
            });

            remover.setOnAction(event ->{
                if(new ExcluirArquivo(arquivo).booleanAction())
                {
                    new MudarPaginaAction("detalhes tema").active();
                    gridPane.getChildren().remove(tfNomeArquivo);
                    gridPane.add(boxNomeArquivo, 0,rowAual);
                    gridPane.getChildren().remove(tfLinkArquivo);
                    gridPane.add(linkArquivo,1,rowAual);
                    tfNomeArquivo.setEditable(false);
                    tfLinkArquivo.setEditable(false);
                    gridPane.getChildren().remove(btnbox);
                    rbEditar.setSelected(false);
                    rbEditar.setDisable(false);
                }
            });
            rbEditar.setOnAction(event ->{
                if(rbEditar.isSelected()){
                    //troca o text do nome para um textfield
                    gridPane.getChildren().remove(boxNomeArquivo);
                    gridPane.add(tfNomeArquivo, 0,rowAual);
                    //troca o link por um textfield
                    gridPane.getChildren().remove(linkArquivo);
                    gridPane.add(tfLinkArquivo,1,rowAual);

                    tfNomeArquivo.setEditable(true);
                    tfLinkArquivo.setEditable(true);
                    //adiciona os botoes de edicao
                    gridPane.add(btnbox, 3, rowAual);
                    rbEditar.setDisable(true);
                }
                else{
                    gridPane.getChildren().remove(tfNomeArquivo);
                    gridPane.add(boxNomeArquivo, 0,rowAual);
                    gridPane.getChildren().remove(tfLinkArquivo);
                    gridPane.add(linkArquivo,1,rowAual);
                    tfNomeArquivo.setEditable(false);
                    tfLinkArquivo.setEditable(false);
                    gridPane.getChildren().remove(btnbox);
                    rbEditar.setSelected(false);
                    rbEditar.setDisable(false);
                }
    
            });
            
            boxNomeArquivo.getChildren().add(textNomeArquivo);
            
            gridPane.add(boxNomeArquivo, 0, rowAual);
            gridPane.add(linkArquivo, 1, rowAual);
            gridPane.add(rbEditar, 2, rowAual);
            row++;
        }
        return ComponentsAbstractFactory.factory.createScrollPane("detalhes_tema_arquivos_scroll", gridPane);
    }

}
