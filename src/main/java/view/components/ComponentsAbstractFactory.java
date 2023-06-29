package view.components;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ComponentsAbstractFactory extends ComponentsAbstractFactoryInterface {
    public static final ComponentsAbstractFactory factory = new ComponentsAbstractFactory();

    private ComponentsAbstractFactory() {}
    
    /**
     * Cria um HBox com o ID especificado.
     *
     * @param id o ID do HBox
     * @return o HBox criado
     */
    @Override
    public HBox createHBox(String id) {
        HBox hbox = new HBox();
        hbox.setId(id);
        super.components.add(hbox);
        return hbox;
    }

    /**
     * Cria um VBox com o ID especificado.
     *
     * @param id o ID do VBox
     * @return o VBox criado
     */
    @Override
    public VBox createVBox(String id) {
        VBox vbox = new VBox();
        vbox.setId(id);
        super.components.add(vbox);
        return vbox;
    }

    /**
     * Cria um BorderPane com o ID especificado.
     *
     * @param id o ID do BorderPane
     * @return o BorderPane criado
     */
    @Override
    public BorderPane createBorderPane(String id) {
        BorderPane borderPane = new BorderPane();
        borderPane.setId(id);
        super.components.add(borderPane);
        return borderPane;
    }

    /**
     * Cria um GridPane com o ID especificado.
     *
     * @param id o ID do GridPane
     * @return o GridPane criado
     */
    @Override
    public GridPane createGridPane(String id) {
        GridPane gridPane = new GridPane();
        gridPane.setId(id);
        super.components.add(gridPane);
        return gridPane;
    }

    /**
     * Cria um Label com o ID e o texto especificados.
     *
     * @param id   o ID do Label
     * @param text o texto do Label
     * @return o Label criado
     */
    @Override
    public Label createLabel(String id, String text) {
        Label label = new Label(text);
        label.setId(id);
        super.components.add(label);
        return label;
    }

    /**
     * Cria um Button com o ID e o texto especificados.
     *
     * @param id   o ID do Button
     * @param text o texto do Button
     * @return o Button criado
     */
    @Override
    public Button createButton(String id, String text) {
        Button button = new Button(text);
        button.setId(id);
        super.components.add(button);
        return button;
    }

    /**
     * Cria um TextField com o ID especificado.
     *
     * @param id o ID do TextField
     * @return o TextField criado
     */
    @Override
    public TextField createTextField(String id) {
        TextField textField = new TextField();
        textField.setId(id);
        super.components.add(textField);
        return textField;
    }

    /**
     * Cria um TextArea com o ID especificado.
     *
     * @param id o ID do TextArea
     * @return o TextArea criado
     */
    @Override
    public TextArea createTextArea(String id) {
        TextArea textArea = new TextArea();
        textArea.setId(id);
        super.components.add(textArea);
        return textArea;
    }

    /**
     * Cria um CheckBox com o ID especificado.
     *
     * @param id o ID do CheckBox
     * @return o CheckBox criado
     */
    @Override
    public CheckBox createCheckBox(String id) {
        CheckBox checkBox = new CheckBox();
        checkBox.setId(id);
        super.components.add(checkBox);
        return checkBox;
    }

    /**
     * Cria um RadioButton com o ID especificado.
     *
     * @param id o ID do RadioButton
     * @return o RadioButton criado
     */
    @Override
    public RadioButton createRadioButton(String id) {
        RadioButton radioButton = new RadioButton();
        radioButton.setId(id);
        super.components.add(radioButton);
        return radioButton;
    }

    /**
     * Cria um ComboBox com o ID especificado.
     *
     * @param id o ID do ComboBox
     * @return o ComboBox criado
     */
    @Override
    public ComboBox<String> createComboBox(String id) {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setId(id);
        super.components.add(comboBox);
        return comboBox;
    }

    /**
     * Cria um ListView com o ID especificado.
     *
     * @param id o ID do ListView
     * @return o ListView criado
     */
    @Override
    public ListView<String> createListView(String id) {
        ListView<String> listView = new ListView<>();
        listView.setId(id);
        super.components.add(listView);
        return listView;
    }

    /**
     * Cria um ImageView com o ID especificado.
     *
     * @param id o ID do ImageView
     * @return o ImageView criado
     */
    @Override
    public ImageView createImageView(String id) {
        ImageView imageView = new ImageView();
        imageView.setId(id);
        super.components.add(imageView);
        return imageView;
    }

    /**
     * Cria um Slider com o ID especificado.
     *
     * @param id o ID do Slider
     * @return o Slider criado
     */
    @Override
    public Slider createSlider(String id) {
        Slider slider = new Slider();
        slider.setId(id);
        super.components.add(slider);
        return slider;
    }

    /**
     * Cria um MenuBar com o ID especificado.
     *
     * @param id o ID do MenuBar
     * @return o MenuBar criado
     */
    @Override
    public MenuBar createMenuBar(String id) {
        MenuBar menuBar = new MenuBar();
        menuBar.setId(id);
        super.components.add(menuBar);
        return menuBar;
    }

    /**
     * Cria um Menu com o ID e o texto especificados.
     *
     * @param id   o ID do Menu
     * @param text o texto do Menu
     * @return o Menu criado
     */
    @Override
    public Menu createMenu(String id, String text) {
        Menu menu = new Menu(text);
        menu.setId(id);
        super.components.add(menu);
        return menu;
    }

    /**
     * Cria um MenuItem com o ID e o texto especificados.
     *
     * @param id   o ID do MenuItem
     * @param text o texto do MenuItem
     * @return o MenuItem criado
     */
    @Override
    public MenuItem createMenuItem(String id, String text) {
        MenuItem menuItem = new MenuItem(text);
        menuItem.setId(id);
        super.components.add(menuItem);
        return menuItem;
    }

    /**
     * Cria um Text com o ID e o texto especificados.
     *
     * @param id   o ID do Text
     * @param text o texto do Text
     * @return o Text criado
     */
    @Override
    public Text createText(String id, String text) {
        Text t = new Text(text);
        t.setId(id);
        super.components.add(t);
        return t;
    }

    /**
     * Cria um PasswordField com o ID especificado.
     *
     * @param id o ID do PasswordField
     * @return o PasswordField criado
     */
    @Override
    public PasswordField createPasswordField(String id) {
        PasswordField passwordField = new PasswordField();
        super.components.add(passwordField);
        passwordField.setId(id);
        return passwordField;
    }

    /**
     * Cria um ScrollPane com o ID e o conteúdo especificados.
     *
     * @param id      o ID do ScrollPane
     * @param element o conteúdo do ScrollPane
     * @return o ScrollPane criado
     */
    @Override
    public ScrollPane createScrollPane(String id, Node element) {
        ScrollPane scroll = new ScrollPane(element);
        scroll.setId(id);
        super.components.add(scroll);
        return scroll;
    }

    /**
     * Cria um Hyperlink com o ID e o nome especificados.
     *
     * @param id   o ID do Hyperlink
     * @param nome o nome do Hyperlink
     * @return o Hyperlink criado
     */
    @Override
    public Hyperlink createHyperlink(String id, String nome) {
        Hyperlink link = new Hyperlink(nome);
        link.setId(id);
        super.components.add(link);
        return link;
    }
}
