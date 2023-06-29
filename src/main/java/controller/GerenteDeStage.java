package controller;

import javafx.stage.Stage;

/**
 * A classe `GerenteDeStage` é responsável por gerenciar o objeto `Stage`
 * principal da aplicação.
 */
public class GerenteDeStage {

    private static Stage stage;

    /**
     * Define o `Stage` principal da aplicação.
     *
     * @param primaryStage O `Stage` principal.
     */
    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    /**
     * Retorna o `Stage` principal da aplicação.
     *
     * @return O `Stage` principal.
     */
    public static Stage getStage() {
        return stage;
    }
}
