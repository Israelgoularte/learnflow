package view.components.buttonAction;

import controller.FacadeController;
import model.ArquivosModel;
import view.mensagens.AlertView;

/**
 * Implementação da interface MyBooleanAction que realiza a ação de exclusão de arquivo.
 */
public class ExcluirArquivo implements MyBooleanAction {
    private ArquivosModel arquivo;

    /**
     * Constrói um ExcluirArquivo com o arquivo especificado.
     * 
     * @param arquivo o arquivo a ser excluído
     */
    public ExcluirArquivo(ArquivosModel arquivo) {
        this.arquivo = arquivo;
    }

    /**
     * Realiza a ação de exclusão do arquivo. Exibe uma mensagem de confirmação e,
     * se confirmado, chama o FacadeController para remover o arquivo. Retorna
     * true se o arquivo foi removido com sucesso, false caso contrário.
     * 
     * @return true se o arquivo foi removido com sucesso, false caso contrário
     */
    @Override
    public boolean booleanAction() {
        if (AlertView.exibirMensagem("Atenção", "Confirma a exclusão do Arquivo?")) {
            if (FacadeController.getInstance().removerArquivo(arquivo)) {
                return true;
            }
        }
        return false;
    }
}
