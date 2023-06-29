package view.components.buttonAction;

import controller.FacadeController;
import view.mensagens.ErrorView;

/**
 * Classe que define a ação de adicionar um tema para um botão.
 */
public class AdicionarTemaAction implements MyVoidAction {
    private String nome;
    private Integer idTemaPai;

    /**
     * Constrói uma instância de AdicionarTemaAction com o nome e o ID do tema pai especificados.
     *
     * @param nome o nome do tema a ser adicionado
     * @param idTemaPai o ID do tema pai, ou null se não houver tema pai
     */
    public AdicionarTemaAction(String nome, Integer idTemaPai) {
        this.nome = nome;
        this.idTemaPai = idTemaPai;
    }

    /**
     * Executa a ação de adicionar um tema. Verifica se o nome do tema não é nulo.
     * Se não for nulo, chama o método adicionarNovoTema() da instância FacadeController,
     * passando o ID do tema pai e o nome do tema. Se o tema for adicionado com sucesso,
     * exibe uma mensagem de sucesso e recarrega os dados. Caso contrário, exibe uma mensagem
     * de falha. Se o nome do tema for nulo, exibe uma mensagem de erro informando que
     * nenhum nome para o tema foi informado.
     */
    @Override
    public void active() {
        if (nome != null) {
            if (FacadeController.getInstance().adicionarNovoTema(idTemaPai, nome)) {
                ErrorView.exibirMensagem("Adicionar Tema", "Tema: " + nome + " adicionado com sucesso");
                FacadeController.getInstance().recarregarDados();
            } else {
                ErrorView.exibirMensagem("Adicionar Tema", "Ocorreu um erro e o tema: " + nome + " não foi adicionado");
            }
        } else {
            ErrorView.exibirMensagem("Adicionar Tema", "Nenhum nome para o tema informado");
        }
    }
}
