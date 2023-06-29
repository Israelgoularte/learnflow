package model;

import java.sql.Date;
import java.sql.SQLException;

import model.dao.DAOInserir;
import model.dao.DAOUpdate;

/**
 * Classe que representa o modelo ArquivosModel.
 */
public class ArquivosModel implements ModelInterface {
    
    private int id;
    private int temaId;
    private Date dataCriacao;
    private String nome;
    private String link;

    /**
     * Construtor da classe ArquivosModel.
     * 
     * @param id           O ID do arquivo.
     * @param temaId       O ID do tema associado ao arquivo.
     * @param dataCriacao  A data de criação do arquivo.
     * @param nome         O nome do arquivo.
     * @param link         O link do arquivo.
     */
    public ArquivosModel(int id, int temaId, Date dataCriacao, String nome, String link) {
        this.id = id;
        this.temaId = temaId;
        this.dataCriacao = dataCriacao;
        this.nome = nome;
        this.link = link;
    }

    /**
     * Construtor da classe ArquivosModel.
     * 
     * @param temaId       O ID do tema associado ao arquivo.
     * @param dataCriacao  A data de criação do arquivo.
     * @param nome         O nome do arquivo.
     * @param link         O link do arquivo.
     */
    public ArquivosModel(int temaId, Date dataCriacao, String nome, String link) {
        this.temaId = temaId;
        this.dataCriacao = dataCriacao;
        this.nome = nome;
        this.link = link;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemaId() {
        return temaId;
    }

    public void setTemaId(int temaId) {
        this.temaId = temaId;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Verifica se o ID do arquivo é igual ao ID fornecido.
     *
     * @param id O ID a ser comparado.
     * @return true se o ID for igual, false caso contrário.
     */
    public boolean isMe(int id){
        return this.id == id;
    }

    @Override
    public boolean atualizar() {
        String SQL = "UPDATE arquivos SET nome = ?, link = ? WHERE id = ?;";
        try {
            return new DAOUpdate().setSQL(SQL)
                    .setValue(nome)
                    .setValue(link)
                    .setValue(this.id)
                    .build();
        } catch (SQLException error) {
            error.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean excluir() {
        String SQL = "DELETE FROM arquivos WHERE id = ?;";
        try {
            return new DAOUpdate().setSQL(SQL)
                    .setValue(id)
                    .build();
        } catch (SQLException error) {
            error.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insert() {
        String SQL = "INSERT INTO arquivos (tema_id, nome, link, usuario_id) VALUES (?, ?, ?, ?);";
        try {
            this.id = new DAOInserir().setSQL(SQL)
                    .setValue(temaId)
                    .setValue(nome)
                    .setValue(link)
                    .setValue(UsuarioModel.getInstance().getId_usuario())
                    .build();
            if (this.id > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException error) {
            error.printStackTrace();
            return false;
        }
    }
}
