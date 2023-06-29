package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe DAO para realizar buscas no banco de dados.
 */
public class DAOBuscas extends DAOInterface<ResultSet> {

    /**
     * Constrói e executa a consulta no banco de dados.
     *
     * @return O resultado da consulta como um ResultSet.
     * @throws SQLException Se ocorrer um erro durante a execução da consulta.
     */
    @Override
    public ResultSet build() throws SQLException {
        return this.stmt.executeQuery();
    }

}
