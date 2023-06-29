package view.paginas.factory;

import view.paginas.Pagina;
import view.telaLayout.factorys.TelaLayoutInterface;

public interface PaginaFactoryInterface {
    
    /**
     * Obtém uma instância de página com base no layout da tela especificado.
     *
     * @param telaLayout o layout da tela para a página
     * @return a instância de página correspondente ao layout da tela
     */
    public Pagina getPagina(TelaLayoutInterface telaLayout);
}
