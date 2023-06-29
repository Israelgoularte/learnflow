package model;

/**
 * A classe ModelInterface é uma classe abstrata que define a interface para modelos.
 */
public interface ModelInterface {

    /**
     * Atualiza o modelo.
     *
     * @return true se a atualização for bem-sucedida, false caso contrário
     */
    public boolean atualizar();

    /**
     * Exclui o modelo.
     *
     * @return true se a exclusão for bem-sucedida, false caso contrário
     */
    public abstract boolean excluir();

    /**
     * Insere o modelo.
     *
     * @return true se a inserção for bem-sucedida, false caso contrário
     */
    public boolean insert();

    /**
     * Verifica se o modelo possui o ID fornecido.
     *
     * @param id o ID a ser verificado
     * @return true se o modelo tiver o ID fornecido, false caso contrário
     */
    public boolean isMe(int id);
}
