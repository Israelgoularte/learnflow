package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import view.changeAppearence.Interface.AppearenceHandler;

import java.awt.Desktop;
import java.net.URI;

public class HyperLinkAppearenceHandler extends AppearenceHandler {

    /**
     * Define o estilo para o elemento Hyperlink do JavaFX.
     *
     * @param node o elemento Hyperlink do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof Hyperlink) {
            Hyperlink link = (Hyperlink) node;
            switch (link.getId()) {
                case "detalhes_tema_link_arquivo":
                    link.setMinWidth(300);
                    link.setPadding(new Insets(5, 5, 5, 20));
                    link.setOnAction(event -> {
                        String url = link.getText(); // URL que deseja abrir
                        try {
                            Desktop.getDesktop().browse(new URI(url));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                // Adicione mais casos conforme necessário para IDs específicos de Hyperlink
            }
        } else if (this.nextAppearenceHandler != null) {
            this.nextAppearenceHandler.setStyle(node);
        }
    }

}
