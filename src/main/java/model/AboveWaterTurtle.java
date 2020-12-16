package model;

import javafx.scene.image.Image;

/**
 * This class represents Turtle character in above water state.<i>(see
 * {@link Turtle} for more info)</i> <br>
 * <br>
 * <b>Modification made : <br>
 * 1 - Change direct superclass from </b><code>Actor_Characters</code><b> to
 * </b><code>Turtle</code>; <br>
 * common field between this class and {@link WetTurtle} class is extracted to
 * form{@link Turtle} abstract class <br>
 * <b> 2 - Field </b><code> int i = 1</code> <b>and
 * </b><code>int bool = true</code> <b>is removed since this field is not used
 * throughout program</b> <br>
 * <b>3 - All </b><code>private</code><b> attribute is internally accessed
 * through getter/setter method;<br>
 * (Enforce Self-Encapsulation Field in class to support the
 * UniformAccessPrinciple)</b>
 * 
 * @see Turtle
 * @see Actor_Characters
 */
public class AboveWaterTurtle extends Turtle {

	/** @see Actor_Characters#act */
	@Override
	public void act(long now) {

		if (now / 900000000 % 3 == 0) {
			setImage(getTurtle2());

		} else if (now / 900000000 % 3 == 1) {
			setImage(getTurtle1());

		} else if (now / 900000000 % 3 == 2) {
			setImage(getTurtle3());

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
	public AboveWaterTurtle(int xpos, int ypos, int s, int w, int h) {
		setTurtle1(new Image("file:src/main/resources/turtle/TurtleAnimation1.png", w, h, true, true));
		setTurtle2(new Image("file:src/main/resources/turtle/TurtleAnimation2.png", w, h, true, true));
		setTurtle3(new Image("file:src/main/resources/turtle/TurtleAnimation3.png", w, h, true, true));
		setX(xpos);
		setY(ypos);
		setSpeed(s);
		setImage(getTurtle2());
	}
}
