package view.components.buttonAction;

import javafx.scene.control.TextField;
import controller.FacadeController;
import view.mensagens.ErrorView;

/**
 * Classe que define a ação de adicionar um usuário para um botão.
 */
public class AdicionarUsuarioAction implements MyVoidAction {
    private TextField txtSenha;
    private TextField txtConfirmarSenha;
    private TextField txtEmail;
    private TextField txtNome;

    /**
     * Constrói uma instância de AdicionarUsuarioAction com os campos de senha, confirmar senha, email e nome especificados.
     *
     * @param txtSenha o campo de senha
     * @param txtConfirmarSenha o campo de confirmação de senha
     * @param txtEmail o campo de email
     * @param txtNome o campo de nome
     */
    public AdicionarUsuarioAction(TextField txtSenha, TextField txtConfirmarSenha, TextField txtEmail, TextField txtNome) {
        this.txtSenha = txtSenha;
        this.txtConfirmarSenha = txtConfirmarSenha;
        this.txtEmail = txtEmail;
        this.txtNome = txtNome;
    }

    /**
     * Executa a ação de adicionar um usuário. Verifica se a senha e a confirmação de senha coincidem.
     * Se coincidirem ou se a senha estiver vazia, tenta cadastrar o usuário chamando o método cadastrarUsuario()
     * da instância FacadeController, passando o nome, email e senha. Se o cadastro for realizado com sucesso,
     * exibe uma mensagem de sucesso e redireciona para a página de login. Caso contrário, exibe uma mensagem
     * de falha e limpa os campos de senha, confirmação de senha, email e nome. Se ocorrer uma exceção do tipo
     * IllegalArgumentException, exibe a mensagem de erro correspondente. Se as senhas não coincidirem,
     * exibe uma mensagem de erro e limpa os campos de senha e confirmação de senha.
     */
    @Override
    public void active() {
        if (txtConfirmarSenha.getText().equals(txtSenha.getText()) || txtSenha.getText().equals("")) {
            String email = txtEmail.getText();
            String nome = txtNome.getText();
            String senha = txtSenha.getText();
            try {
                if (FacadeController.getInstance().cadastrarUsuario(nome, email, senha)) {
                    ErrorView.exibirMensagem("Cadastro", "Cadastro realizado com sucesso");
                    new MudarPaginaAction("login").active();
                } else {
                    ErrorView.exibirMensagem("Cadastro", "Falha ao realizar cadastro");
                    txtSenha.setText("");
                    txtConfirmarSenha.setText("");
                    txtEmail.setText("");
                    txtNome.setText("");
                }
            } catch (IllegalArgumentException err) {
                ErrorView.exibirMensagem(err);
            }
        } else {
            ErrorView.exibirMensagem("Cadastro", "As Senhas não coincidem");
            txtSenha.setText("");
            txtConfirmarSenha.setText("");
        }
    }
}
