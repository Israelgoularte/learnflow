package model;

import java.sql.SQLException;

import model.dao.DAOUpdate;

/**
 * Classe que representa o modelo FavoritosModel.
 */
public class FavoritosModel implements ModelInterface {

    private int temaId;
    private int usuarioId;

    /**
     * Construtor da classe FavoritosModel.
     * 
     * @param temaId    O ID do tema favorito.
     * @param usuarioId O ID do usuário associado ao tema favorito.
     */
    public FavoritosModel(int temaId, int usuarioId) {
        this.temaId = temaId;
        this.usuarioId = usuarioId;
    }

    public int getTemaId() {
        return temaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    /**
     * Verifica se o ID do tema é igual ao ID fornecido.
     * 
     * @param temaId O ID do tema a ser comparado.
     * @return true se o ID for igual, false caso contrário.
     */
    public boolean isMe(int temaId) {
        return temaId == this.temaId;
    }

    @Override
    public boolean atualizar() {
        return false;
    }

    @Override
    public boolean excluir() {
        String sql = "DELETE FROM learnflow.favoritos WHERE tema_id = ? AND usuario_id = ?;";
        try {
            return new DAOUpdate().setSQL(sql)
                    .setValue(this.temaId)
                    .setValue(this.usuarioId)
                    .build();
        } catch (SQLException error) {
            error.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insert() {
        String sql = "INSERT INTO learnflow.favoritos (tema_id, usuario_id) VALUES (?, ?);";
        try {
            return new DAOUpdate().setSQL(sql)
                    .setValue(this.temaId)
                    .setValue(this.usuarioId)
                    .build();
        } catch (SQLException error) {
            error.printStackTrace();
            return false;
        }
    }
}
