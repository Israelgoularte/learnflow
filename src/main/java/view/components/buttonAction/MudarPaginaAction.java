package view.components.buttonAction;

import view.paginas.factory.PaginaSimpleFactory;
import controller.FacadeController;

/**
 * Implementação da interface MyVoidAction que altera a página atual.
 */
public class MudarPaginaAction implements MyVoidAction {
    private String pagina;

    /**
     * Constrói um MudarPaginaAction com o nome da página especificada.
     * 
     * @param pagina o nome da página para a qual se deseja mudar
     */
    public MudarPaginaAction(String pagina) {
        this.pagina = pagina;
    }

    /**
     * Altera a página atual usando a PaginaSimpleFactory.
     */
    @Override
    public void active() {
        PaginaSimpleFactory.create(pagina).inicialiarPagina(FacadeController.getInstance().getStage());
    }
}
