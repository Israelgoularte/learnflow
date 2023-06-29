package view.windowsLayout;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class LearnFlowWindowsLayout implements WindowsLayout {

    private final String nomeApp = "Learn Flow";
    private final Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/icon.png")));

    /**
     * Construtor padrão da classe LearnFlowWindowsLayout.
     */
    public LearnFlowWindowsLayout() {
        //System.out.println(getClass().getResourceAsStream("").toString());
    }

        /**
         * Define o título da janela como o nome do aplicativo.
         * Define o ícone da janela como a imagem especificada.
         */
    @Override
    public void customize(Stage stage) {
        stage.setTitle(nomeApp);
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.getIcons().add(icon);
    }
}
