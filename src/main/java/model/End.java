package model;

import org.apache.maven.model.Activation;
import org.hamcrest.core.Is;

import javafx.scene.image.Image;

/**
 * This {@link Class} represents the EndBoxes(also known as <i>End</i>) in the
 * game, which is the final goal where Frogger jumps into. <br>
 * <br>
 * <b>Modification made : <br>
 * 1 - Added setter method for</b> <code>private</code> <b>field </b>
 * <code>activated</code> <b> to support data encapsulation </b> <br>
 * <b>2 - All </b><code>private</code><b> attribute is internally accessed
 * through getter/setter method;<br>
 * (Enforce Self-Encapsulation Field in class to support the
 * UniformAccessPrinciple)</b>
 * 
 * @see Actor_Characters
 **/
public class End extends Actor_Characters {
	/**
	 * To indicate whether Frogger has already jumped into the box <br>
	 * <br>
	 * <b>Modification made : <br>
	 * Access modifier of attribute changed to </b> <code>private</code> <br>
	 * <code>true</code> - EndBox {@link Is} occupied, else <code>false</code>
	 **/
	private boolean activated = false;

	/** @see Actor_Characters#act **/
	@Override
	public void act(long now) {
	}

	/**
	 * Set position and image of EndBox to be displayed upon construction
	 * 
	 * @param x X Coordinate to display EndBox created
	 * @param y Y Coordinate to display EndBox created
	 **/
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/endInBox/End.png", 60, 60, true, true));
	}

	/**
	 * When Frogger jumps into EndBox, change image to display occupied EndBox and
	 * set activation status to true
	 * 
	 * @see End#activated
	 */
	public void setEnd() {
		setImage(new Image("file:src/main/resources/endInBox/FrogEnd.png", 70, 70, true, true));
		setActivated(true);
	}

	/**
	 * Get activation status (check if Frogger had jumped into Endbox already)
	 * 
	 * @return {@link Activation} status of EndBox <br>
	 *         (If <code>true</code>, then Frogger has leaped into the EndBox
	 *         already, else if <code>false</code>, Frogger has not leaped into the
	 *         EndBox yet)
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * <b> Added setter method</b> <br>
	 * <br>
	 * Set activation status of EndBox
	 * 
	 * @param activated the activated to set
	 */
	public void setActivated(boolean activated) {
		this.activated = activated;
	}

}
