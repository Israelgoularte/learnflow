package view.style;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public enum MyStyleConstantsFactory {
    TEMA_1(Color.RED, Color.FLORALWHITE, Color.RED, Color.WHITE, Color.rgb(16, 16, 16),
            Color.rgb(0, 0, 0, 0.8)),
    TEMA_2(Color.LIME, Color.WHITESMOKE, Color.LIME, Color.WHITESMOKE, Color.BLACK,
            Color.rgb(0, 0, 0, 0.8)),
    TEMA_3(Color.AQUA, Color.WHITESMOKE, Color.AQUA, Color.WHITESMOKE, Color.BLACK,
            Color.rgb(0, 0, 0, 0.8)),
    TEMA_4(Color.BLACK, Color.BLUE, Color.BLACK, Color.BLACK, Color.AQUA,
            Color.rgb(255, 255, 255, 0.8)),
    TEMA_5(Color.BLACK, Color.GREEN, Color.BLACK, Color.BLACK, Color.LIME,
            Color.rgb(255, 255, 255, 0.8)),
    TEMA_6(Color.BLACK, Color.VIOLET, Color.BLACK, Color.BLACK, Color.FIREBRICK,
            Color.rgb(255, 255, 255, 0.8)),
    DEFAULT(Color.BLACK, Color.GRAY, Color.BLACK, Color.BLACK, Color.GRAY,
            Color.rgb(255, 255, 255, 0.8));

    private MyStyle style;

    /**
     * Construtor da enumeração MyStyleConstanteFactory.
     *
     * @param tituloPrincipal      a cor do título principal
     * @param tituloSecundario     a cor do título secundário
     * @param textoNormal          a cor do texto normal
     * @param textoImportante      a cor do texto importante
     * @param corFundoPrincipal    a cor de fundo principal
     * @param corFundoSecundario   a cor de fundo secundário
     * @param imagemFundoPrincipal a imagem de fundo principal
     */
    private MyStyleConstantsFactory(Color tituloPrincipal, Color tituloSecundario, Color textoNormal,
                                    Color textoImportante, Color corFundoPrincipal, Color corFundoSecundario
                                    ) {

        style = new MyStyle(tituloPrincipal, tituloSecundario, textoNormal, textoImportante, corFundoPrincipal,
                corFundoSecundario, null);
    }

    /**
     * Cria o estilo correspondente à constante da enumeração.
     */
    public void createStyle() {
        MyStyle.setStyle(style);
    }
}
