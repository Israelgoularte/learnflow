package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import util.ScreanSize;
import view.changeAppearence.Interface.AppearenceHandler;
import view.style.MyStyle;

public class MenuBarAppearenceHandler extends AppearenceHandler {

    /**
     * Define o estilo para o elemento MenuBar do JavaFX.
     *
     * @param node o elemento MenuBar do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof MenuBar) {
            MenuBar menuBar = (MenuBar) node;
            switch (menuBar.getId()) {
                case "left":
                    menuBar.setPrefWidth(ScreanSize.getInstance().getWidth() * 0.7);
                    menuBar.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(), null, null)));
                    // Definir estilo para MenuBar com ID "left"
                    break;
                case "right":
                    menuBar.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(), null, null)));
                    // Definir estilo para MenuBar com ID "right"
                    break;
                default:
                    menuBar.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(), null, null)));
                    // Definir estilo para MenuBar sem ID específico
                    break;
                // Adicione mais casos conforme necessário para IDs específicos de MenuBar
            }
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
