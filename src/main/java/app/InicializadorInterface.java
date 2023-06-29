package app;
import javafx.stage.Stage;
import view.paginas.Pagina;
import view.windowsLayout.WindowsLayout;

public abstract class InicializadorInterface {

    /**
     * Método de template para inicializar o aplicativo.
     *
     * @param primaryStage O estágio primário do JavaFX.
     */
    public void inicializar(Stage primaryStage) {
        createAcessController(primaryStage);
        createWindowsLayout().customize(primaryStage);
        createFirstPage().inicialiarPagina(primaryStage);
    }

    /**
     * Cria um objeto WindowsLayout que define a personalização da janela.
     *
     * @return O objeto WindowsLayout personalizado.
     */
    public abstract WindowsLayout createWindowsLayout();

    /**
     * Cria a primeira página do aplicativo.
     *
     * @return A primeira página do aplicativo.
     */
    public abstract Pagina createFirstPage();

    /**
     * Cria o controlador de acesso para a aplicação.
     *
     * @param primaryStage O estágio primário do JavaFX.
     */
    public abstract void createAcessController(Stage primaryStage);
}
