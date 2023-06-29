package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.changeAppearence.Interface.AppearenceHandler;

public class TextAreaAppearenceHandler extends AppearenceHandler {

    /**
     * Define o estilo para o elemento TextArea do JavaFX.
     *
     * @param node o elemento TextArea do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof TextArea) {
            TextArea textArea = (TextArea) node;
            switch (textArea.getId()) {
                case "detalhes_tema_descricao":
                    textArea.setWrapText(true);
                    textArea.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 16.0));
                    textArea.setEditable(false);
                    break;
                case "textArea1":
                    // Definir estilo para TextArea com ID "textArea1"
                    break;
                default:
                    // Definir estilo para TextArea sem ID específico
                    break;
                // Adicione mais casos conforme necessário para IDs específicos de TextArea
            }
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
