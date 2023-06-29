package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import view.mensagens.ErrorView;

/**
 * Classe singleton para gerenciar a conexão com o banco de dados.
 */
public class ConexaoDBSingleton {

    private static ConexaoDBSingleton instance;
    private final String url = "jdbc:postgresql://babar.db.elephantsql.com:5432/mokidkuu";
    private final String usuario = "mokidkuu";
    private final String senha = "r2CYt7hT3JgPSq9XpuM4B9PrpJjsnt1P";
    private Connection connection;

    private ConexaoDBSingleton() {
        // construtor privado para impedir instanciação direta
    }

    /**
     * Obtém a instância da conexão com o banco de dados.
     *
     * @return A instância da conexão com o banco de dados.
     */
    public synchronized static ConexaoDBSingleton getInstance() {
        if (instance == null) {
            instance = new ConexaoDBSingleton();
        }
        return instance;
    }

    /**
     * Obtém a conexão com o banco de dados.
     *
     * @return A conexão com o banco de dados.
     */
    public synchronized Connection getConnection() {
        if (connection == null) {
            try {
                this.connection = DriverManager.getConnection(url, usuario, senha);
                this.connection.setSchema("learnflow");
            } catch (SQLException e) {
                ErrorView.exibirMensagem(e);
            }
        }
        notify();
        return connection;
    }

}
