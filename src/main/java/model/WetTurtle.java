package model;

import javafx.scene.image.Image;

/**
 * This class represents Turtle character in sunk state where Turtle character
 * dives into river. <i>(see {@link Turtle} for more info)</i> <br>
 * <br>
 * <b>Modification made : <br>
 * 1 - Change direct superclass from </b><code>Actor_Characters</code><b> to
 * </b><code>Turtle</code>; <br>
 * common field between this class and {@link AboveWaterTurtle} class is
 * extracted to form{@link Turtle} abstract class <br>
 * <b>2 - Set access modifier of all fields to </b> <code>private</code> <b>and
 * Add getter/setter method for </b> <code>private</code> <b>fields to support
 * data encapsulation <br>
 * 3 - Field </b><code> int i = 1</code> <b>and
 * </b><code>int bool = true</code><b> is removed since this field is not used
 * throughout program</b> <br>
 * <b>4 - All </b><code>private</code><b> attribute is internally accessed
 * through getter/setter method;<br>
 * (Enforce Self-Encapsulation Field in class to support the
 * UniformAccessPrinciple)</b>
 * 
 * @see Turtle
 * @see Actor_Characters
 */
public class WetTurtle extends Turtle {
	/**
	 * Extra image in animation series; <br>
	 * Animation series for Turtle character in sunken state requires 4 image
	 * instead of 3 as declared in {@link Turtle}
	 */
	private Image turtle4;
	/**
	 * To indicate if Turtle character is under or above water <br>
	 * <code>true</code> - sunk under water<br>
	 * <code>false</code> - above water
	 **/
	private boolean sunk = false;

	/** @see Actor_Characters#act */
	@Override
	public void act(long now) {

		if (now / 900000000 % 4 == 0) {
			setImage(getTurtle2());
			setSunk(false);

		} else if (now / 900000000 % 4 == 1) {
			setImage(getTurtle1());
			setSunk(false);
		} else if (now / 900000000 % 4 == 2) {
			setImage(getTurtle3());
			setSunk(false);
		} else if (now / 900000000 % 4 == 3) {
			setImage(getTurtle4());
			setSunk(true);
		}

		move(getSpeed(), 0);
		if (getX() > 600 && getSpeed() > 0) {
			setX(-200);
		}
		if (getX() < -75 && getSpeed() < 0) {
			setX(600);
		}
	}

	/**
	 * Set position of Turtle character, moving speed and size of image of character
	 * upon construction of Object
	 * 
	 * @param xpos X Coordinate of character
	 * @param ypos Y Coordinate of character
	 * @param s    Speed of character moving by
	 * @param w    Width of displayed image of character
	 * @param h    Height of displayed image of character
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		setTurtle1(new Image("file:src/main/resources/turtle/TurtleAnimation1.png", w, h, true, true));
		setTurtle2(new Image("file:src/main/resources/turtle/TurtleAnimation2Wet.png", w, h, true, true));
		setTurtle3(new Image("file:src/main/resources/turtle/TurtleAnimation3Wet.png", w, h, true, true));
		setTurtle4(new Image("file:src/main/resources/turtle/TurtleAnimation4Wet.png", w, h, true, true));
		setX(xpos);
		setY(ypos);
		setSpeed(s);
		setImage(getTurtle2());
	}

	/** @return sunk state of Turtle */
	public boolean isSunk() {
		return sunk;
	}

	/**
	 * @return Fourth image of {@link Turtle} character in animation series
	 */
	Image getTurtle4() {
		return turtle4;
	}

	/**
	 * Change image of turtle4 in animation series
	 * 
	 * @param turtle4 new image to be displayed
	 */
	void setTurtle4(Image turtle4) {
		this.turtle4 = turtle4;
	}

	/**
	 * @param sunk state of Turtle (under or above water)
	 */
	void setSunk(boolean sunk) {
		this.sunk = sunk;
	}
}
