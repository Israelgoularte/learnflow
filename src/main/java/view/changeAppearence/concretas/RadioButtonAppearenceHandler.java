package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import view.changeAppearence.Interface.AppearenceHandler;
import view.style.MyStyle;

public class RadioButtonAppearenceHandler extends AppearenceHandler {

    /**
     * Define o estilo para o elemento RadioButton do JavaFX.
     *
     * @param node o elemento RadioButton do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof RadioButton) {
            RadioButton radioButton = (RadioButton) node;
            switch (radioButton.getId()) {
                case "primary":
                    radioButton.setTextFill(MyStyle.getMyStyle().getTituloPrincipal());
                    radioButton.setPadding(new Insets(10));
                    // Definir estilo para RadioButton com ID "primary"
                    break;
                case "detalhes_tema_editar_arquivo":
                    radioButton.setPadding(new Insets(10));
                    // Definir estilo para RadioButton com ID "detalhes_tema_editar_arquivo"
                    break;
                default:
                    // Definir estilo para RadioButton sem ID específico
                    break;
                // Adicione mais casos conforme necessário para IDs específicos de RadioButton
            }
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
