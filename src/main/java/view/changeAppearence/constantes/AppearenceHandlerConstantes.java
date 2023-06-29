package view.changeAppearence.constantes;

import view.changeAppearence.Interface.AppearenceHandler;
import view.changeAppearence.concretas.*;

/**
 * Classe que contém constantes para os manipuladores de aparência dos elementos do JavaFX.
 */
public class AppearenceHandlerConstantes {
    private static final BorderPaneAppearenceHandler borderPaneAppearenceHandler = new BorderPaneAppearenceHandler();
    private static final HBoxAppearenceHandler hBoxAppearenceHandler = new HBoxAppearenceHandler();
    private static final VBoxAppearenceHandler vBoxAppearenceHandler = new VBoxAppearenceHandler();
    private static final GridPaneAppearenceHandler gridPaneAppearenceHandler = new GridPaneAppearenceHandler();
    private static final LabelAppearenceHandler labelAppearenceHandler = new LabelAppearenceHandler();
    private static final ButtonAppearenceHandler buttonAppearenceHandler = new ButtonAppearenceHandler();
    private static final TextFieldAppearenceHandler textFieldAppearenceHandler = new TextFieldAppearenceHandler();
    private static final TextAreaAppearenceHandler textAreaAppearenceHandler = new TextAreaAppearenceHandler();
    private static final CheckBoxAppearenceHandler checkBoxAppearenceHandler = new CheckBoxAppearenceHandler();
    private static final RadioButtonAppearenceHandler radioButtonAppearenceHandler = new RadioButtonAppearenceHandler();
    private static final MenuBarAppearenceHandler menuBarAppearenceHandler = new MenuBarAppearenceHandler();
    private static final MenuAppearenceHandler menuAppearenceHandler = new MenuAppearenceHandler();
    private static final MenuItemAppearenceHandler menuItemAppearenceHandler = new MenuItemAppearenceHandler();
    private static final HyperLinkAppearenceHandler hyperLinkAppearenceHandler = new HyperLinkAppearenceHandler();
    private static final ImageViewAppearenceHandler imageViewAppearenceHandler = new ImageViewAppearenceHandler();
    private static final SliderAppearenceHandler sliderAppearenceHandler = new SliderAppearenceHandler();
    private static final ScrollPaneAppearenceHandler scrollPaneAppearenceHandler = new ScrollPaneAppearenceHandler();
    private static boolean loaded = false;

    private AppearenceHandlerConstantes() {
        // Construtor privado para evitar a criação de instâncias dessa classe
    }

    /**
     * Constrói a cadeia de manipuladores de aparência para os elementos do JavaFX.
     */
    private static void buildAppearenceHandlerConstants() {
        borderPaneAppearenceHandler.setNextAppearenceHandler(hBoxAppearenceHandler);
        hBoxAppearenceHandler.setNextAppearenceHandler(vBoxAppearenceHandler);
        vBoxAppearenceHandler.setNextAppearenceHandler(gridPaneAppearenceHandler);
        gridPaneAppearenceHandler.setNextAppearenceHandler(labelAppearenceHandler);
        labelAppearenceHandler.setNextAppearenceHandler(buttonAppearenceHandler);
        buttonAppearenceHandler.setNextAppearenceHandler(textFieldAppearenceHandler);
        textFieldAppearenceHandler.setNextAppearenceHandler(textAreaAppearenceHandler);
        textAreaAppearenceHandler.setNextAppearenceHandler(checkBoxAppearenceHandler);
        checkBoxAppearenceHandler.setNextAppearenceHandler(radioButtonAppearenceHandler);
        radioButtonAppearenceHandler.setNextAppearenceHandler(menuBarAppearenceHandler);
        menuBarAppearenceHandler.setNextAppearenceHandler(menuAppearenceHandler);
        menuAppearenceHandler.setNextAppearenceHandler(menuItemAppearenceHandler);
        menuItemAppearenceHandler.setNextAppearenceHandler(hyperLinkAppearenceHandler);
        hyperLinkAppearenceHandler.setNextAppearenceHandler(imageViewAppearenceHandler);
        imageViewAppearenceHandler.setNextAppearenceHandler(sliderAppearenceHandler);
        sliderAppearenceHandler.setNextAppearenceHandler(scrollPaneAppearenceHandler);
        scrollPaneAppearenceHandler.setNextAppearenceHandler(null);
        loaded = true;
    }

    /**
     * Obtém o manipulador de aparência inicial para os elementos do JavaFX.
     * 
     * @return o manipulador de aparência inicial
     */
    public synchronized static AppearenceHandler getAppearenceHandler() {
        if (!loaded) {
            buildAppearenceHandlerConstants();
        }
        return borderPaneAppearenceHandler;
    }
}
