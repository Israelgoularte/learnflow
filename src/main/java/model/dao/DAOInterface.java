package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe abstrata que representa uma interface de DAO.
 *
 * @param <T> Tipo de objeto que será construído pelo DAO.
 */
public abstract class DAOInterface<T> {
    protected PreparedStatement stmt;
    private int index;

    /**
     * Construtor da classe DAOInterface.
     */
    public DAOInterface() {
        index = 1;
    }

    /**
     * Define a consulta SQL a ser executada.
     *
     * @param sql A consulta SQL.
     * @return A instância atual do DAOInterface.
     * @throws SQLException Se ocorrer um erro de SQL.
     */
    public DAOInterface<T> setSQL(String sql) throws SQLException {
        this.stmt = ConexaoDBSingleton.getInstance().getConnection().prepareStatement(sql);
        return this;
    }

    /**
     * Define um valor inteiro para o PreparedStatement.
     *
     * @param value O valor inteiro a ser definido.
     * @return A instância atual do DAOInterface.
     * @throws SQLException Se ocorrer um erro de SQL.
     */
    public DAOInterface<T> setValue(int value) throws SQLException {
        try {
            this.stmt.setInt(index, value);
        } catch (NullPointerException error) {
        }
        index++;
        return this;
    }

    /**
     * Define um valor de texto para o PreparedStatement.
     *
     * @param value O valor de texto a ser definido.
     * @return A instância atual do DAOInterface.
     * @throws SQLException Se ocorrer um erro de SQL.
     */
    public DAOInterface<T> setValue(String value) throws SQLException {
        try {
            this.stmt.setString(index, value);
        } catch (NullPointerException error) {
        }
        index++;

        return this;
    }

    /**
     * Define uma data para o PreparedStatement.
     *
     * @param date A data a ser definida.
     * @return A instância atual do DAOInterface.
     * @throws SQLException Se ocorrer um erro de SQL.
     */
    public DAOInterface<T> setValue(Date date) throws SQLException {
        try {
            this.stmt.setDate(index, date);
        } catch (NullPointerException error) {
        }
        index++;

        return this;
    }

    /**
     * Constrói o objeto T a partir do DAO.
     *
     * @return O objeto construído.
     * @throws SQLException Se ocorrer um erro de SQL.
     */
    public abstract T build() throws SQLException;
}
