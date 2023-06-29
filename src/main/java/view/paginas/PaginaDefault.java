package view.paginas;

import view.telaLayout.factorys.TelaLayoutInterface;

public class PaginaDefault extends Pagina {
    
    protected TelaLayoutInterface telaLayoutInterface;
    
    /**
     * Construtor da classe PaginaDefault.
     *
     * @param telaLayoutInterface a interface de layout da tela
     */
    public PaginaDefault(TelaLayoutInterface telaLayoutInterface) {
        this.telaLayoutInterface = telaLayoutInterface;
    }

    /**
     * Cria o nó raiz da página usando o layout padrão definido pela interface de layout da tela.
     *
     * @return true sempre, pois o nó raiz é sempre criado com sucesso
     */
    @Override
    protected boolean criarRoot() {
        super.root = telaLayoutInterface.createDefaultRoot();
        return true;
    }
}
