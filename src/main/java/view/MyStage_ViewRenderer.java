package view;

import java.io.File;

import controller.World_Controller;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.AboveWaterTurtle;
import model.Animal;
import model.BackgroundImage;
import model.Digit;
import model.End;
import model.Log;
import model.Obstacle;
import model.WetTurtle;

/**
 * Renderer class for gameplay scene; <br>
 * Set up layout when game starts which includes setting background image,
 * setting background music and creating characters in game
 * <p>
 * <b> See below for modification done : <br>
 * 1 - Added initialization steps in <code>constructor</code> <br>
 * 2 - Set access modifier of attributes to </b> <code>private</code> <b>and set
 * getter and setter methods for </b> <code>private</code> <b> attribute to
 * support data encapsulation. <br>
 * 3 - Initially, <code>playMusic()</code> method is in charge setting
 * background music and playing background music. <br>
 * In order to maintain single responsibility for each method,
 * <code>setMusic()</code> method is created to handle functionality of setting
 * background Music while <code> playMusic()</code> is only in charge of playing
 * background music.</b> <br>
 * <b>4 - All </b><code>private</code><b> attribute is internally accessed
 * through getter/setter method;<br>
 * (Enforce Self-Encapsulation Field in class to support the
 * UniformAccessPrinciple)</b>
 * 
 * @see controller.World_Controller
 * @see javafx.scene.layout.Pane
 */
public class MyStage_ViewRenderer extends World_Controller {
	/**
	 * Act as a controller to play background music
	 * 
	 * @see javafx.scene.media.MediaPlayer
	 */
	private MediaPlayer mediaPlayer;
	/**
	 * Represents main character object (Frogger character) in game
	 * 
	 * @see Animal
	 **/
	private Animal animal;
	/** Background image of main game scene **/
	private BackgroundImage froggerback;

	/*
	 * @Override public void act(long now) {
	 * 
	 * }
	 */
	/**
	 * Upon constructing object from class, set background image and create
	 * characters in game <br>
	 * <br>
	 * <b> Modification made : Move line 24-98 from Main.java that performs
	 * rendering(designing) of game scene to constructor </b>
	 **/
	public MyStage_ViewRenderer() {

//		mediaPlayer.play();
//		mediaPlayer.setOnEndOfMedia(new Runnable() {
//
//			@Override
//			public void run() {
//				mediaPlayer.seek(Duration.ZERO);
//				
//			}
//			
//		});
//		mediaPlayer.play();

		// Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",
		// 25, 25, 3);
		// Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png",
		// 100, 100,2 );
		// Obstacle obstacle2 = new
		// Obstacle("file:src/p4_group_8_repo/truck1Right.png",0, 150, 1);

		froggerback = new BackgroundImage("file:src/main/resources/background_image/iKogsKW.png");
		this.add(froggerback);
		this.add(new Log("file:src/main/resources/log/log3.png", 150, 0, 166, 0.75));
		this.add(new Log("file:src/main/resources/log/log3.png", 150, 220, 166, 0.75));
		this.add(new Log("file:src/main/resources/log/log3.png", 150, 440, 166, 0.75));
		// this.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166,
		// 0.75));
		this.add(new Log("file:src/main/resources/log/logs.png", 300, 0, 276, -2));
		this.add(new Log("file:src/main/resources/log/logs.png", 300, 400, 276, -2));
		// this.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276,
		// -2));
		this.add(new Log("file:src/main/resources/log/log3.png", 150, 50, 329, 0.75));
		this.add(new Log("file:src/main/resources/log/log3.png", 150, 270, 329, 0.75));
		this.add(new Log("file:src/main/resources/log/og3.png", 150, 490, 329, 0.75));
		// this.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329,
		// 0.75));

		this.add(new AboveWaterTurtle(500, 376, -1, 130, 130));
		this.add(new AboveWaterTurtle(300, 376, -1, 130, 130));
		this.add(new WetTurtle(700, 376, -1, 130, 130));
		this.add(new WetTurtle(600, 217, -1, 130, 130));
		this.add(new WetTurtle(400, 217, -1, 130, 130));
		this.add(new WetTurtle(200, 217, -1, 130, 130));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 100, 1));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 0, 100, 1));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 120, -1));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 120, -1));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 140, 1));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 140, 1));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 160, -1));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 300, 160, -1));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 180, 1));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 180, 1));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200, -1));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200, -1));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
		// this.add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
		// End end2 = new End();
		// End end3 = new End();
		// End end4 = new End();
		// End end5 = new End();
		this.add(new End(13, 96));
		this.add(new End(141, 96));
		this.add(new End(141 + 141 - 13, 96));
		this.add(new End(141 + 141 - 13 + 141 - 13 + 1, 96));
		this.add(new End(141 + 141 - 13 + 141 - 13 + 141 - 13 + 3, 96));
		animal = new Animal("file:src/main/resources/frog_movement/froggerUp.png");
		this.add(animal);
		this.add(new Obstacle("file:src/main/resources/truck/truck1" + "Right.png", 0, 649, 1, 120, 120));
		this.add(new Obstacle("file:src/main/sresources/truck/truck1" + "Right.png", 300, 649, 1, 120, 120));
		this.add(new Obstacle("file:src/main/resources/truck/truck1" + "Right.png", 600, 649, 1, 120, 120));
		// this.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png",
		// 720, 649, 1, 120, 120));
		this.add(new Obstacle("file:src/main/resources/car/car1Left.png", 100, 597, -1, 50, 50));
		this.add(new Obstacle("file:src/main/resources/car/car1Left.png", 250, 597, -1, 50, 50));
		this.add(new Obstacle("file:src/main/resources/car/car1Left.png", 400, 597, -1, 50, 50));
		this.add(new Obstacle("file:src/main/resources/car/car1Left.png", 550, 597, -1, 50, 50));
		this.add(new Obstacle("file:src/main/resources/truck/truck2Right.png", 0, 540, 1, 200, 200));
		this.add(new Obstacle("file:src/main/resources/truck/truck2Right.png", 500, 540, 1, 200, 200));
		this.add(new Obstacle("file:src/main/resources/car/car1Left.png", 500, 490, -5, 50, 50));
		this.add(new Digit(0, 30, 500, 25));
	}

	/**
	 * Set background music
	 * 
	 * @param musicFile   local path to audio file for background music of game
	 * @param mediaplayer MediaPlayer Object that is controlling audio of this scene
	 * @see MediaPlayer
	 **/
	public void setMusic(String musicFile, MediaPlayer mediaplayer) {
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
	}

	/** Play background music **/
	public void playMusic() {
		setMusic("src/main/resources/Frogger Main Song Theme (loop).mp3", this.mediaPlayer);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
	}

	/** Stop background music **/
	public void stopMusic() {
		mediaPlayer.stop();
	}

	/**
	 * @return the mediaPlayer
	 */
	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}

	/**
	 * @param mediaPlayer the mediaPlayer to set
	 */
	public void setMediaPlayer(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

	/**
	 * @return the animal
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * @param animal the animal to set
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	/**
	 * @return the froggerback
	 */
	public BackgroundImage getFroggerback() {
		return froggerback;
	}

	/**
	 * @param froggerback the froggerback to set
	 */
	public void setFroggerback(BackgroundImage froggerback) {
		this.froggerback = froggerback;
	}

}
