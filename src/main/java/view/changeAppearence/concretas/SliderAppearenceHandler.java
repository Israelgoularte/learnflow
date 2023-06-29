package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.scene.control.Slider;
import view.changeAppearence.Interface.AppearenceHandler;

public class SliderAppearenceHandler extends AppearenceHandler {

    /**
     * Define o estilo para o elemento Slider do JavaFX.
     *
     * @param node o elemento Slider do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof Slider) {
            Slider slider = (Slider) node;
            switch (slider.getId()) {
                case "":
                    // Definir estilo para Slider sem ID específico
                    break;
                case "slider1":
                    // Definir estilo para Slider com ID "slider1"
                    break;
                default:
                    // Definir estilo para Slider sem ID específico
                    break;
                // Adicione mais casos conforme necessário para IDs específicos de Slider
            }
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
