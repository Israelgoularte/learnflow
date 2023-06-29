package view.mensagens;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertView {

    /**
     * Exibe uma mensagem de confirmação.
     *
     * @param titulo   o título da mensagem
     * @param mensagem o conteúdo da mensagem
     * @return true se o botão "Confirmar" for clicado, false caso contrário
     */
    public static boolean exibirMensagem(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(mensagem);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().add(new ButtonType("Confirmar"));
        alert.getButtonTypes().add(new ButtonType("Cancelar"));
        if (alert.showAndWait().get().getText().equals("Confirmar")) {
            return true;
        } else {
            return false;
        }
    }
}
