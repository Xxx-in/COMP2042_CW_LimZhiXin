package model;

import javafx.scene.image.Image;

/**
 * This class represents the numerical values displayed on the main game screen.
 * It contains methods to handle displaying of numerical elements such as
 * displaying player's score. <br>
 * <br>
 * <b>Modification made : <br>
 * 1 - Set access modifier of all fields to </b> <code>private</code> <b>and Add
 * getter/setter method for </b> <code>private</code> <b> field to support data
 * encapsulation </b> <br>
 * <b>2 - All </b><code>private</code><b> attribute is internally accessed
 * through getter/setter method;<br>
 * (Enforce Self-Encapsulation Field in class to support the
 * UniformAccessPrinciple)</b>
 * 
 * @see model.Actor
 * 
 */
public class Digit extends Actor {
	/**
	 * Size of image of digit displayed <br>
	 * <br>
	 * <b>Modification made : <br>
	 * Access modifier of attribute changed to </b> <code>private</code>
	 */
	private int dim;
	/**
	 * Image to be displayed<br>
	 * <br>
	 * <b>Modification made : <br>
	 * Access modifier of attribute changed to </b> <code>private</code>
	 **/
	private Image im1;

	/**
	 * Set image of digit to be displayed in Main Stage
	 * 
	 * @param n   digit to display
	 * @param dim set size of displayed image
	 * @param x   set coordinate x of image displayed
	 * @param y   set coordinate y of image displayed
	 */
	public Digit(int n, int dim, int x, int y) {
		setIm1(new Image("file:src/main/resources/displayNum/" + n + ".png", dim, dim, true, true));
		setImage(getIm1());
		setX(x);
		setY(y);
	}

	/**
	 * <b>Added getter method</b>
	 * 
	 * @return size of image displayed
	 */
	public int getDim() {
		return dim;
	}

	/**
	 * <b>Added setter method</b> <br>
	 * <br>
	 * Change image display size
	 * 
	 * @param dim desired size to display image
	 */
	public void setDim(int dim) {
		this.dim = dim;
	}

	/**
	 * <b>Added getter method</b>
	 * 
	 * @return im1 Image of digit being displayed
	 */
	public Image getIm1() {
		return im1;
	}

	/**
	 * <b>Added setter method</b> <br>
	 * <br>
	 * Set image to be displayed
	 * 
	 * @param im1 set image of number to be displayed
	 */
	public void setIm1(Image im1) {
		this.im1 = im1;
	}

}
