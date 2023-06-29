package model.modalList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.TemaModel;
import model.UsuarioModel;
import model.dao.DAOBuscas;

/**
 * Classe que representa uma lista de modelos TemaModel.
 */
public class TemaModelList extends ModelListInterface<TemaModel> {

    private static TemaModelList instance;

    private TemaModelList() {
    }

    /**
     * Obtém a instância única da lista TemaModelList.
     *
     * @return A instância única da lista TemaModelList.
     */
    public static TemaModelList getInstance() {
        if (instance == null) {
            instance = new TemaModelList();
        }
        return instance;
    }

    @Override
    public void carregarDados() {
        this.list = new LinkedList<>();
        try {
            String sql = "SELECT * FROM learnflow.tema WHERE usuario_id = ?";
            ResultSet retornoBD = new DAOBuscas()
                    .setSQL(sql)
                    .setValue(UsuarioModel.getInstance().getId_usuario())
                    .build();
            while (retornoBD.next()) {
                TemaModel novo = new TemaModel(
                        retornoBD.getInt("id"),
                        retornoBD.getString("nome"),
                        retornoBD.getString("descricao"),
                        retornoBD.getInt("tema_dependente_id"));
                list.add(novo);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

}
