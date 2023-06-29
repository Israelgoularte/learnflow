package view.changeAppearence.concretas;

import javafx.css.Styleable;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import view.changeAppearence.Interface.AppearenceHandler;
import view.style.MyStyle;

/**
 * Classe concreta para manipulação da aparência de botões (ButtonAppearenceHandler).
 * Estende a classe abstrata AppearenceHandler e implementa o método setStyle para personalizar a aparência dos botões.
 */
public class ButtonAppearenceHandler extends AppearenceHandler {

    @Override
    public void setStyle(Styleable node) {
        if (node instanceof Button) {
            Button button = (Button) node;
            switch (button.getId()) {
                case "primary":
                    button.setMinWidth(100);
                    button.setMaxWidth(300);
                    button.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoPrincipal(), new CornerRadii(10), null)));
                    button.setTextFill(MyStyle.getMyStyle().getTituloPrincipal());
                    button.setOnMouseEntered(e -> {
                        button.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getTituloPrincipal(), new CornerRadii(10), null)));
                        button.setTextFill(MyStyle.getMyStyle().getCorFundoPrincipal());
                    });
                    button.setOnMouseExited(e -> {
                        button.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoPrincipal(), new CornerRadii(10), null)));
                        button.setTextFill(MyStyle.getMyStyle().getTituloPrincipal());
                    });
                    break;
                case "secondary":
                    button.setMinWidth(100);
                    button.setMaxWidth(300);
                    button.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(), new CornerRadii(10), null)));
                    button.setTextFill(MyStyle.getMyStyle().getTituloSecundario());
                    button.setOnMouseEntered(e -> {
                        button.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getTituloSecundario(), new CornerRadii(10), null)));
                        button.setTextFill(MyStyle.getMyStyle().getCorFundoSecundario());
                    });
                    button.setOnMouseExited(e -> {
                        button.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(), new CornerRadii(10), null)));
                        button.setTextFill(MyStyle.getMyStyle().getTituloSecundario());
                    });
                    break;

                    case "detalhes_tema_btn_primary":
                        button.setMinWidth(300);
                        button.setMaxWidth(300);
                        button.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoPrincipal(), new CornerRadii(10), null)));
                        button.setTextFill(MyStyle.getMyStyle().getTituloPrincipal());
                        button.setOnMouseEntered(e -> {
                            button.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getTituloPrincipal(), new CornerRadii(10), null)));
                            button.setTextFill(MyStyle.getMyStyle().getCorFundoPrincipal());
                        });
                        button.setOnMouseExited(e -> {
                            button.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoPrincipal(), new CornerRadii(10), null)));
                            button.setTextFill(MyStyle.getMyStyle().getTituloPrincipal());
                        });
                        break;
                case "detalhes_tema_btn_secondary":
                    button.setMinWidth(300);
                    button.setMaxWidth(300);
                    button.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(), new CornerRadii(10), null)));
                    button.setTextFill(MyStyle.getMyStyle().getTituloSecundario());
                    button.setOnMouseEntered(e -> {
                        button.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getTituloSecundario(), new CornerRadii(10), null)));
                        button.setTextFill(MyStyle.getMyStyle().getCorFundoSecundario());
                    });
                    button.setOnMouseExited(e -> {
                        button.setBackground(new Background(new BackgroundFill(MyStyle.getMyStyle().getCorFundoSecundario(), new CornerRadii(10), null)));
                        button.setTextFill(MyStyle.getMyStyle().getTituloSecundario());
                    });
                    break;

                default:
                    break;
                // Adicione mais casos conforme necessário para IDs específicos de Button
            }

        } else if (super.nextAppearenceHandler != null) {
            nextAppearenceHandler.setStyle(node);
        }
    }
}
