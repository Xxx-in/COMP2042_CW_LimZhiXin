package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends Actor {
	int dim;
	Image im1;

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub

	}

	/**
	 * <p>
	 * Set image of digit to be displayed in Main Stage
	 * 
	 * @param n   digit to display
	 * @param dim set size of displayed image
	 * @param x   set coordinate x of image displayed
	 * @param y   set coordinate y of image displayed
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:resources/displayNum/" + n + ".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}

}
