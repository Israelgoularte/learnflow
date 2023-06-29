package view.changeAppearence;

import javafx.css.Styleable;
import view.changeAppearence.constantes.AppearenceHandlerConstantes;

/**
 * Classe que representa uma thread para alterar a aparência de um componente JavaFX.
 */
public class ChangeAppearenceThread extends Thread {
    private Styleable component;

    /**
     * Construtor da classe ChangeAppearenceThread.
     *
     * @param component o componente JavaFX cuja aparência será alterada
     */
    public ChangeAppearenceThread(Styleable component) {
        this.component = component;
    }

    /**
     * Executa a thread para alterar a aparência do componente JavaFX.
     */
    @Override
    public void run() {
        AppearenceHandlerConstantes.getAppearenceHandler().setStyle(component);
    }
}
