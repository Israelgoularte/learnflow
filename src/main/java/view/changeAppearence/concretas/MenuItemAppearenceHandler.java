package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.scene.control.MenuItem;
import view.changeAppearence.Interface.AppearenceHandler;

/**
 * Classe concreta que implementa o manipulador de aparência para MenuItem do JavaFX.
 */
public class MenuItemAppearenceHandler extends AppearenceHandler {
    
    /**
     * Define o estilo para o MenuItem do JavaFX.
     *
     * @param node o elemento do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) node;
            switch (menuItem.getId()) {
                case "":
                    // Definir estilo para MenuItem sem ID específico
                    break;
                case "menuItem1":
                    // Definir estilo para MenuItem com ID "menuItem1"
                    break;
                // Adicione mais casos conforme necessário para IDs específicos de MenuItem
            }
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
