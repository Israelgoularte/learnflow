package view.components.buttonAction;

import javafx.scene.control.TextField;
import view.mensagens.ErrorView;
import view.paginas.factory.PaginaSimpleFactory;
import controller.FacadeController;

/**
 * Implementação da interface MyVoidAction que realiza a ação de login.
 */
public class LoginAction implements MyVoidAction {
    private TextField email;
    private TextField senha;

    /**
     * Constrói um LoginAction com os campos de texto de email e senha especificados.
     * 
     * @param email o campo de texto de email
     * @param senha o campo de texto de senha
     */
    public LoginAction(TextField email, TextField senha) {
        this.email = email;
        this.senha = senha;
    }

    /**
     * Realiza a ação de login com base no email e senha inseridos.
     * Se o email ou senha estiver vazio, uma mensagem de erro é exibida.
     * Se o login for bem-sucedido, a página inicial é inicializada.
     * Se o login falhar, uma mensagem de erro é exibida e os campos de texto são limpos.
     */
    @Override
    public void active() {
        if (email.getText().isEmpty()) {
            ErrorView.exibirMensagem("Login", "Digite o email");
            email.setFocusTraversable(true);
        } else if (senha.getText().isEmpty()) {
            ErrorView.exibirMensagem("Login", "Digite a senha");
            senha.setFocusTraversable(true);
        } else {
            if (FacadeController.getInstance().login(email.getText(), senha.getText())) {
                FacadeController.getInstance().recarregarDados();

                PaginaSimpleFactory.create("home")
                        .inicialiarPagina(FacadeController.getInstance().getStage());
            } else {
                ErrorView.exibirMensagem("Login", "Email ou senha incorretos");
                email.setText("");
                senha.setText("");
            }
        }
    }
}
