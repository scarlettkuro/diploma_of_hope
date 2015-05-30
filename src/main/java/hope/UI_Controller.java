package hope;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

/**
 * Created by kuro on 30.05.15.
 */
public class UI_Controller {
    @FXML
    private TabPane tabs;

    private int tabIndex = 0;

    public void handle_prev_button(ActionEvent e) {
        tabIndex = --tabIndex < 0 ? tabs.getTabs().size() : tabIndex;
        tabs.getSelectionModel().select(tabIndex);
    }

    public void handle_next_button(ActionEvent e) {
        tabIndex = ++tabIndex >  tabs.getTabs().size() ? 0 : tabIndex;
        tabs.getSelectionModel().select(tabIndex);
    }
}
