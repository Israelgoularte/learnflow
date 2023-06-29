package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.scene.text.Text;
import view.changeAppearence.Interface.AppearenceHandler;

/**
 * Classe concreta que implementa o manipulador de aparência para Text do JavaFX.
 */
public class TextAppearenceHandler extends AppearenceHandler {
    
    /**
     * Define o estilo para o Text do JavaFX.
     *
     * @param node o elemento do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof Text) {
            Text text = (Text) node;
            switch (text.getId()) {
                case "detalhes_tema_nome_arquivo":
                    text.setWrappingWidth(300);
                    break;
                case "text1":
                    // Definir estilo para Text com ID "text1"
                    break;
                // Adicione mais casos conforme necessário para IDs específicos de Text
            }
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
