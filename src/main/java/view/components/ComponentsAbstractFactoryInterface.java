package view.components;

import java.util.LinkedList;
import javafx.css.Styleable;
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

/**
 * Interface que define a fábrica abstrata para a criação de componentes visuais.
 */
public abstract class ComponentsAbstractFactoryInterface {
    
    protected LinkedList<Styleable> components = new LinkedList<>();
    
    protected ComponentsAbstractFactoryInterface() {
    }
    
    /**
     * Retorna a lista de componentes criados pela fábrica.
     *
     * @return a lista de componentes
     */
    public LinkedList<Styleable> getComponents(){
        return components;
    }
    
    /**
     * Reinicializa a lista de componentes.
     */
    public void reinicializarComponentsList(){
        components = new LinkedList<>();
    }
    
    /**
     * Cria um HBox com o ID especificado.
     *
     * @param id o ID do HBox
     * @return o HBox criado
     */
    public abstract HBox createHBox(String id);
    
    /**
     * Cria um VBox com o ID especificado.
     *
     * @param id o ID do VBox
     * @return o VBox criado
     */
    public abstract VBox createVBox(String id);
    
    /**
     * Cria um BorderPane com o ID especificado.
     *
     * @param id o ID do BorderPane
     * @return o BorderPane criado
     */
    public abstract BorderPane createBorderPane(String id);
    
    /**
     * Cria um GridPane com o ID especificado.
     *
     * @param id o ID do GridPane
     * @return o GridPane criado
     */
    public abstract GridPane createGridPane(String id);
    
    /**
     * Cria um Label com o ID e texto especificados.
     *
     * @param id o ID do Label
     * @param text o texto do Label
     * @return o Label criado
     */
    public abstract Label createLabel(String id, String text);
    
    /**
     * Cria um Button com o ID e texto especificados.
     *
     * @param id o ID do Button
     * @param text o texto do Button
     * @return o Button criado
     */
    public abstract Button createButton(String id, String text);
    
    /**
     * Cria um TextField com o ID especificado.
     *
     * @param id o ID do TextField
     * @return o TextField criado
     */
    public abstract TextField createTextField(String id);
    
    /**
     * Cria um TextArea com o ID especificado.
     *
     * @param id o ID do TextArea
     * @return o TextArea criado
     */
    public abstract TextArea createTextArea(String id);
    
    /**
     * Cria um CheckBox com o ID especificado.
     *
     * @param id o ID do CheckBox
     * @return o CheckBox criado
     */
    public abstract CheckBox createCheckBox(String id);
    
    /**
     * Cria um RadioButton com o ID especificado.
     *
     * @param id o ID do RadioButton
     * @return o RadioButton criado
     */
    public abstract RadioButton createRadioButton(String id);
    
    /**
     * Cria um ComboBox com o ID especificado.
     *
     * @param id o ID do ComboBox
     * @return o ComboBox criado
     */
    public abstract ComboBox<String> createComboBox(String id);
    
    /**
     * Cria um ListView com o ID especificado.
     *
     * @param id o ID do ListView
     * @return o ListView criado
     */
    public abstract ListView<String> createListView(String id);
    
    /**
     * Cria um ImageView com o ID especificado.
     *
     * @param id o ID do ImageView
     * @return o ImageView criado
     */
    public abstract ImageView createImageView(String id);
    
    /**
     * Cria um Slider com o ID especificado.
     *
     * @param id o ID do Slider
     * @return o Slider criado
     */
    public abstract Slider createSlider(String id);
    
    /**
     * Cria um MenuBar com o ID especificado.
     *
     * @param id o ID do MenuBar
     * @return o MenuBar criado
     */
    public abstract MenuBar createMenuBar(String id);
    
    /**
     * Cria um Menu com o ID e texto especificados.
     *
     * @param id o ID do Menu
     * @param text o texto do Menu
     * @return o Menu criado
     */
    public abstract Menu createMenu(String id, String text);
    
    /**
     * Cria um MenuItem com o ID e texto especificados.
     *
     * @param id o ID do MenuItem
     * @param text o texto do MenuItem
     * @return o MenuItem criado
     */
    public abstract MenuItem createMenuItem(String id, String text);
    
    /**
     * Cria um Text com o ID e texto especificados.
     *
     * @param id o ID do Text
     * @param text o texto do Text
     * @return o Text criado
     */
    public abstract Text createText(String id, String text);
    
    /**
     * Cria um PasswordField com o ID especificado.
     *
     * @param id o ID do PasswordField
     * @return o PasswordField criado
     */
    public abstract PasswordField createPasswordField(String id);
    
    /**
     * Cria um ScrollPane com o ID e conteúdo especificados.
     *
     * @param id o ID do ScrollPane
     * @param element o conteúdo do ScrollPane
     * @return o ScrollPane criado
     */
    public abstract ScrollPane createScrollPane(String id, Node element);
    
    /**
     * Cria um Hyperlink com o ID e nome especificados.
     *
     * @param id o ID do Hyperlink
     * @param nome o nome do Hyperlink
     * @return o Hyperlink criado
     */
    public abstract Hyperlink createHyperlink(String id, String nome);
}
