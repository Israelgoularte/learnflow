package model.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UsuarioModel;

/**
 * Classe responsável por realizar operações de acesso aos dados do usuário no banco de dados.
 */
public class UsuarioDAO {

    /**
     * Realiza o login do usuário com o email e senha fornecidos.
     *
     * @param email     O email do usuário.
     * @param senhaHash A senha criptografada do usuário.
     * @return Um objeto ResultSet contendo os dados do usuário, se o login for bem-sucedido, caso contrário null.
     * @throws SQLException Se ocorrer um erro de SQL.
     */
    public ResultSet login(String email, String senhaHash) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
        PreparedStatement stmt = ConexaoDBSingleton.getInstance().getConnection().prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, senhaHash);
        // ConexaoDBSingleton.getInstance().fecharConexao();
        return stmt.executeQuery();
    }

    /**
     * Cadastra um novo usuário com o nome, email e senha fornecidos.
     *
     * @param nome      O nome do usuário.
     * @param email     O email do usuário.
     * @param senhaHash A senha criptografada do usuário.
     * @return true se o cadastro for bem-sucedido, caso contrário false.
     * @throws SQLException Se ocorrer um erro de SQL.
     */
    public boolean cadastrarUsuario(String nome, String email, String senhaHash) throws SQLException {
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
        PreparedStatement stmt = ConexaoDBSingleton.getInstance().getConnection().prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setString(2, email);
        stmt.setString(3, senhaHash);
        int colunasAfetadas = stmt.executeUpdate();
        // ConexaoDBSingleton.getInstance().fecharConexao();
        return colunasAfetadas > 0;
    }

    /**
     * Atualiza o cadastro do usuário no banco de dados.
     *
     * @param user O objeto UsuarioModel contendo os novos dados do usuário.
     * @return true se a atualização for bem-sucedida, caso contrário false.
     * @throws SQLException Se ocorrer um erro de SQL.
     */
    public boolean atualizarCadastro(UsuarioModel user) throws SQLException {
        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?";
        PreparedStatement stmt = ConexaoDBSingleton.getInstance().getConnection().prepareStatement(sql);
        stmt.setString(1, user.getNome());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getHashSenha());
        stmt.setInt(4, user.getId_usuario());
        int colunasAfetadas = stmt.executeUpdate();
        // ConexaoDBSingleton.getInstance().fecharConexao();
        return colunasAfetadas > 0;
    }

    /**
     * Lista todos os usuários cadastrados no banco de dados.
     *
     * @return Um objeto ResultSet contendo os dados dos usuários.
     * @throws SQLException Se ocorrer um erro de SQL.
     */
    public ResultSet listarUsuario() throws SQLException {
        String sql = "SELECT * FROM usuario";
        PreparedStatement stmt = ConexaoDBSingleton.getInstance().getConnection().prepareStatement(sql);
        return stmt.executeQuery();
    }
}
