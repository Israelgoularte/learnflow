package app;
import javafx.stage.Stage;
import view.paginas.Pagina;
import view.paginas.factory.PaginaSimpleFactory;
import view.windowsLayout.LearnFlowWindowsLayout;
import view.windowsLayout.WindowsLayout;
import controller.FacadeController;

public class LearnFlowInicializador extends InicializadorInterface {

    /**
     * Cria o layout da janela do aplicativo.
     *
     * @return O objeto WindowsLayout que define a personalização da janela.
     */
    public WindowsLayout createWindowsLayout() {
        return new LearnFlowWindowsLayout();
    }

    /**
     * Cria a primeira página do aplicativo.
     *
     * @return A primeira página do aplicativo.
     */
    public Pagina createFirstPage() {
        return PaginaSimpleFactory.create("login");
    }

    /**
     * Cria o controlador de acesso para a aplicação.
     *
     * @param primaryStage O estágio primário do JavaFX.
     */
    public void createAcessController(Stage primaryStage) {
        FacadeController.getInstance().setStage(primaryStage);
    }
}
