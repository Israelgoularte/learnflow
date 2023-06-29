package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import util.ScreanSize;
import view.changeAppearence.Interface.AppearenceHandler;
import view.style.MyStyle;

/**
 * Classe concreta que implementa o manipulador de aparência para HBox do JavaFX.
 */
public class HBoxAppearenceHandler extends AppearenceHandler {

    /**
     * Define o estilo para o HBox do JavaFX.
     *
     * @param Node o elemento do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable Node) {
        if (Node instanceof HBox) {
            HBox hbox = (HBox) Node;
            switch (hbox.getId()) {
                case "nav":
                    hbox.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(), null, null)));
                    break;
                case "footer":
                case "header":
                    hbox.setAlignment(Pos.CENTER);
                    hbox.setSpacing(100);
                    hbox.setPadding(new Insets(0, 20, 0, 20));
                    hbox.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(), null, null)));
                    break;
                case "right":
                    hbox.setSpacing(1);
                    hbox.setPadding(new Insets(0, 5, 0, 2));
                    hbox.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(), null, null)));
                    hbox.setAlignment(Pos.CENTER_RIGHT);
                    hbox.setPrefWidth(ScreanSize.getInstance().getWidth() * 0.3);
                    break;
                case "detalhes_tema_titulo_box":
                case "tema_titulo_box":
                    hbox.setSpacing(300);
                    hbox.setAlignment(Pos.CENTER);
                    return;
                case "tema_list_box":
                    hbox.setSpacing(50);
                    hbox.setMinHeight(ScreanSize.getInstance().getHeight() * 0.5);
                    //hbox.setPadding(new Insets(50));
                    break;
                case "detalhes_tema_box_nome_arquivo":
                case "detalhes_tema_BtnArquivos":
                    hbox.setPadding(new Insets(10, 10, 10, 10));
                    hbox.setSpacing(10);
                    break;
                default:
                    hbox.setSpacing(20);
                    break;
            }
            // Para todos os casos
            hbox.setAlignment(Pos.CENTER);
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(Node);
        }
    }

}
