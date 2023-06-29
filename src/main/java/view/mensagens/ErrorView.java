package view.mensagens;

import javafx.scene.control.Alert;

public class ErrorView {
    
    /**
     * Exibe uma mensagem de erro em um diálogo de alerta.
     *
     * @param titulo   o título do diálogo
     * @param mensagem a mensagem de erro
     */
    public static void exibirMensagem(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    /**
     * Exibe uma mensagem de erro em um diálogo de alerta.
     *
     * @param e a exceção que ocorreu
     */
    public static void exibirMensagem(Exception e) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(e.getClass().getSimpleName());
        alert.setHeaderText(null);
        alert.setContentText(e.getLocalizedMessage());
        alert.showAndWait();
    }
}
