package model;

/**
 * <b>Modified from {@link Actor} Class </b> <br>
 * 
 * Actor Characters are a specialized type of Actors in the gameplay, they are
 * responsive elements that is constantly moving throughout the gameplay.
 * 
 * @see Actor
 **/
public abstract class Actor_Characters extends Actor {
	/**
	 * Move characters
	 * 
	 * @param dx Move Actor element to the left(if negative value given) or right(if
	 *           positive value given) by given value
	 * @param dy Move Actor Element to the down(if negative value given) or up(if
	 *           positive value given) by given value
	 **/
	public void move(double dx, double dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}

	/**
	 * To define movement of Actor Characters during the current moment, movement
	 * last throughout the entire game
	 * 
	 * @param now indicates the current moment
	 **/
	public abstract void act(long now);

}
