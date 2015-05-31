package UI;

import application.CypherServiceImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class _Main  extends Application {

	static private final Logger LOG=Logger.getLogger(_Main.class);
	@Override
	public void start(Stage stage) throws Exception {
		LOG.info("Loading .fxml markup");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fine.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root, 500, 350);
		stage.setTitle("CAme");
		stage.setScene(scene);

		LOG.info("Connect controller");

		UI_Controller controller = loader.getController();
		controller.setStage(stage);
		controller.setService(new CypherServiceImpl());
		controller.init();

		LOG.info("Show UI");
		stage.show();

	}

	public static void main(String[] args) {
		LOG.info("ACme started\n");

		launch(args);


		LOG.info("ACme closed");
	}


}