package app;

import javafx.application.Application;
import javafx.stage.Stage;

public class LearnFlow extends Application {

    /**
     * Método principal que inicia a aplicação JavaFX.
     *
     * @param args Os argumentos da linha de comando.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Método chamado quando a aplicação é iniciada.
     * Cria uma instância de LearnFlowInicializador e chama o método inicializar().
     *
     * @param primaryStage O palco primário do JavaFX.
     */
    @Override
    public void start(Stage primaryStage) {
        new LearnFlowInicializador().inicializar(primaryStage);
    }
}
