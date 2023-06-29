package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import util.ScreanSize;
import view.changeAppearence.Interface.AppearenceHandler;

public class GridPaneAppearenceHandler extends AppearenceHandler {

    /**
     * Define o estilo para o elemento GridPane do JavaFX.
     *
     * @param node o elemento GridPane do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof GridPane) {
            GridPane gridPane = (GridPane) node;
            switch (gridPane.getId()) {
                case "primary":
                    // Definir estilo para GridPane sem ID específico
                    break;
                case "secondary":
                    // Definir estilo para GridPane com ID "gridPane1"
                    break;
                case "detalhes_tema_arquivos":
                    gridPane.setHgap(0);
                    gridPane.setVgap(0);
                    gridPane.setAlignment(Pos.CENTER);
                    gridPane.setPadding(new Insets(5));
                    gridPane.setGridLinesVisible(true);
                    gridPane.setMinWidth(ScreanSize.getInstance().getWidth() * 0.5);
                    break;
                default:
                    gridPane.setAlignment(Pos.CENTER);
                    gridPane.setVgap(10);
                    gridPane.setHgap(10);
                    break;
                // Adicione mais casos conforme necessário para IDs específicos de GridPane
            }
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
