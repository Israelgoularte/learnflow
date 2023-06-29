package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.scene.control.Menu;
import view.changeAppearence.Interface.AppearenceHandler;

public class MenuAppearenceHandler extends AppearenceHandler {

    /**
     * Define o estilo para o elemento Menu do JavaFX.
     *
     * @param node o elemento Menu do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof Menu) {
            Menu menu = (Menu) node;
            switch (menu.getId()) {
                case "normal":
                    // Definir estilo para Menu sem ID específico
                    break;
                case "menu1":
                    // Definir estilo para Menu com ID "menu1"
                    break;
                // Adicione mais casos conforme necessário para IDs específicos de Menu
            }
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
