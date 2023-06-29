package model.dao;

import java.sql.SQLException;

/**
 * Classe que representa uma operação de atualização no banco de dados.
 */
public class DAOUpdate extends DAOInterface<Boolean> {

    /**
     * Constrói um objeto Boolean a partir dos resultados da atualização.
     *
     * @return true se a atualização for bem-sucedida, caso contrário false.
     * @throws SQLException Se ocorrer um erro de SQL.
     */
    @Override
    public Boolean build() throws SQLException {
        if (super.stmt.executeUpdate()  > 0) {
            return true;
        } else {
            return false;
        }
    }

}
