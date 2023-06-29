package view.style;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Classe responsável por criar instâncias de estilos MyStyle.
 */
public class MyStyleFactory {

    /**
     * Cria um novo estilo MyStyle com base nos parâmetros fornecidos.
     *
     * @param TituloPrincipal       A cor do título principal
     * @param TituloSecundario      A cor do título secundário
     * @param TituloTerciario       A cor do título terciário
     * @param TextoNormal           A cor do texto normal
     * @param textoImportante       A cor do texto importante
     * @param CorFundoPrincipal     A cor do fundo principal
     * @param CorFundoSecundario    A cor do fundo secundário
     * @param corFundoTerciario     A cor do fundo terciário
     * @param ImagemFundoPrincipal  A imagem de fundo principal
     * @param ImagemFundoSecundario A imagem de fundo secundário
     * @return A instância do estilo MyStyle criada
     */
    public static MyStyle criar(Color TituloPrincipal, Color TituloSecundario, Color TituloTerciario,
                                Color TextoNormal, Color textoImportante, Color CorFundoPrincipal,
                                Color CorFundoSecundario, Color corFundoTerciario, Image ImagemFundoPrincipal,
                                Image ImagemFundoSecundario) {

        MyStyle.setStyle(new MyStyle(TituloPrincipal, TituloSecundario, TextoNormal, textoImportante, CorFundoPrincipal, CorFundoSecundario, ImagemFundoPrincipal));


        return MyStyle.getMyStyle();

    }

}
