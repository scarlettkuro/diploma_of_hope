package UI;

import application.CypherService;
import domain.cypher.Cypher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kuro on 30.05.15.
 */
public class UI_Controller {

    static private final Logger LOG=Logger.getLogger(UI_Controller.class);

    @FXML
    private TabPane tabs;

    @FXML
    private ToggleGroup mode;

    @FXML
    private VBox cyphers;

    /**/
    @FXML private Button openInputFile;
    @FXML private TextField openInputFileField;
    @FXML private Button openOutputFile;
    @FXML private TextField openOutputFileField;

    Map<Button, TextField> map = null;
    /**/

    private final ToggleGroup automata = new ToggleGroup();
    private CypherService service;
    private Stage stage;
    private  FileChooser chooser = new FileChooser();


    private int tabIndex = 0;

    public void init () {
        LOG.info("UI Controller initialize");
        map = new HashMap<Button, TextField>();
        map.put(openInputFile,openInputFileField);
        map.put(openOutputFile,openOutputFileField);

        Iterator<String> ids = service.getIdList();
        while(ids.hasNext()) {
            String id = ids.next();
            addCypher(id,service.getNameOf(id));
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setService(CypherService service) { this.service = service; }

    public void handle_prev_button(ActionEvent e) {
        //tabIndex = --tabIndex < 0 ? 0 : tabIndex;
        tabs.getSelectionModel().select(--tabIndex);
    }

    public void handle_next_button(ActionEvent e) {
        //tabIndex = ++tabIndex >=  tabs.getTabs().size() ? tabs.getTabs().size()-1 : tabIndex;
        tabs.getSelectionModel().select(++tabIndex);
    }

    public void changeTab() {
        tabIndex = tabs.getSelectionModel().getSelectedIndex();
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
        //if (map==null) init();
        map.get(caller).setText(file);


    }

    public void addCypher(String id, String name) {
        RadioButton radio = new RadioButton(name);
        radio.setUserData(id);
        radio.setToggleGroup(automata);
        if (cyphers.getChildren().size() == 0)
            radio.setSelected(true);

        cyphers.getChildren().add(radio);
    }

    public void collectAllData() {
        String inputFile = openInputFileField.getText();
        String outputFile = openOutputFileField.getText();
        String cypher = (String)automata.getSelectedToggle().getUserData();
        boolean cbmode = mode.getToggles().indexOf(mode.getSelectedToggle())==0; //true = шифрування

        try {
            service.transformFile(inputFile, outputFile, cbmode, cypher);
        } catch (FileNotFoundException e) {
            LOG.error("No such input file or path specified wrong");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText("Такого файла не існує");
            alert.setContentText("Перевірте, чи правильно ви вказали файл");

            alert.showAndWait();
        }
        /*
        System.out.println(inputFile);
        System.out.println(outputFile);
        System.out.println(cypher.getName());
        System.out.println(cbmode);*/
    }
}
