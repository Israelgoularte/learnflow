package model;


import java.sql.SQLException;

import model.dao.DAOInserir;
import model.dao.DAOUpdate;

/**
 * A classe TemaModel representa um modelo de tema.
 */
public class TemaModel implements ModelInterface {
    private Integer temaId;
    private String nome;
    private String descricao;
    private Integer TemaDependenteID;

    /**
     * Obtém o ID do tema dependente.
     *
     * @return o ID do tema dependente
     */
    public Integer getTemaDependenteID() {
        return this.TemaDependenteID;
    }

    /**
     * Define o ID do tema dependente.
     *
     * @param TemaDependenteID o ID do tema dependente a ser definido
     */
    public void setTemaDependenteID(Integer TemaDependenteID) {
        this.TemaDependenteID = TemaDependenteID;
    }

    /**
     * Cria uma nova instância de TemaModel.
     */
    public TemaModel() {
    }

    /**
     * Cria uma nova instância de TemaModel com os parâmetros fornecidos.
     *
     * @param temaId    o ID do tema
     * @param nome      o nome do tema
     * @param descricao a descrição do tema
     */
    public TemaModel(Integer temaId, String nome, String descricao) {
        this.temaId = temaId;
        this.nome = nome;
        this.descricao = descricao;
    }

    /**
     * Cria uma nova instância de TemaModel com os parâmetros fornecidos.
     *
     * @param temaId             o ID do tema
     * @param nome               o nome do tema
     * @param descricao          a descrição do tema
     * @param tema_dependente_id o ID do tema dependente
     */
    public TemaModel(Integer temaId, String nome, String descricao, Integer tema_dependente_id) {
        this.temaId = temaId;
        this.nome = nome;
        this.descricao = descricao;
        this.TemaDependenteID = tema_dependente_id;
    }

    /**
     * Obtém o ID do tema.
     *
     * @return o ID do tema
     */
    public Integer getTemaId() {
        return temaId;
    }

    /**
     * Obtém o nome do tema.
     *
     * @return o nome do tema
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do tema.
     *
     * @param nome o nome do tema a ser definido
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define o ID do tema.
     *
     * @param temaId o ID do tema a ser definido
     */
    public void setTemaId(Integer temaId) {
        this.temaId = temaId;
    }

    /**
     * Obtém a descrição do tema.
     *
     * @return a descrição do tema
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Define a descrição do tema.
     *
     * @param descricao a descrição do tema a ser definida
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Verifica se o tema possui um ID de tema dependente.
     *
     * @return true se o tema possui um ID de tema dependente, false caso contrário
     */
    public boolean isTemaDependenteID() {
        return TemaDependenteID != 0;
    }

    /**
     * Verifica se o ID do tema é igual ao ID fornecido.
     *
     * @param temaId o ID a ser verificado
     * @return true se o ID do tema for igual ao ID fornecido, false caso contrário
     */
    public boolean isMe(int temaId) {
        return temaId == this.temaId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean atualizar() {
        try {
            String sql = "update learnflow.tema set nome = ?, descricao = ? where id = ?;";
            return new DAOUpdate().setSQL(sql).setValue(nome).setValue(descricao).setValue(this.temaId).build();
        } catch (SQLException error) {
            error.printStackTrace();
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean excluir() {
        String SQL = "delete from learnflow.tema where id = ? and usuario_id = ?;";
        try {
            return new DAOUpdate()
                    .setSQL(SQL)
                    .setValue(this.temaId)
                    .setValue(UsuarioModel.getInstance().getId_usuario())
                    .build();
        } catch (SQLException error) {
            error.printStackTrace();
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean insert() {
        String sql;
        try {
            if (this.TemaDependenteID == null) {
                sql = "insert Into learnflow.tema (nome, descricao,usuario_id) VALUES (?,?,?);";
                this.temaId = new DAOInserir()
                        .setSQL(sql)
                        .setValue(this.nome)
                        .setValue(this.descricao)
                        .setValue(UsuarioModel.getInstance().getId_usuario())
                        .build();
                return this.temaId > 0;
            } else {
                sql = "insert Into learnflow.tema (nome, descricao, tema_dependente_id,usuario_id) VALUES (?,?,?,?);";
                this.temaId = new DAOInserir()
                        .setSQL(sql)
                        .setValue(this.nome)
                        .setValue(this.descricao)
                        .setValue(this.TemaDependenteID)
                        .setValue(UsuarioModel.getInstance().getId_usuario())
                        .build();
                return this.temaId > 0;
            }
        } catch (SQLException error) {
            error.printStackTrace();
            return false;
        }
    }
}
