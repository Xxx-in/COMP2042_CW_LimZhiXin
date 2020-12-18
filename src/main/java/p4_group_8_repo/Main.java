package p4_group_8_repo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.MyStage_ViewRenderer;

/**
 * Entry point of Application <br>
 * <br>
 * <b>Modification made : <br>
 * 1 - Use newly added </b> setStage() <b>method in {@link MyStage_ViewRenderer}
 * class at </b>start()<b> method to draw out game scene * <br>
 * 2 - Scene to display at entry point of application is changed to Start scene.
 * </b>
 * 
 * @see javafx.application.Application
 * @see MyStage_ViewRenderer
 * 
 **/
public class Main extends Application {

	/**
	 * Application's point of entry
	 * 
	 * @param args -
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Display Scene on Primary Stage <br>
	 * <b>Modification made :<br>
	 * 1 - Use method call to create Scene. <br>
	 * 2 - Scene to display at entry point of application is changed to Start scene.
	 * </b>
	 * 
	 * @param primaryStage Primary Stage of Application
	 * @see MyStage_ViewRenderer#MyStage_ViewRenderer()
	 **/

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/startScene/fxml/StartScene.fxml"));
		Scene scene = new Scene(root, 565, 800);
		scene.getStylesheets().addAll(this.getClass().getResource("/startScene/css/StartScene.css").toExternalForm());
		primaryStage.getIcons().add(new Image("file:src/main/resources/icon-frogger-pixel-512x512.png"));
		primaryStage.setTitle("FroggerCW");
		primaryStage.setScene(scene);
		primaryStage.show();
		// start();
	}
}