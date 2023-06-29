package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.scene.control.PasswordField;
import view.changeAppearence.Interface.AppearenceHandler;

/**
 * Classe concreta que implementa o manipulador de aparência para PasswordField do JavaFX.
 */
public class PasswordFieldAppearenceHandler extends AppearenceHandler {
    
    /**
     * Define o estilo para o PasswordField do JavaFX.
     *
     * @param node o elemento do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof PasswordField) {
            PasswordField passwordField = (PasswordField) node;
            switch (passwordField.getId()) {
                case "":
                    // Definir estilo para PasswordField sem ID específico
                    break;
                case "passwordField1":
                    // Definir estilo para PasswordField com ID "passwordField1"
                    break;
                // Adicione mais casos conforme necessário para IDs específicos de PasswordField
            }
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
