package view.telaLayout.factorys;

import javafx.scene.Parent;

public interface TelaLayoutInterface {

    /**
     * Cria o conteúdo do cabeçalho.
     *
     * @return o nó raiz que representa o cabeçalho
     */
    public Parent createHeader();

    /**
     * Cria o conteúdo da navegação.
     *
     * @return o nó raiz que representa a navegação
     */
    public Parent createNav();

    /**
     * Cria o conteúdo principal.
     *
     * @return o nó raiz que representa o conteúdo principal
     */
    public Parent createMain();

    /**
     * Cria o conteúdo do rodapé.
     *
     * @return o nó raiz que representa o rodapé
     */
    public Parent createFooter();

    /**
     * Cria o nó raiz padrão que contém todos os elementos de layout.
     *
     * @return o nó raiz padrão
     */
    public Parent createDefaultRoot();

}
