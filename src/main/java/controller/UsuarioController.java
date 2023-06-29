package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import model.UsuarioModel;

/**
 * Classe responsável por controlar as operações relacionadas aos usuários.
 */
public class UsuarioController {

    private static UsuarioController uc;

    private UsuarioController() {
    }

    /**
     * Obtém a instância única do UsuarioController.
     *
     * @return A instância única do UsuarioController.
     */
    public static UsuarioController getInstance() {
        if (uc == null) {
            uc = new UsuarioController();
        }
        return uc;
    }

    /**
     * Realiza o login do usuário com o email e senha fornecidos.
     *
     * @param email O email do usuário.
     * @param senha A senha do usuário.
     * @return true se o login for bem-sucedido, caso contrário false.
     */
    public boolean login(String email, String senha) {
        senha = hashSenha(senha);
        return UsuarioModel.login(email, senha);
    }

    /**
     * Cadastra um novo usuário com o email, nome e senha fornecidos.
     *
     * @param email O email do usuário.
     * @param nome  O nome do usuário.
     * @param senha A senha do usuário.
     * @return true se o cadastro for bem-sucedido, caso contrário false.
     * @throws IllegalArgumentException Se o email ou nome forem vazios.
     */
    public boolean cadastrarUsuario(String email, String nome, String senha) throws IllegalArgumentException {
        if (email.equals("") || nome.equals(""))
            throw new IllegalArgumentException("Digite valores válidos");
        senha = hashSenha(senha);
        return UsuarioModel.cadastrarUsuario(nome, email, senha);
    }

    /**
     * Realiza o logout do usuário atualmente logado.
     */
    public void logout() {
        UsuarioModel.logout();
    }

    /**
     * Atualiza o nome do usuário atualmente logado.
     *
     * @param novoNome O novo nome do usuário.
     * @return true se a atualização for bem-sucedida, caso contrário false.
     */
    public boolean atualizarNome(String novoNome) {
        UsuarioModel user = UsuarioModel.getInstance();
        user.setNome(novoNome);
        return user.atualizarCadastro();
    }

    /**
     * Atualiza o email do usuário atualmente logado.
     *
     * @param novoEmail O novo email do usuário.
     * @return true se a atualização for bem-sucedida, caso contrário false.
     */
    public boolean atualizaremail(String novoEmail) {
        UsuarioModel user = UsuarioModel.getInstance();
        user.setEmail(novoEmail);
        return user.atualizarCadastro();
    }

    /**
     * Atualiza a senha do usuário atualmente logado.
     *
     * @param senha A nova senha do usuário.
     * @return true se a atualização for bem-sucedida, caso contrário false.
     */
    public boolean atualizarSenha(String senha) {
        senha = hashSenha(senha);
        UsuarioModel user = UsuarioModel.getInstance();
        user.setHashSenha(senha);
        return user.atualizarCadastro();
    }

    /**
     * Gera o hash SHA-256 para a senha fornecida.
     *
     * @param senha A senha a ser convertida em hash.
     * @return O hash SHA-256 da senha.
     */
    private String hashSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
