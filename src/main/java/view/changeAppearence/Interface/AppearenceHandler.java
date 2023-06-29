package view.changeAppearence.Interface;

import javafx.css.Styleable;

/**
 * Classe abstrata que define o contrato para os manipuladores de aparência dos elementos do JavaFX.
 */
public abstract class AppearenceHandler {
    protected AppearenceHandler nextAppearenceHandler;

    /**
     * Define o estilo para o elemento do JavaFX.
     * 
     * @param node o elemento do JavaFX a ser estilizado
     */
    public abstract void setStyle(Styleable node);

    /**
     * Define o próximo manipulador de aparência na cadeia.
     * 
     * @param appearenceHandler o próximo manipulador de aparência
     */
    public void setNextAppearenceHandler(AppearenceHandler appearenceHandler) {
        this.nextAppearenceHandler = appearenceHandler;
    }
}
