package view.changeAppearence.factory;

import view.changeAppearence.Interface.AppearenceHandler;
import view.changeAppearence.concretas.*;

/**
 * Uma fábrica para criar instâncias de manipuladores de aparência para elementos do JavaFX.
 */
public class AppearenceHandlerFactory {
    
    /**
     * Cria um manipulador de aparência com base no modelo fornecido.
     * 
     * @param model o modelo do elemento do JavaFX
     * @return um manipulador de aparência para o modelo especificado, ou null se o modelo não for reconhecido
     */
    public static AppearenceHandler create(String model) {
        if (model.equalsIgnoreCase("HBox")) {
            return new HBoxAppearenceHandler();
        } else if (model.equalsIgnoreCase("VBox")) {
            return new VBoxAppearenceHandler();
        } else if (model.equalsIgnoreCase("BorderPane")) {
            return new BorderPaneAppearenceHandler();
        } else if (model.equalsIgnoreCase("GridPane")) {
            return new GridPaneAppearenceHandler();
        } else if (model.equalsIgnoreCase("Label")) {
            return new LabelAppearenceHandler();
        } else if (model.equalsIgnoreCase("Button")) {
            return new ButtonAppearenceHandler();
        } else if (model.equalsIgnoreCase("TextField")) {
            return new TextFieldAppearenceHandler();
        } else if (model.equalsIgnoreCase("TextArea")) {
            return new TextAreaAppearenceHandler();
        } else if (model.equalsIgnoreCase("CheckBox")) {
            return new CheckBoxAppearenceHandler();
        } else if (model.equalsIgnoreCase("RadioButton")) {
            return new RadioButtonAppearenceHandler();
        } else if (model.equalsIgnoreCase("ImageView")) {
            return new ImageViewAppearenceHandler();
        } else if (model.equalsIgnoreCase("Slider")) {
            return new SliderAppearenceHandler();
        }
        
        return null; // Retorna null caso o modelo não seja reconhecido
    }
}
