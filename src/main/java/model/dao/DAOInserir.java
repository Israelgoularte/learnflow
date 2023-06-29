package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe DAO para realizar inserções no banco de dados.
 */
public class DAOInserir extends DAOInterface<Integer> {

    /**
     * Define a instrução SQL para a inserção.
     *
     * @param sql A instrução SQL.
     * @return A instância do DAOInserir.
     * @throws SQLException Se ocorrer um erro ao preparar a instrução SQL.
     */
    @Override
    public DAOInterface<Integer> setSQL(String sql) throws SQLException {
        this.stmt = ConexaoDBSingleton.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        return this;
    }

    /**
     * Constrói e executa a inserção no banco de dados.
     *
     * @return A chave gerada para a inserção.
     * @throws SQLException Se ocorrer um erro durante a execução da inserção.
     */
    @Override
    public Integer build() throws SQLException {
        super.stmt.executeUpdate();
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        } else {
            return -1;
        }
    }

}
