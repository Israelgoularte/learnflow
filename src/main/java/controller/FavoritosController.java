package controller;

import model.FavoritosModel;
import model.TemaModel;
import model.UsuarioModel;
import model.modalList.FavoritosModelList;

/**
 * A classe `FavoritosController` é responsável por gerenciar as operações
 * relacionadas aos favoritos do usuário.
 */
public class FavoritosController {

    /**
     * Verifica se um determinado tema é favorito.
     *
     * @param tema O tema a ser verificado.
     * @return true se o tema é favorito, false caso contrário.
     */
    public static boolean isFavorito(TemaModel tema) {
        for (FavoritosModel favorito : FavoritosModelList.getInstance().getList()) {
            if (favorito.isMe(tema.getTemaId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona um tema aos favoritos do usuário.
     *
     * @param tema O tema a ser adicionado aos favoritos.
     * @return true se o tema foi adicionado com sucesso, false caso contrário.
     */
    public static boolean adicionarFavorito(TemaModel tema) {
        if (isFavorito(tema)) {
            // ErrorView.showErrorMenssager("Adicionar Favorito", "Tema já é um favorito",
            // "");
        } else {
            FavoritosModel favorito = new FavoritosModel(tema.getTemaId(), UsuarioModel.getInstance().getId_usuario());
            if (favorito.insert()) {
                FavoritosModelList.getInstance().add(favorito);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove um tema dos favoritos do usuário.
     *
     * @param tema O tema a ser removido dos favoritos.
     * @return true se o tema foi removido com sucesso, false caso contrário.
     */
    public static boolean removerFavorito(TemaModel tema) {
        try {
            FavoritosModel favorito = encontraFavoritosModel(tema.getTemaId());
            if (favorito.excluir()) {
                FavoritosModelList.getInstance().getList().remove(favorito);
                return true;
            } else
                return false;
        } catch (IllegalArgumentException error) {
            // ErrorView.showErrorMenssager("Remover Favoritos", error.getMessage(),
            // error.getLocalizedMessage());
            return false;
        }
    }

    /**
     * Encontra o modelo de favoritos para um determinado ID de tema.
     *
     * @param idTema O ID do tema.
     * @return O modelo de favoritos correspondente.
     * @throws IllegalArgumentException Se o tema não for encontrado nos favoritos.
     */
    public static FavoritosModel encontraFavoritosModel(int idTema) throws IllegalArgumentException {
        for (FavoritosModel temaUsuario : FavoritosModelList.getInstance().getList()) {
            if (temaUsuario.isMe(idTema)) {
                return temaUsuario;
            }
        }
        throw new IllegalArgumentException("Tema não é um favorito");
    }

    /**
     * Reinicializa a lista de favoritos.
     */
    public static void reinicializar() {
        FavoritosModelList.getInstance().reinicializar();
    }
}
