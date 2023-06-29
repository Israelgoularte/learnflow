package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.scene.control.TextField;
import view.changeAppearence.Interface.AppearenceHandler;

/**
 * Classe concreta que implementa o manipulador de aparência para TextField do JavaFX.
 */
public class TextFieldAppearenceHandler extends AppearenceHandler {
    
    /**
     * Define o estilo para o TextField do JavaFX.
     *
     * @param node o elemento do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof TextField) {
            TextField textField = (TextField) node;
            switch (textField.getId()) {
                default:
                    // Sem caso de uso específico
                    break;
            }
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
