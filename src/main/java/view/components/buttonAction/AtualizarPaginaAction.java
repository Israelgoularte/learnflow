package view.components.buttonAction;

import controller.FacadeController;

/**
 * Implementação da interface MyVoidAction que executa a ação de atualização de página.
 */
public class AtualizarPaginaAction implements MyVoidAction {

    /**
     * Executa a ação de atualização de página. Se um tema selecionado estiver disponível,
     * chama o MudarPaginaAction para navegar até a página "detalhes tema".
     * Caso contrário, navega até a página "home".
     */
    @Override
    public void active() {
        if (FacadeController.getInstance().getTemaSelecionado() != null) {
            new MudarPaginaAction("detalhes tema").active();
        } else {
            new MudarPaginaAction("home").active();
        }
    }
}
