package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import util.ScreanSize;
import view.changeAppearence.Interface.AppearenceHandler;

/**
 * Classe concreta que implementa o manipulador de aparência para ScrollPane do JavaFX.
 */
public class ScrollPaneAppearenceHandler extends AppearenceHandler {

    /**
     * Define o estilo para o ScrollPane do JavaFX.
     *
     * @param node o elemento do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof ScrollPane) {
            ScrollPane scroll = (ScrollPane) node;
            switch (scroll.getId()) {
                case "hidden":
                    scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                    scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
                    //scroll.autosize();
                    break;
                case "h_hiden":
                    scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
                    break;
                case "v_hiden":
                    scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
                    break;
                case "detalhes_temas_scroll":
                    scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                    scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
                    scroll.setMinHeight(ScreanSize.getInstance().getHeight() * 0.25);
                    break;
                case "detalhes_tema_arquivos_scroll":
                    scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
                    scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
                    scroll.setMinHeight(ScreanSize.getInstance().getHeight() * 0.1);
                    scroll.setPadding(new Insets(20));
                    break;
            }
            // Mudanças para todos
            scroll.setMinWidth(400);
        }
    }
}
