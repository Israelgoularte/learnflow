package view.mensagens;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.text.Text;

public class DialogView {
    
    /**
     * Exibe uma mensagem em um diálogo de alerta.
     *
     * @param titulo   o título do diálogo
     * @param mensagem o conteúdo da mensagem
     */
    public static void exibirMensagem(String titulo, String mensagem) {
        Dialog<ButtonType> dialog = new Dialog<>();
        Text texto = new Text(mensagem);
        texto.setWrappingWidth(400);
        dialog.setTitle(titulo);
        dialog.setContentText(mensagem);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
        dialog.show();
    }
}
