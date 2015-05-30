package hope;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by kuro on 30.05.15.
 */
public class UI_Controller {
    @FXML
    private TabPane tabs;

    Stage stage;
    FileChooser chooser = new FileChooser();

    private int tabIndex = 0;

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
        String textfield = "#" + caller.getId() + "Field";
        ((TextField) stage.getScene().lookup(textfield)).setText(file);
    }
}
