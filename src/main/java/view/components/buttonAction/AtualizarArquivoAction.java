package view.components.buttonAction;

import javafx.scene.control.TextField;
import controller.FacadeController;
import model.ArquivosModel;

/**
 * Classe que define a ação de atualizar um arquivo para um botão.
 */
public class AtualizarArquivoAction implements MyBooleanAction {
    private ArquivosModel arquivo;
    private TextField nome;
    private TextField link;

    /**
     * Constrói uma instância de AtualizarArquivoAction com o arquivo, campo de nome e campo de link especificados.
     *
     * @param arquivo o arquivo a ser atualizado
     * @param nome o campo de nome do arquivo
     * @param link o campo de link do arquivo
     */
    public AtualizarArquivoAction(ArquivosModel arquivo, TextField nome, TextField link) {
        this.arquivo = arquivo;
        this.nome = nome;
        this.link = link;
    }

    /**
     * Executa a ação de atualizar o arquivo. Chama o método atualizarArquivo() da instância FacadeController,
     * passando o arquivo, o texto do campo de nome e o texto do campo de link. Retorna true se o arquivo foi
     * atualizado com sucesso, ou false caso contrário.
     *
     * @return true se o arquivo foi atualizado com sucesso, false caso contrário
     */
    @Override
    public boolean booleanAction() {
        return FacadeController.getInstance().atualizarArquivo(arquivo, nome.getText(), link.getText());
    }
}
