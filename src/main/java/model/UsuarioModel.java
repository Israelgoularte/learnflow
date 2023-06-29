package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.UsuarioDAO;

/**
 * Classe que representa o modelo de usuário (UsuarioModel).
 */
public class UsuarioModel {
    private int id_usuario;
    private String nome;
    private String email;
    private String hashSenha;
    private Date dataCadastro;
    private static UsuarioModel user;

    // Construtores
    private UsuarioModel() {
    }

    private UsuarioModel(int id_usuario, String nome, String email, String hashSenha, Date dataCadastro) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.email = email;
        this.hashSenha = hashSenha;
        this.dataCadastro = dataCadastro;
    }

    /**
     * Obtém a instância do usuário logado.
     *
     * @throws IllegalAccessError se o usuário não estiver logado
     * @return a instância do usuário logado
     */
    public static UsuarioModel getInstance() throws IllegalAccessError {
        if (user == null) {
            throw new IllegalAccessError("Efetue o login");
        } else {
            return user;
        }
    }

    /**
     * Realiza o login do usuário com o email e senha hash fornecidos.
     *
     * @param email     o email do usuário
     * @param senhaHash a senha criptografada do usuário
     * @return true se o login for bem-sucedido, false caso contrário
     */
    public static boolean login(String email, String senhaHash) {
        UsuarioDAO consulta = new UsuarioDAO();
        try {
            ResultSet resultadoDB = consulta.login(email, senhaHash);
            if (resultadoDB.next()) {
                user = new UsuarioModel(resultadoDB.getInt("id"),
                        resultadoDB.getString("nome"),
                        resultadoDB.getString("email"),
                        resultadoDB.getString("senha"),
                        resultadoDB.getDate("data_criacao"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Realiza o cadastro de um novo usuário.
     *
     * @param nome      o nome do usuário
     * @param email     o email do usuário
     * @param senhaHash a senha criptografada do usuário
     * @return true se o cadastro for bem-sucedido, false caso contrário
     */
    public static boolean cadastrarUsuario(String nome, String email, String senhaHash) {
        UsuarioDAO cadastro = new UsuarioDAO();
        try {
            cadastro.cadastrarUsuario(nome, email, senhaHash);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Verifica se há um usuário logado.
     *
     * @return true se houver um usuário logado, false caso contrário
     */
    public static boolean isLogued() {
        return user != null;
    }

    /**
     * Atualiza as informações do cadastro do usuário.
     *
     * @return true se a atualização for bem-sucedida, false caso contrário
     */
    public boolean atualizarCadastro() {
        UsuarioDAO dao = new UsuarioDAO();
        try {
            dao.atualizarCadastro(this);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Realiza o logout do usuário.
     */
    public static void logout() {
        user = null;
    }

    // Getters e Setters

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String hashSenha) {
        this.hashSenha = hashSenha;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * Verifica se o ID fornecido é igual ao ID do usuário.
     *
     * @param id o ID a ser comparado
     * @return true se o ID for igual, false caso contrário
     */
    public boolean isMe(int id) {
        return id_usuario == id;
    }

}
