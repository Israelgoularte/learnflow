package model.modalList;

import java.util.LinkedList;

import model.ModelInterface;

/**
 * Classe abstrata que representa uma lista de modelos.
 *
 * @param <T> Tipo de modelo que a lista contém.
 */
public abstract class ModelListInterface<T extends ModelInterface> implements Runnable {
    protected LinkedList<T> list = new LinkedList<>();

    /**
     * Obtém a lista de modelos.
     *
     * @return A lista de modelos.
     */
    public LinkedList<T> getList() {
        return list;
    }

    /**
     * Adiciona um elemento à lista.
     *
     * @param elemento O elemento a ser adicionado.
     * @return true se o elemento foi adicionado com sucesso, false caso contrário.
     */
    public boolean add(T elemento) {
        return this.list.add(elemento);
    }

    /**
     * Remove um elemento da lista.
     *
     * @param elemento O elemento a ser removido.
     * @return true se o elemento foi removido com sucesso, false caso contrário.
     */
    public boolean remover(T elemento) {
            return list.remove(elemento);
    }

    /**
     * Reinicializa a lista, removendo todos os elementos.
     */
    public void reinicializar() {
        list.clear();
    }

    /**
     * Carrega os dados da lista a partir de alguma fonte de dados, como um banco de dados.
     */
    public abstract void carregarDados();

    @Override
    public void run() {
        carregarDados();
    }
}
