package UI;

import domain.cypher.StraightCypher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class _Main  extends Application {

/*	public static void main(String[] args) {

		StraightCypher crypt = new StraightCypher();
		Automata a = new TrivialAutomata();
		crypt.setAutomata(a);
		try {
			FileInputStream fi = new FileInputStream("suka");
			FileOutputStream fo = new FileOutputStream("sukad");
			crypt.crypt(fi, fo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void printMatrix(byte[] b) {
		for(int i=0;i<b.length;i++)
			System.out.print(String.format("%02X ", b[i]));

		System.out.println("");
	}
*/
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fine.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root, 500, 350);
		stage.setTitle("FXML Welcome");
		stage.setScene(scene);


		UI_Controller controller = loader.getController();
		controller.setStage(stage);
		controller.addCypher(new StraightCypher());


		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}


}