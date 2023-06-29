package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.scene.control.CheckBox;
import view.changeAppearence.Interface.AppearenceHandler;
import view.style.MyStyle;

public class CheckBoxAppearenceHandler extends AppearenceHandler {

    /**
     * Define o estilo para o elemento CheckBox do JavaFX.
     *
     * @param node o elemento CheckBox do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof CheckBox) {
            CheckBox checkBox = (CheckBox) node;
            switch (checkBox.getId()) {
                case "detalhes_tema_favoritos":
                    checkBox.setTextFill(MyStyle.getMyStyle().getTituloPrincipal());
                    break;
                // Definir estilo para CheckBox com ID "detalhes_tema_favoritos"
                case "checkBox1":
                    // Definir estilo para CheckBox com ID "checkBox1"
                    break;
                // Adicione mais casos conforme necessário para IDs específicos de CheckBox
            }
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
