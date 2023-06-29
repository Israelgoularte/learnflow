package view.paginas;

import java.util.LinkedList;

import javafx.css.Styleable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.ScreanSize;
import view.changeAppearence.ChangeAppearenceThread;
import view.components.ComponentsAbstractFactory;

public abstract class Pagina {
    // Classe que estende essa classe deve ser responsável por criar a cena;
    protected Parent root;

    protected Pagina() {
    }

    /**
     * Método abstrato para criar o nó raiz da página.
     *
     * @return true se o nó raiz foi criado com sucesso, caso contrário, false
     */
    protected abstract boolean criarRoot();

    /**
     * Método template para inicializar a página.
     *
     * @param primaryStage o estágio primário para exibir a cena da página
     */
    public void inicialiarPagina(Stage primaryStage) {
        double width = ScreanSize.getInstance().getWidth();
        double height = ScreanSize.getInstance().getHeight();
        ComponentsAbstractFactory.factory.reinicializarComponentsList();
        if (criarRoot()) {
            estilizaPagina();
            primaryStage.setScene(new Scene(root, width, height));
            primaryStage.show();
        } else {
            // ErrorView.showErrorMenssager("Error", "Erro ao criar Pagina", "");
        }
    }

    /**
     * Aplica estilos à página.
     */
    public void estilizaPagina() {
        LinkedList<Thread> threads = new LinkedList<>();
        for (Styleable styleable : ComponentsAbstractFactory.factory.getComponents()) {
            Thread nova = new ChangeAppearenceThread(styleable);
            threads.add(nova);
            nova.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException erro) {
                System.out.println(erro.getMessage() + "  " + erro.getCause());
            }
        }
    }
}
