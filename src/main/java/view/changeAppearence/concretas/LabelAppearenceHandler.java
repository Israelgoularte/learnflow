package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.changeAppearence.Interface.AppearenceHandler;
import view.style.MyStyle;

/**
 * Classe concreta que implementa o manipulador de aparência para Label do JavaFX.
 */
public class LabelAppearenceHandler extends AppearenceHandler {

    /**
     * Define o estilo para o Label do JavaFX.
     *
     * @param node o elemento do JavaFX a ser estilizado
     */
    @Override
    public void setStyle(Styleable node) {
        if (node instanceof Label) {
            Label label = (Label) node;
            switch (label.getId()) {
                case "primary":
                    label.setTextFill(MyStyle.getMyStyle().getTituloPrincipal());
                    label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                    break;
                case "secondary":
                    label.setTextFill(MyStyle.getMyStyle().getTituloSecundario());
                    label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                    break;
                case "menu_usaurio":
                    label.setTextFill(MyStyle.getMyStyle().getTituloSecundario());
                    label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                    label.setAlignment(Pos.CENTER);
                    break;
                case "tema_titulo":
                    label.setPadding(new Insets(30));
                    label.setTextFill(MyStyle.getMyStyle().getTituloPrincipal());
                    label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                    break;
                case "detalhes_tema_label_gridpane_arquivo":
                    label.setTextFill(MyStyle.getMyStyle().getTituloSecundario());
                    label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                    label.setText(String.format("%-40.40s", label.getText()));
                    break;
                case "detalhes_tema_label_gridpane_link":
                    label.setTextFill(MyStyle.getMyStyle().getTituloSecundario());
                    label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                    label.setText(String.format("%-80.80s", label.getText()));
                    break;
                case "detalhes_tema_label_gridpane_editar":
                    label.setTextFill(MyStyle.getMyStyle().getTituloSecundario());
                    label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                    label.setText(String.format("%-20.20s", label.getText()));
                    break;
                case "header_label_app_name":
                    label.setTextFill(MyStyle.getMyStyle().getTituloSecundario());
                    label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                    label.setOnMouseEntered(e ->{
                        label.setTextFill(MyStyle.getMyStyle().getTituloPrincipal());
                        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                    });
                    label.setOnMouseExited(e ->{
                        label.setTextFill(MyStyle.getMyStyle().getTituloSecundario());
                        label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                    });
                    break;
                    
                // Adicione mais casos conforme necessário para IDs específicos de Label
            }
        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
