package view.components.buttonAction;

import controller.FacadeController;
import model.TemaModel;
import view.mensagens.AlertView;

/**
 * Classe que define a ação de excluir um tema para um botão.
 */
public class ExcluirTemaAction implements MyVoidAction {
    private TemaModel tema;

    /**
     * Constrói um ExcluirTemaAction com o tema especificado.
     * 
     * @param tema o tema a ser excluído
     */
    public ExcluirTemaAction(TemaModel tema) {
        this.tema = tema;
    }

    /**
     * Executa a ação de exclusão do tema.
     * Se o tema não foi selecionado, exibe uma mensagem informando.
     * Se o usuário confirmar a exclusão, tenta remover o tema.
     * Se a remoção for bem-sucedida, exibe uma mensagem informando.
     * Caso contrário, exibe uma mensagem de erro.
     */
    @Override
    public void active() {
        if (tema == null) {
            // Mensagem informando que o tema não foi selecionado
            return;
        }

        if (AlertView.exibirMensagem("Excluir Tema", "Remover " + tema.getNome())) {
            if (FacadeController.getInstance().removerTema(tema)) {
                System.out.println("Tema removido");
                // Mensagem informando que o tema foi removido com sucesso
            } else {
                // Mensagem informando que ocorreu um erro ao remover o tema
            }
        }
    }
}
