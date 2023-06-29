package controller;

import java.util.LinkedList;

import model.TemaModel;
import model.modalList.TemaModelList;

/**
 * A classe `TemaController` é responsável por operações relacionadas aos temas.
 */
public class TemaController {

    /**
     * Retorna uma lista de temas principais.
     *
     * @return A lista de temas principais.
     */
    public static LinkedList<TemaModel> getTemasPrincipais() {
        LinkedList<TemaModel> temas = new LinkedList<>();
        LinkedList<TemaModel> todosTemas = TemaModelList.getInstance().getList();
        for (TemaModel temaModel : todosTemas) {
            if (temaModel.getTemaDependenteID() == null || temaModel.getTemaDependenteID() == 0) {
                temas.add(temaModel);
            }
        }
        return temas;
    }

    /**
     * Retorna uma lista de subtemas de um tema específico.
     *
     * @param tema O tema pai.
     * @return A lista de subtemas.
     */
    public static LinkedList<TemaModel> getSubTemas(TemaModel tema) {
        LinkedList<TemaModel> temas = new LinkedList<>();
        for (TemaModel temaModel : TemaModelList.getInstance().getList()) {
            if (temaModel.getTemaDependenteID() == tema.getTemaId()) {
                temas.add(temaModel);
            }
        }
        return temas;
    }

    /**
     * Adiciona um novo tema.
     *
     * @param nome         O nome do tema.
     * @param idDependente O ID do tema dependente, se houver. Caso contrário,
     *                     passar 0.
     * @return `true` se o tema foi adicionado com sucesso, caso contrário, `false`.
     */
    public static boolean adicionarNovoTema(String nome, Integer idDependente) {
        TemaModel novo = new TemaModel(0, nome, "", idDependente);
        if (novo.insert()) {
            return TemaModelList.getInstance().add(novo);
        } else {
            return false;
        }
    }

    /**
     * Atualiza um tema existente.
     *
     * @param tema      O tema a ser atualizado.
     * @param nome      O novo nome do tema.
     * @param descricao A nova descrição do tema.
     * @return `true` se o tema foi atualizado com sucesso, caso contrário, `false`.
     */
    public static boolean atualizarTema(TemaModel tema, String nome, String descricao) {
        String rollbackName = tema.getNome();
        String rollbackDescricao = tema.getDescricao();
        tema.setNome(nome);
        tema.setDescricao(descricao);
        if (tema.atualizar()) {
            return true;
        } else {
            tema.setNome(rollbackName);
            tema.setDescricao(rollbackDescricao);
            return false;
        }
    }

    /**
     * Remove um tema existente.
     *
     * @param tema O tema a ser removido.
     * @return `true` se o tema foi removido com sucesso, caso contrário, `false`.
     */
    public static boolean removerTema(TemaModel tema) {
        if (tema.excluir()) {
            return TemaModelList.getInstance().getList().remove(tema);
        } else {
            return false;
        }
    }

    /**
     * Carrega os dados dos temas.
     */
    public static void carregarTemas() {
        TemaModelList.getInstance().carregarDados();
    }

    /**
     * Reinicializa o gerenciador de temas.
     */
    public static void reinicializar() {
        TemaModelList.getInstance().reinicializar();
    }
}
