package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Animal;
import model.Digit;
import view.MyStage_ViewRenderer;

/**
 * <b>Newly added class; initially extracted from Main.java</b> <br>
 * <br>
 * This class handles the flow of gameplay.
 *
 *
 */
public class GameTimer_Controller {
	AnimationTimer timer;
	/** Layout of main game scene **/
	MyStage_ViewRenderer gameStage;
	/** Object of Main Character, Frogger **/
	Animal animal;

	/**
	 * Initialise attribute with created Main Game scene
	 * 
	 * @param gameStage Main Game scene that was created when "Start" button in
	 *                  Start scene is clicked
	 * @see MyStage_ViewRenderer
	 * @see StartScene_Controller
	 */
	public GameTimer_Controller(MyStage_ViewRenderer gameStage) {
		this.animal = gameStage.getAnimal();
		this.gameStage = gameStage;
	}

	/**
	 * Create timer to control game flow when game starts<br<br>
	 */
	public void createTimer() {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (animal.changeScore()) {
					setNumber(animal.getPoints());
				}
				if (animal.getStop()) {
					System.out.print("STOP:");
					gameStage.stopMusic();
					stop();
					gameStage.stop();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("You Have Won The Game!");
					alert.setHeaderText("Your High Score: " + animal.getPoints() + "!");
					alert.setContentText("Highest Possible Score: 800");
					alert.show();
				}
			}
		};
	}

	public void start() {
		gameStage.playMusic();
		createTimer();
		timer.start();
	}

	public void stop() {
		timer.stop();
	}

	public void setNumber(int n) {
		int shift = 0;
		while (n > 0) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			gameStage.add(new Digit(k, 30, 360 - shift, 25));
			shift += 30;
		}
	}
}
