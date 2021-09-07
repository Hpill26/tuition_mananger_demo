package application;
	
/**
 * Loads the FXML file and launches the GUI
 * @author Brian Moran
 *
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TitledPane root = (TitledPane) FXMLLoader.load(getClass().getResource ("/application/Sample.fxml"));
			Scene scene = new Scene(root,600,650);
			primaryStage.setScene(scene);		
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
