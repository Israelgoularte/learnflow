package view.components.buttonAction;

import javafx.scene.control.TextField;
import controller.FacadeController;
import model.TemaModel;
import view.mensagens.ErrorView;

/**
 * Classe que define a ação de adicionar um arquivo para um botão.
 */
public class AdicionarArquivo implements MyVoidAction {
    private TemaModel tema;
    private String nomeArquivo;
    private String linkArquivo;

    /**
     * Constrói uma instância de AdicionarArquivo com o tema, nome do arquivo e link do arquivo especificados.
     *
     * @param tema o tema ao qual o arquivo será adicionado
     * @param nomeArquivo o nome do arquivo a ser adicionado
     * @param linkArquivo o link do arquivo a ser adicionado
     */
    public AdicionarArquivo(TemaModel tema, TextField nomeArquivo, TextField linkArquivo) {
        this.tema = tema;
        this.nomeArquivo = nomeArquivo.getText();
        this.linkArquivo = linkArquivo.getText();
    }

    /**
     * Executa a ação de adicionar um arquivo. Verifica se o nome do arquivo e o link do arquivo não são nulos ou vazios.
     * Se forem nulos ou vazios, exibe uma mensagem de erro informando que o nome ou link do arquivo é inválido.
     * Caso contrário, chama o método adicionarArquivos() da instância FacadeController, passando o tema, o nome do arquivo e o link do arquivo.
     * Se o arquivo for adicionado com sucesso, define o tema selecionado como o tema atual, exibe uma mensagem de sucesso
     * e navega para a página de detalhes do tema. Caso contrário, exibe uma mensagem de erro.
     */
    @Override
    public void active() {
        if (nomeArquivo == null || nomeArquivo.isEmpty()) {
            ErrorView.exibirMensagem("Adicionar Arquivo", "Nome do arquivo inválido");
        } else if (linkArquivo == null || linkArquivo.isEmpty()) {
            ErrorView.exibirMensagem("Adicionar Arquivo", "Link do arquivo inválido");
        } else {
            if (FacadeController.getInstance().adicionarArquivos(tema, nomeArquivo, linkArquivo)) {
                //FacadeController.getInstance().setTemaSelecionado(tema);
                new MudarPaginaAction("detalhes tema").active();
            } else {
                ErrorView.exibirMensagem("Error", "Erro ao adicionar o arquivo " + nomeArquivo);
            }
        }
    }
}
