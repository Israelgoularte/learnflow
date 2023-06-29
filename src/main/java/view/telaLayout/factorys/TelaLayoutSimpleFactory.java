package view.telaLayout.factorys;

import view.telaLayout.CadastroLayout;
import view.telaLayout.DetalhesTemaLayout;
import view.telaLayout.HomeLayout;
import view.telaLayout.LoginLayout;
import view.telaLayout.TemaLayout;

public class TelaLayoutSimpleFactory {

    /**
     * Cria uma instância de TelaLayoutInterface com base no nome da tela fornecido.
     *
     * @param tela o nome da tela
     * @return uma instância de TelaLayoutInterface correspondente à tela especificada
     */
    public static TelaLayoutInterface create(String tela) {
        switch (tela) {
            case "login":
                return new LoginLayout();
            case "cadastro":
                return new CadastroLayout();
            case "home":
                return new HomeLayout();
            case "temas":
                return new TemaLayout();
            case "detalhes tema":
                return new DetalhesTemaLayout();
            default:
                return null;
        }
    }
}
