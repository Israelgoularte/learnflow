package model.modalList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.ArquivosModel;
import model.UsuarioModel;
import model.dao.DAOBuscas;

/**
 * Classe singleton que representa uma lista de objetos ArquivosModel.
 * Responsável por carregar os dados dos arquivos do banco de dados para a lista.
 */
public class ArquivoModelList extends ModelListInterface<ArquivosModel> {

    private ArquivoModelList() {
    }

    private static ArquivoModelList instance;

    /**
     * Obtém a instância única da classe ArquivoModelList.
     *
     * @return A instância única da classe ArquivoModelList.
     */
    public static ArquivoModelList getInstance() {
        if (instance == null) {
            instance = new ArquivoModelList();
        }
        return instance;
    }

    @Override
    public void carregarDados() {
        this.list = new LinkedList<>();
        String sql = "SELECT * FROM arquivos WHERE usuario_id = ?;";
        try {
            ResultSet retornoBD = new DAOBuscas()
                    .setSQL(sql)
                    .setValue(UsuarioModel.getInstance().getId_usuario())
                    .build();
            while (retornoBD.next()) {
                ArquivosModel novo = new ArquivosModel(
                        retornoBD.getInt("id"),
                        retornoBD.getInt("tema_id"),
                        retornoBD.getDate("data_criacao"),
                        retornoBD.getString("nome"),
                        retornoBD.getString("link"));
                list.add(novo);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

}
