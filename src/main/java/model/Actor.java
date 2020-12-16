package model;

import java.util.ArrayList;

import controller.World_Controller;
import javafx.scene.image.ImageView;

/**
 * This class represents Actors in the gameplay.<br>
 * <br>
 * All responsive elements on the gameplay scene is an Actor of the game. There
 * are 2 types of actors in this game: Actor Characters and Actor
 * Non-Characters. <br>
 * <br>
 * Characters are responsive elements that is actively moving in the gameplay
 * <i> (etc. Truck and Car objects of {@link Obstacle} class)</i>; whereas
 * Non-characters are responsive elements that is stationary and stays in a
 * fixed spot <i> (etc. Score display, {@link BackgroundImage}).</i><br>
 * <br>
 * Non-characters will be inheriting this class directly while Characters will
 * be inheriting from {@link Actor_Characters}, which is an abstract subclass of
 * {@link Actor} class since Characters are considered a specialized type of
 * Actor. <br>
 * <br>
 * <b>Modification made : <br>
 * 1 - Remove <code>abstract method void act(long now)</code> from this class;
 * </b> <br>
 * since class {@link BackgroundImage}, {@link Digit}, {@link End} which
 * inherits this class does not need this method. (Empty implementation body is
 * given this method in the 3 classes initially) <br>
 * <b> 2 - Shift <code> move(double dx, double dy)</code> method to
 * {@link Actor_Characters}class; </b><br>
 * since Non-Characters does not need to move and will always stay at a fixed
 * spot. <br>
 * <br>
 * <b> 3 - Change concrete </b><code>Actor</code><b> class to become </b>
 * <code>abstract</code> <b>class;</b><br>
 * since all direct subclass of Actor must inherit
 * 
 * @see javafx.scene.image.ImageView
 * @see model.Actor_Characters
 */
public abstract class Actor extends ImageView {

	/**
	 * Get parent node (layout pane)
	 * 
	 * @return Layout Pane of main game scene
	 */
	public World_Controller getWorld() {
		return (World_Controller) getParent();
	}

	/**
	 * Get width of Stage
	 * 
	 * @return height of Stage
	 */
	public double getWidth() {
		return this.getBoundsInLocal().getWidth();
	}

	/**
	 * Get height of Stage
	 * 
	 * @return width of Stage
	 **/
	public double getHeight() {
		return this.getBoundsInLocal().getHeight();
	}

	// @Override
	public <A extends Actor_Characters> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls) {
		ArrayList<A> someArray = new ArrayList<A>();
		for (A actor : getWorld().getObjects(cls)) {
			if (actor != this && actor.intersects(this.getBoundsInLocal())) {
				someArray.add(actor);
			}
		}
		return someArray;
	}
	/*
	 * public void manageInput(InputEvent e) {
	 * 
	 * }
	 * 
	 * public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
	 * ArrayList<A> someArray = new ArrayList<A>(); for (A actor:
	 * getWorld().getObjects(cls)) { if (actor != this &&
	 * actor.intersects(this.getBoundsInLocal())) { someArray.add(actor); break; } }
	 * return someArray.get(0); }
	 */

}
