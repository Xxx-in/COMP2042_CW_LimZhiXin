package model;

import javafx.scene.image.Image;

/**
 * This class represents any background image in game scene<br>
 * <br>
 * 
 * <b>No modification made </b>
 * 
 * @see model.Actor
 **/

public class BackgroundImage extends Actor {

	/**
	 * Assign image to be displayed to BackgroundImage object upon construction
	 * 
	 * @param imageLink local path to image
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
	}

}
