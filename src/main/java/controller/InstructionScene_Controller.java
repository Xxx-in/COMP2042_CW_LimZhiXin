package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * <b>Newly added class; support addition of Start Scene in game</b> <br>
 * <br>
 * This class handles provides the functionality of buttons included in
 * Instruction Scene .
 *
 */
public class InstructionScene_Controller {
	/**
	 * Change Instruction scene to Start scene
	 * 
	 * @param event -
	 * @throws Exception
	 */
	public void changeScenetoStartScene(ActionEvent event) throws Exception {
		// Make pane to scene
		Parent StartSceneParent = FXMLLoader.load(getClass().getResource("/startScene/fxml/StartScene.fxml"));
		Scene StartScene = new Scene(StartSceneParent);
		StartScene.getStylesheets()
				.addAll(this.getClass().getResource("/startScene/css/StartScene.css").toExternalForm());
		// get Stage
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		// set Stage
		stage.setScene(StartScene);
		stage.show();
	}

}
