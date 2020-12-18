package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MyStage_ViewRenderer;

/**
 * <b>Newly added class; support addition of Start Scene in game</b> <br>
 * <br>
 * This class handles provides the functionality of buttons included in Start
 * scene .
 *
 */
public class StartScene_Controller {

	/**
	 * Change Start scene to Instruction Scene @throws Exception
	 */
	public void changeScenetoInstruction(ActionEvent event) throws Exception {
		// Make pane to scene
		Parent InstructionSceneParent = FXMLLoader
				.load(getClass().getResource("/startScene/fxml/InstructionScene.fxml"));
		Scene InstructionScene = new Scene(InstructionSceneParent);
		InstructionScene.getStylesheets()
				.addAll(this.getClass().getResource("/startScene/css/InstructionScene.css").toExternalForm());
		// get Stage
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		// set Stage
		stage.setScene(InstructionScene);
		stage.show();
	}

	/** Change Start scene to Gameplay Scene * @throws Exception */
	public void changeScenetoGame(ActionEvent event) throws Exception {
		// Make pane to scene
		MyStage_ViewRenderer background = new MyStage_ViewRenderer();
		Scene gameScene = new Scene(background, 565, 800);
		// get Stage
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		// set Stage
		stage.setScene(gameScene);
		stage.show();
		// start game
		background.start();
		GameTimer_Controller gameTimer = new GameTimer_Controller(background);
		gameTimer.start();
	}

}
