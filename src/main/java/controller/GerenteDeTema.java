package controller;

import java.util.LinkedList;

import model.TemaModel;

/**
 * A classe `GerenteDeTema` é responsável por gerenciar a seleção e operações
 * relacionadas aos temas.
 */
public class GerenteDeTema {

    private static LinkedList<TemaModel> listaDeSeleção = new LinkedList<>();

    /**
     * Seleciona um tema.
     *
     * @param tema O tema a ser selecionado.
     */
    public static void selecionarTema(TemaModel tema) {
        listaDeSeleção.add(tema);
    }

    /**
     * Retorna o tema selecionado mais recentemente.
     *
     * @return O tema selecionado mais recente.
     */
    public static TemaModel getTemaSelecionado() {
        if (listaDeSeleção.isEmpty()) {
            return null;
        } else {
            return listaDeSeleção.getLast();
        }
    }

    /**
     * Inicializa o gerenciador de temas, limpando a lista de seleção.
     */
    public static void inicializar() {
        listaDeSeleção = new LinkedList<>();
    }

    /**
     * Volta para o tema anteriormente selecionado.
     *
     * @return `true` se ainda há temas na lista de seleção, caso contrário,
     *         `false`.
     */
    public static boolean voltarTema() {
        listaDeSeleção.removeLast();
        return !listaDeSeleção.isEmpty();
    }

    /**
     * Retorna uma lista de temas favoritos a partir de uma lista de temas.
     *
     * @param temas A lista de temas.
     * @return A lista de temas favoritos.
     */
    public static LinkedList<TemaModel> getFavoritos(LinkedList<TemaModel> temas) {
        LinkedList<TemaModel> favoritos = new LinkedList<>();
        for (TemaModel tema : temas) {
            if (FavoritosController.isFavorito(tema)) {
                favoritos.add(tema);
            }
        }
        return favoritos;
    }

    /**
     * Retorna uma lista de temas não favoritos a partir de uma lista de temas.
     *
     * @param temas A lista de temas.
     * @return A lista de temas não favoritos.
     */
    public static LinkedList<TemaModel> getNaoFavoritos(LinkedList<TemaModel> temas) {
        LinkedList<TemaModel> naoFavoritos = new LinkedList<>();

        for (TemaModel tema : temas) {
            if (!FavoritosController.isFavorito(tema)) {
                naoFavoritos.add(tema);
            }
        }
        return naoFavoritos;
    }
}
