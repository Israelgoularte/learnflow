package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import util.ScreanSize;
import view.changeAppearence.Interface.AppearenceHandler;
import view.style.MyStyle;

/**
 * Classe concreta que implementa o manipulador de aparência para BorderPane do JavaFX.
 */
public class BorderPaneAppearenceHandler extends AppearenceHandler {

    /**
     * Define o estilo para o BorderPane do JavaFX.
     *
     * @param Node o elemento do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable Node) {
        if (Node instanceof BorderPane) {
            BorderPane borderPane = (BorderPane) Node;
            switch (borderPane.getId()) {
                case "root":
                    borderPane.setBackground(new Background(new BackgroundImage(
                            MyStyle.getMyStyle().getImagemFundoPrincipal(),
                            BackgroundRepeat.NO_REPEAT,
                            BackgroundRepeat.NO_REPEAT,
                            BackgroundPosition.CENTER,
                            new BackgroundSize(
                                    ScreanSize.getInstance().getWidth(),
                                    ScreanSize.getInstance().getHeight(),
                                    false, false, false, false
                            )
                    )));
                    break;
                case "primary":
                    // Definir estilo para BorderPane com ID "primary"
                    borderPane.setBackground(new Background(new BackgroundFill(
                            MyStyle.getMyStyle().getCorFundoPrincipal(),
                            null, null
                    )));
                    borderPane.setPadding(new Insets(30));
                    break;
                case "secondary":
                    // Definir estilo para BorderPane com ID "secondary"
                    borderPane.setBackground(new Background(new BackgroundFill(
                            MyStyle.getMyStyle().getCorFundoSecundario(),
                            null, null
                    )));
                    borderPane.setPadding(new Insets(20));
                    break;
                case "main_tema":
                    break;
                case "detalhes_tema_titulo_box":
                    borderPane.setBackground(null);
                    borderPane.setPadding(new Insets(5,10,2,10));
                    break;
                case "detalhes_tema_botoes_alteracao":
                default:
                    // Definir estilo para BorderPane sem ID específico
                    borderPane.setBackground(null);
                    borderPane.setPadding(new Insets(10));
                    break;
            }
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(Node);
        }
    }

}
