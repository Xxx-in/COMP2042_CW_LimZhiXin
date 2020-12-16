package model;

import javafx.scene.image.Image;

/**
 * <b>Newly added abstract class by extracting common fields of</b>
 * {@link WetTurtle} <b>and initial </b><code>Turtle</code><b> class which is
 * currently renamed as</b> {@link AboveWaterTurtle}. <br>
 * <br>
 * This class represents the {@link Turtle} Character in the gameplay.The Turtle
 * Character can be found at the river area. Player's Frogger character will
 * interact with {@link Turtle} by hopping on its back to get across the River
 * area. <br>
 * <br>
 * The Turtle has 2 status - <i>sunken</i> and <i>above water</i>. When it is
 * above water, main character Frogger can stay on top of it safely; when the
 * Turtle character in sunken, Frogger character cannot land on it and will
 * cause death of Frogger character. <br>
 * <br>
 * {@link AboveWaterTurtle} class defines Turtle's characteristic when water and
 * {@link WetTurtle} defines Turtle's characteristic when it is sunken.
 * 
 * @see Actor_Characters
 * @see WetTurtle
 * @see AboveWaterTurtle
 */

public abstract class Turtle extends Actor_Characters {

	/** First image of Turtle in animation series */
	private Image turtle1;
	/** Second image of Turtle in animation series */
	private Image turtle2;
	/** Third image of Turtle in animation series */
	private Image turtle3;
	/** Speed of Turtle character moving by */
	private int speed;

	public Turtle() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return First image of {@link Turtle} character in animation series
	 */
	public Image getTurtle1() {
		return turtle1;
	}

	/**
	 * Change image of turtle1 in animation series
	 * 
	 * @param turtle1 new image to be displayed
	 */
	public void setTurtle1(Image turtle1) {
		this.turtle1 = turtle1;
	}

	/**
	 * @return Second image of {@link Turtle} character in animation series
	 **/
	public Image getTurtle2() {
		return turtle2;
	}

	/**
	 * Change image of turtle2 in animation series
	 * 
	 * @param turtle2 new image to be displayed
	 */
	public void setTurtle2(Image turtle2) {
		this.turtle2 = turtle2;
	}

	/**
	 * @return Third image of {@link Turtle} character in animation series
	 */
	public Image getTurtle3() {
		return turtle3;
	}

	/**
	 * Change image of turtle4 in animation series
	 *
	 * @param turtle3 new image to be displayed
	 */
	public void setTurtle3(Image turtle3) {
		this.turtle3 = turtle3;
	}

	/**
	 * @return the speed of Turtle character
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
