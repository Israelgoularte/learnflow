package view.components.buttonAction;

import controller.FacadeController;
import model.TemaModel;
import view.mensagens.DialogView;
import view.mensagens.ErrorView;

/**
 * Classe que define a ação de atualizar um tema para um botão.
 */
public class AtualizarTemaAction implements MyBooleanAction {
    private TemaModel tema;
    private String novaDescricao;
    private String nome;

    /**
     * Constrói um AtualizarTemaAction com o tema, a nova descrição e o nome especificados.
     * 
     * @param tema           o tema a ser atualizado
     * @param novaDescricao  a nova descrição do tema
     * @param nome           o novo nome do tema
     */
    public AtualizarTemaAction(TemaModel tema, String novaDescricao, String nome) {
        this.tema = tema;
        this.novaDescricao = novaDescricao;
        this.nome = nome;
    }

    /**
     * Executa a ação de atualizar o tema.
     * 
     * @return true se o tema foi atualizado com sucesso, false caso contrário.
     */
    @Override
    public boolean booleanAction() {
        if (FacadeController.getInstance().atualizarTema(tema, nome, novaDescricao)) {
            DialogView.exibirMensagem("Learn Flow", "Tema atualizado com sucesso");
            return true;
        } else {
            ErrorView.exibirMensagem("Atualizar Tema", "Não foi possível atualizar o tema " + tema.getNome());
            return false;
        }
    }
}
