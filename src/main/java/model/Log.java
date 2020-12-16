package model;

import javafx.scene.image.Image;

/**
 * This class represents the {@link Log} characters in the gameplay which is
 * found at the River area. Player's Frogger character will interact with
 * {@link Log} by hopping onto it to get across the River area. <br>
 * <br>
 * <b> Modification made : <br>
 * </b> 1 - Add getter/setter method for <code>private</code> <b>attribute to
 * support data encapsulation</b> <br>
 * <b>2- All </b><code>private</code><b> attribute is internally accessed
 * through getter/setter method;<br>
 * (Enforce Self-Encapsulation Field in class to support the
 * UniformAccessPrinciple)</b>
 * 
 * @see Actor_Characters
 *
 **/
public class Log extends Actor_Characters {

	/** Speed of log moving by **/
	private double speed;

	/**
	 * <b>Added getter method</b>
	 * 
	 * @return the speed of log
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @param speed desired speed of log
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public void act(long now) {
		move(getSpeed(), 0);
		if (getX() > 600 && getSpeed() > 0) {
			setX(-180);
		}
		if (getX() < -300 && getSpeed() < 0) {
			setX(700);
		}
	}

	/**
	 * @param imageLink local path to displayed image
	 * @param xpos      initial X coordinate position to display image
	 * @param ypos      initial Y coordinate position to display image
	 * @param s         speed of log moving by
	 * @param size      size of image displayed
	 **/
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size, size, true, true));
		setX(xpos);
		setY(ypos);
		setSpeed(s);

	}

	/**
	 * Check if speed of log is lesser than 0
	 * 
	 * @return boolean value to indicate if speed of log is lesser than 0;<br>
	 *         <code>true</code> if speed is lesser than 0, else <code>false</code>
	 */
	public boolean getLeft() {
		return getSpeed() < 0;
	}

}
