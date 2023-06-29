package controller;

import java.sql.Date;
import java.util.LinkedList;

import model.ArquivosModel;
import model.TemaModel;
import model.modalList.ArquivoModelList;

/**
 * A classe ArquivosController é responsável por controlar as operações
 * relacionadas aos arquivos.
 */
public class ArquivosController {

    /**
     * Obtém uma lista de arquivos associados a um tema específico.
     *
     * @param tema O tema para o qual se deseja obter a lista de arquivos.
     * @return Uma lista encadeada de objetos ArquivosModel associados ao tema
     *         fornecido.
     */
    public static LinkedList<ArquivosModel> getListArquivos(TemaModel tema) {
        LinkedList<ArquivosModel> arquivos = new LinkedList<>();
        for (ArquivosModel arquivosModel : ArquivoModelList.getInstance().getList()) {
            if (arquivosModel.getTemaId() == tema.getTemaId())
                arquivos.add(arquivosModel);
        }
        return arquivos;
    }

    /**
     * Adiciona um novo arquivo associado a um tema.
     *
     * @param tema O tema ao qual o arquivo será associado.
     * @param nome O nome do arquivo.
     * @param link O link para o arquivo.
     * @return true se o arquivo foi adicionado com sucesso, false caso contrário.
     */
    public static boolean adicionarArquivo(TemaModel tema, String nome, String link) {
        ArquivosModel arquivosModel = new ArquivosModel(tema.getTemaId(), new Date(System.currentTimeMillis()), nome,
                link);
        if (arquivosModel.insert()) // caso verdadeiro o arquivo foi adicionado ao banco de dados, teve como retorno
                                    // o ID gerado pelo banco de dados e adicionado ao objeto.
        {
            ArquivoModelList.getInstance().add(arquivosModel);
            return true;
        } else
            return false;
    }

    /**
     * Remove um arquivo existente.
     *
     * @param arquivosModel O objeto ArquivosModel representando o arquivo a ser
     *                      removido.
     * @return true se o arquivo foi removido com sucesso, false caso contrário.
     */
    public static boolean removerArquivo(ArquivosModel arquivosModel) {
        if (arquivosModel.excluir()) {
            return ArquivoModelList.getInstance().remover(arquivosModel);
        } else
            return false;
    }

    /**
     * Atualiza as informações de um arquivo existente.
     *
     * @param arquivosModel O objeto ArquivosModel representando o arquivo a ser
     *                      atualizado.
     * @param nomeNovo      O novo nome do arquivo.
     * @param linkNovo      O novo link para o arquivo.
     * @return true se o arquivo foi atualizado com sucesso, false caso contrário.
     */
    public static boolean atualizarArquivo(ArquivosModel arquivosModel, String nomeNovo, String linkNovo) {
        String nomeAnterior = arquivosModel.getNome();
        String linkAnterior = arquivosModel.getLink();
        arquivosModel.setNome(nomeNovo);
        arquivosModel.setLink(linkNovo);
        if (arquivosModel.atualizar()) {
            return true;
        } else {
            arquivosModel.setNome(nomeAnterior);
            arquivosModel.setLink(linkAnterior);
            return false;
        }
    }
}
