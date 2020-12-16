package model;

import javafx.scene.image.Image;

/**
 * This class represents the obstacles in gameplay which includes <i>Truck</i>
 * and <i>Car</i> characters which are found at the Road area. Player's Frogger
 * character have to avoid {@link Obstacle} characters when crossing the road;
 * "touching" any {@link Obstacle} characters will cause "death" of Frogger
 * character.<br>
 * <br>
 * <b>Modification made : <br>
 * 1 - Add getter/setter method for </b> <code>private</code> <b> field</b>
 * <code>speed</code> <b> support data encapsulation </b> <br>
 * <b>2 - All </b><code>private</code><b> attribute is internally accessed
 * through getter/setter method;<br>
 * (Enforce Self-Encapsulation Field in class to support the
 * UniformAccessPrinciple)</b>
 * 
 * @see Actor_Characters
 */

public class Obstacle extends Actor_Characters {
	/** Indicates speed which obstacle is moving by */
	private int speed;

	/**
	 * @see Actor_Characters#act
	 **/
	@Override
	public void act(long now) {
		move(getSpeed(), 0);
		if (getX() > 600 && getSpeed() > 0) {
			setX(-200);
		}
		if (getX() < -50 && getSpeed() < 0) {
			setX(600);
		}
	}

	/**
	 * Set image of {@link Obstacle}, speed of {@link Obstacle} and postiion of
	 * {@link Obstacle}upon construction
	 * 
	 * @param imageLink local path to image to be displayed
	 * @param xpos      X coordinate of image displayed
	 * @param ypos      Y coordinate of image displayed
	 * @param s         speed of {@link Obstacle} moving by
	 * @param w         set width of image to be displayed
	 * @param h         set height of image to be displayed
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w, h, true, true));
		setX(xpos);
		setY(ypos);
		setSpeed(s);
	}

	/**
	 * <b>Added getter method</b>
	 * 
	 * @return speed of current
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * <b>Added setter method</b>
	 * 
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
