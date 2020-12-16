package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Animal;
import model.Digit;
import view.MyStage_ViewRenderer;

/**
 * Entry point of Application <br>
 * <br>
 * <b>Modification made : <br>
 * 1 - Use newly added </b> setStage() <b>method in {@link MyStage_ViewRenderer}
 * class at </b>start()<b> method to draw out scene </b>
 * 
 * @see javafx.application.Application
 * @see MyStage_ViewRenderer
 * 
 **/
public class Main extends Application {
	AnimationTimer timer;
	/** Layout of main game scene **/
	MyStage_ViewRenderer background;
	/** Object of Main Character, Frogger **/
	Animal animal;

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
	 * <b>Modification made : Use method call to create Scene </b>
	 * 
	 * @param primaryStage Primary Stage of Application
	 * @see MyStage_ViewRenderer#MyStage_ViewRenderer()
	 **/

	@Override
	public void start(Stage primaryStage) throws Exception {
		background = new MyStage_ViewRenderer();
		Scene scene = new Scene(background, 565, 800);
		animal = background.getAnimal();
		background.start();
		primaryStage.getIcons().add(new Image("file:src/main/resources/icon-frogger-pixel-512x512.png"));
		primaryStage.setTitle("FroggerCW");
		primaryStage.setScene(scene);
		primaryStage.show();
		start();
	}

	public void createTimer() {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (animal.changeScore()) {
					setNumber(animal.getPoints());
				}
				if (animal.getStop()) {
					System.out.print("STOP:");
					background.stopMusic();
					stop();
					background.stop();
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
		background.playMusic();
		createTimer();
		timer.start();
	}

	@Override
	public void stop() {
		timer.stop();
	}

	public void setNumber(int n) {
		int shift = 0;
		while (n > 0) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			background.add(new Digit(k, 30, 360 - shift, 25));
			shift += 30;
		}
	}
}
