package hope;

import automata.Automata;
import automata.TrivialAutomata;
import automata.block.BlockAutomata;
import automata.block.rules.*;
import cypher.StraightCypher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
		Parent root = FXMLLoader.load(getClass().getResource("/fine.fxml"));

		Scene scene = new Scene(root, 500, 350);

		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}