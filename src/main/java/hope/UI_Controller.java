package hope;

import cypher.Cypher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kuro on 30.05.15.
 */
public class UI_Controller {

    @FXML
    private TabPane tabs;

    @FXML
    private VBox cyphers;

    /**/
    @FXML private Button openInputFile;
    @FXML private TextField openInputFileField;
    @FXML private Button openOutputFile;
    @FXML private TextField openOutputFileField;

    Map<Button, TextField> map = null;
    /**/

    final ToggleGroup automata = new ToggleGroup();

    Stage stage;
    FileChooser chooser = new FileChooser();


    private int tabIndex = 0;

    public void init () {
        map = new HashMap<Button, TextField>();
        map.put(openInputFile,openInputFileField);
        map.put(openOutputFile,openOutputFileField);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void handle_prev_button(ActionEvent e) {
        tabIndex = --tabIndex < 0 ? tabs.getTabs().size() : tabIndex;
        tabs.getSelectionModel().select(tabIndex);
    }

    public void handle_next_button(ActionEvent e) {
        tabIndex = ++tabIndex >  tabs.getTabs().size() ? 0 : tabIndex;
        tabs.getSelectionModel().select(tabIndex);
    }

    public void openFile(ActionEvent e) {
        String file = "";
        try {
            file = chooser.showOpenDialog(stage).getAbsolutePath();
        } catch (NullPointerException exc) {
            file = "";
        }

        //refresh textfield
        Control caller = (Control)e.getSource();

        /* first variant
        String textfield = "#" + caller.getId() + "Field";
        ((TextField) stage.getScene().lookup(textfield)).setText(file);
        */

        /*second variant */
        if (map==null) init();
        map.get(caller).setText(file);


    }

    public void addCypher(Cypher cypher) {
        RadioButton radio = new RadioButton(cypher.getName());
        radio.setUserData(cypher);
        radio.setToggleGroup(automata);
        if (cyphers.getChildren().size() == 0)
            radio.setSelected(true);

        cyphers.getChildren().add(radio);
    }

    public void collectAllData() {
        String inputFile = openInputFileField.getText();
        String outputFile = openOutputFileField.getText();
        Cypher cypher = (Cypher)automata.getSelectedToggle().getUserData();
    }
}
