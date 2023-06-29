package view.style;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Classe que define o estilo visual da aplicação.
 */
public class MyStyle {
    private Color TituloPrincipal;
    private Color TituloSecundario;
    private Color TextoNormal;
    private Color textoImportante;
    private Color CorFundoPrincipal;
    private Color CorFundoSecundario;
    private Image ImagemFundoPrincipal;
    private static MyStyle myStyle;

    /**
     * Construtor protegido da classe MyStyle.
     *
     * @param tituloPrincipal      A cor do título principal
     * @param tituloSecundario     A cor do título secundário
     * @param textoNormal          A cor do texto normal
     * @param textoImportante      A cor do texto importante
     * @param corFundoPrincipal    A cor do fundo principal
     * @param corFundoSecundario   A cor do fundo secundário
     * @param imagemFundoPrincipal A imagem de fundo principal
     */
    protected MyStyle(Color tituloPrincipal, Color tituloSecundario, Color textoNormal, Color textoImportante,
                      Color corFundoPrincipal, Color corFundoSecundario, Image imagemFundoPrincipal) {
        TituloPrincipal = tituloPrincipal;
        TituloSecundario = tituloSecundario;
        TextoNormal = textoNormal;
        this.textoImportante = textoImportante;
        CorFundoPrincipal = corFundoPrincipal;
        CorFundoSecundario = corFundoSecundario;
        ImagemFundoPrincipal = imagemFundoPrincipal;
    }

    /**
     * Obtém a instância atual do estilo.
     *
     * @return A instância do estilo
     */
    public static MyStyle getMyStyle(){
        if (myStyle == null) {
            MyStyleConstantsFactory.DEFAULT.createStyle();
        }
        return myStyle;
    }

    /**
     * Define um novo estilo.
     *
     * @param novo O novo estilo a ser definido
     */
    protected static void setStyle(MyStyle novo) {
        myStyle = novo;
    }

    /**
     * Obtém a cor do título principal.
     *
     * @return A cor do título principal
     */
    public Color getTituloPrincipal() {
        return TituloPrincipal;
    }

    /**
     * Obtém a cor do título secundário.
     *
     * @return A cor do título secundário
     */
    public Color getTituloSecundario() {
        return TituloSecundario;
    }

    /**
     * Obtém a cor do texto normal.
     *
     * @return A cor do texto normal
     */
    public Color getTextoNormal() {
        return TextoNormal;
    }

    /**
     * Obtém a cor do texto importante.
     *
     * @return A cor do texto importante
     */
    public Color getTextoImportante() {
        return textoImportante;
    }

    /**
     * Obtém a cor do fundo principal.
     *
     * @return A cor do fundo principal
     */
    public Color getCorFundoPrincipal() {
        return CorFundoPrincipal;
    }

    /**
     * Obtém a cor do fundo secundário.
     *
     * @return A cor do fundo secundário
     */
    public Color getCorFundoSecundario() {
        return CorFundoSecundario;
    }

    /**
     * Obtém a imagem de fundo principal.
     *
     * @return A imagem de fundo principal
     */
    public Image getImagemFundoPrincipal() {
        return new Image(getClass().getResourceAsStream("/img/bk1.png"));
    }
}
