package model.modalList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.FavoritosModel;
import model.UsuarioModel;
import model.dao.DAOBuscas;

/**
 * Classe singleton que representa uma lista de objetos FavoritosModel.
 * Responsável por carregar os dados dos favoritos do banco de dados para a lista.
 */
public class FavoritosModelList extends ModelListInterface<FavoritosModel> {
    private static FavoritosModelList instance;

    private FavoritosModelList() {
    }

    /**
     * Obtém a instância única da classe FavoritosModelList.
     *
     * @return A instância única da classe FavoritosModelList.
     */
    public static FavoritosModelList getInstance() {
        if (instance == null) {
            instance = new FavoritosModelList();
        }
        return instance;
    }

    @Override
    public void carregarDados() {
        this.list = new LinkedList<>();
        String sql = "SELECT * FROM learnflow.favoritos WHERE usuario_id = ?;";
        try {
            ResultSet retornoBd = new DAOBuscas()
                    .setSQL(sql)
                    .setValue(UsuarioModel.getInstance().getId_usuario())
                    .build();
            while (retornoBd.next()) {
                FavoritosModel f = new FavoritosModel(retornoBd.getInt("tema_id"), retornoBd.getInt("usuario_id"));
                this.add(f);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }
}
