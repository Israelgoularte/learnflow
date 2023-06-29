package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import util.ScreanSize;
import view.changeAppearence.Interface.AppearenceHandler;
import view.style.MyStyle;

public class VBoxAppearenceHandler extends AppearenceHandler {

    /**
     * Define o estilo para o elemento VBox do JavaFX.
     *
     * @param node o elemento VBox do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof VBox) {
            VBox vBox = (VBox) node;
            switch (vBox.getId()) {
                case "primary":
                    vBox.setBackground(new Background(
                            new BackgroundFill(MyStyle.getMyStyle().getCorFundoPrincipal(), null, null)));
                    vBox.setPadding(new Insets(30));
                    break;
                case "secondary":
                    vBox.setBackground(new Background(
                            new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(), null, null)));
                    vBox.setPadding(new Insets(30));
                    break;
                case "main":
                    vBox.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(),
                            new CornerRadii(30), null)));
                    vBox.setPadding(new Insets(30));
                    vBox.setSpacing(30);
                    vBox.setMaxSize(400, 200);
                    break;
                case "header":
                    vBox.setBackground(new Background(
                            new BackgroundFill(MyStyle.getMyStyle().getCorFundoPrincipal(), null, null)));
                    vBox.setSpacing(0);
                    vBox.setMaxSize(ScreanSize.getInstance().getWidth(), 300);
                    break;
                case "detalhes_temas_exibir_dados":
                    vBox.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(),
                            new CornerRadii(30), null)));
                    vBox.setPadding(new Insets(30));
                    vBox.setSpacing(10);
                    vBox.setMaxSize(ScreanSize.getInstance().getWidth() * 0.65,
                            ScreanSize.getInstance().getHeight() * 0.85);
                    vBox.setAlignment(Pos.TOP_CENTER);
                    return; // Evita que siga o código abaixo para as edições padrões
                case "main_tema":
                    vBox.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(),
                            new CornerRadii(30), null)));
                    vBox.setPadding(new Insets(30));
                    vBox.setSpacing(30);
                    vBox.setMaxSize(ScreanSize.getInstance().getWidth() * 0.8,
                            ScreanSize.getInstance().getHeight() * 0.7);
                    vBox.setAlignment(Pos.TOP_CENTER);
                    break;
                case "tema_list_box":
                    vBox.setMinWidth(400);
                    vBox.setBackground(new Background(
                            new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(), null, null)));
                    vBox.setPadding(new Insets(30));
                    vBox.setSpacing(10);
                    vBox.setAlignment(Pos.TOP_CENTER);
                    return;
                case "detalhes_tema_favoritos":
                case "detalhes_tema_outros_temas":
                    vBox.setPrefWidth(ScreanSize.getInstance().getWidth() * 0.17);
                    vBox.setPrefHeight(ScreanSize.getInstance().getHeight() * 0.20);
                    vBox.setPadding(new Insets(10, 10, 10, 60));
                    vBox.setSpacing(10);
                    vBox.setAlignment(Pos.TOP_CENTER);
                    return;
                case "detalhes_tema_temas":
                    vBox.setBackground(new Background(
                            new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(), null, null)));
                    vBox.setPrefHeight(ScreanSize.getInstance().getHeight() * 0.85);
                    vBox.setPrefWidth(ScreanSize.getInstance().getWidth() * 0.2);
                    vBox.setPadding(new Insets(30));
                    vBox.setSpacing(30);
                    break;
                case "temas_box_novo_tema":
                    vBox.setPadding(new Insets(30));
                    vBox.setSpacing(30);
                    vBox.setAlignment(Pos.TOP_CENTER);
                    return;
                default:
                    vBox.setBackground(new Background(
                            new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(), null, null)));
                    vBox.setPadding(new Insets(30));
                    vBox.setSpacing(30);
                    vBox.setMaxSize(400, 300);
                    break;
                // Adicione mais casos conforme necessário para IDs específicos de VBox
            }
            // Configurações comuns para todos
            vBox.setAlignment(Pos.CENTER);
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
