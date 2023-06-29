package view.components.buttonAction;

import model.UsuarioModel;

/**
 * Classe que define a ação de logout para um botão.
 */
public class LogoutAction implements MyVoidAction {

    /**
     * Executa a ação de logout, chamando o método estático `logout()` da classe `UsuarioModel`,
     * e em seguida, cria uma instância de `MudarPaginaAction` com o nome "login" e chama o método `active()` dela.
     */
    @Override
    public void active() {
        UsuarioModel.logout();
        new MudarPaginaAction("login").active();
    }
}
