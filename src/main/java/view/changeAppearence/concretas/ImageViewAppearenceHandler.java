package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.scene.image.ImageView;
import view.changeAppearence.Interface.AppearenceHandler;

/**
 * Classe concreta que implementa o manipulador de aparência para ImageView do JavaFX.
 */
public class ImageViewAppearenceHandler extends AppearenceHandler {

    /**
     * Define o estilo para o ImageView do JavaFX.
     *
     * @param node o elemento do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof ImageView) {
            ImageView imageView = (ImageView) node;
            switch (imageView.getId()) {
                case "":
                    // Definir estilo para ImageView sem ID específico
                    break;
                case "imageView1":
                    // Definir estilo para ImageView com ID "imageView1"
                    break;
                // Adicione mais casos conforme necessário para IDs específicos de ImageView
            }
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
