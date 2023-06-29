package view.paginas.factory;

import view.paginas.Pagina;
import view.paginas.PaginaDefault;
import view.telaLayout.factorys.TelaLayoutSimpleFactory;

public class PaginaSimpleFactory {

    /**
     * Cria uma instância de página com base no nome da tela especificado.
     *
     * @param tela o nome da tela para a página
     * @return a instância de página criada
     */
    public static Pagina create(String tela){
        return new PaginaDefault(TelaLayoutSimpleFactory.create(tela));
    }
}
