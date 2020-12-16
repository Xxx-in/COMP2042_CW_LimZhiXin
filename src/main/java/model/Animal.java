package model;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * This class represents the main character of the game Frogger. Player will
 * play as Frogger and use arrow key/WASD keys to control the Frogger character.
 * When player is playing as Frogger character, player's aim is to avoid the
 * cars and trucks (see <code>Obstacle</code> class) on the Road area, passsing
 * the River area by hopping onto {@link Log} characters or Turtle characters.
 * Player's final goal is to get across the Road and River area and leap into
 * {@link End} boxes.
 * 
 * <br>
 * <br>
 * Frogger character dies when it is knocked by Car/Truck character in the Road
 * Area or when it falls into the River area. Players gain 10 points each time
 * they make it pass a row of Car/Truck/Log/Turtle and loses 50 points whenever
 * it dies. After player character dies, character will be returned to beginning
 * point; no marks will be deducted or allocated until player gets to the
 * previous row where it died.
 * 
 * <br>
 * <br>
 * <b>Modification made: <br>
 * 1 - Set access modifier of all fields to </b> <code>private</code> <b>and Add
 * getter/setter method for </b> <code>private</code> <b>fields to support data
 * encapsulation </b><br>
 * <b>2 - Change name of </b><code>movement</code><b> field to
 * </b><code>movementY</code><b> to better represent field</b>
 * 
 * @see Actor_Characters
 * @see Obstacle
 * 
 **/
public class Animal extends Actor_Characters {
	/** Image of Frogger when facing upwards **/
	private Image imgW1;
	/** Image of Frogger when facing left **/
	private Image imgA1;
	/** Image of Frogger when facing right **/
	private Image imgS1;
	/** Image of Frogger when facing downwards **/
	private Image imgD1;
	/** Image of Frogger when jumping upwards **/
	private Image imgW2;
	/** Image of Frogger when jumping left **/
	private Image imgA2;
	/** Image of Frogger when jumping right **/
	private Image imgS2;
	/** Image of Frogger when jumping downwards **/
	private Image imgD2;
	/**
	 * Player's score <br>
	 * Default value is 0 at the beginning of game
	 */
	private int points = 0;
	/**
	 * Number of EndBoxes that is currently occupied by Frogger; game ends when all
	 * 5 EndBoxes are occupied. <br>
	 * <br>
	 * Default value is 0 at the beginning of game
	 * 
	 * @see End
	 */
	private int end = 0;
	/** Used to set animation when Frogger character jumps */
	private boolean second = false;
	/**
	 * To disable control of player on Frogger character when Frogger character
	 * "dies". <br>
	 * <br>
	 * <code>true</code> - input of player cannot affect movement of Frogger
	 * character<br>
	 * <br>
	 * Default value = <code> false </code>
	 */
	private boolean noMove = false;
	/**
	 * Change Y coordinate of Frogger Character by value of <code>movementY</code>
	 * <br>
	 * <br>
	 * <b>Modification made :<br>
	 * Rename field from initial name</b><code>movement</code><b> to
	 * </b><code> movementY</code>
	 **/
	private double movementY = 13.3333333 * 2;
	/**
	 * Change X coordinate of Frogger Character by value of <code>movementY</code>
	 **/
	private double movementX = 10.666666 * 2;
	/**
	 * Size of image of Frogger character displayed
	 **/
	private int imgSize = 40;
	/**
	 * To indicate if Frogger character died due to "touching" Car or Truck
	 * character; <br>
	 * <code>true</code> - Frogger character died by "touching" obstacle<br>
	 * <br>
	 * Default value = <code> false </code>
	 * 
	 * @see Obstacle
	 */
	private boolean carDeath = false;
	/**
	 * To indicate if Frogger Character died due to falling into river;<br>
	 * <code>true</code> - Frogger character died by falling into river<br>
	 * <br>
	 * Default value = <code> false </code>
	 */
	private boolean waterDeath = false;
	private boolean stop = false;
	/** To indicate whether score player needs to be modified **/
	private boolean changeScore = false;
	/** Used to set animation of event when Frogger character dies by Car/Truck */
	private int carD = 0;
	/** Width of scene **/
	private double w = 800;
	private ArrayList<End> inter = new ArrayList<End>();

	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8 + movementY);
		imgW1 = new Image("file:src/main/resources/frog_movement/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/main/resources/frog_movement/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/main/resources/frog_movement/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/main/resources/frog_movement/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/main/resources/frog_movement/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/main/resources/frog_movement/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/main/resources/frog_movement/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/main/resources/frog_movement/froggerRightJump.png", imgSize, imgSize, true, true);
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (noMove) {

				} else {
					if (second) {
						if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
							move(0, -movementY);
							setChangeScore(false);
							setImage(imgW1);
							second = false;
						} else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
							move(-movementX, 0);
							setImage(imgA1);
							second = false;
						} else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
							move(0, movementY);
							setImage(imgS1);
							second = false;
						} else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
							move(movementX, 0);
							setImage(imgD1);
							second = false;
						}
					} else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
						move(0, -movementY);
						setImage(imgW2);
						second = true;
					} else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
						move(-movementX, 0);
						setImage(imgA2);
						second = true;
					} else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
						move(0, movementY);
						setImage(imgS2);
						second = true;
					} else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
						move(movementX, 0);
						setImage(imgD2);
						second = true;
					}
				}
			}
		});
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (noMove) {
				} else {
					if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
						if (getY() < getW()) {
							setChangeScore(true);
							setW(getY());
							points += 10;
						}
						move(0, -movementY);
						setImage(imgW1);
						second = false;
					} else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
						move(-movementX, 0);
						setImage(imgA1);
						second = false;
					} else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
						move(0, movementY);
						setImage(imgS1);
						second = false;
					} else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
						move(movementX, 0);
						setImage(imgD1);
						second = false;
					}
				}
			}

		});
	}

	/** @see Actor_Characters#act */
	@Override
	public void act(long now) {
		int bounds = 0;
		if (getY() < 0 || getY() > 734) {
			setX(300);
			setY(679.8 + movementY);
		}
		if (getX() < 0) {
			move(movementY * 2, 0);
		}
		if (isCarDeath()) {
			noMove = true;
			if ((now) % 11 == 0) {
				setCarD(getCarD() + 1);
			}
			if (getCarD() == 1) {
				setImage(
						new Image("file:src/main/resources/frog_carDeath/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (getCarD() == 2) {
				setImage(
						new Image("file:src/main/resources/frog_carDeath/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (getCarD() == 3) {
				setImage(
						new Image("file:src/main/resources/frog_carDeath/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (getCarD() == 4) {
				setX(300);
				setY(679.8 + movementY);
				setCarDeath(false);
				setCarD(0);
				setImage(
						new Image("file:src/main/resources/frog_movement/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points > 50) {
					points -= 50;
					setChangeScore(true);
				}
			}

		}
		if (isWaterDeath()) {
			noMove = true;
			if ((now) % 11 == 0) {
				setCarD(getCarD() + 1);
			}
			if (getCarD() == 1) {
				setImage(new Image("file:src/main/resources/frog_waterDeath/waterdeath1.png", imgSize, imgSize, true,
						true));
			}
			if (getCarD() == 2) {
				setImage(new Image("file:src/main/resources/frog_waterDeath/waterdeath2.png", imgSize, imgSize, true,
						true));
			}
			if (getCarD() == 3) {
				setImage(new Image("file:src/main/resources/frog_waterDeath/waterdeath3.png", imgSize, imgSize, true,
						true));
			}
			if (getCarD() == 4) {
				setImage(new Image("file:src/main/resources/frog_waterDeath/waterdeath4.png", imgSize, imgSize, true,
						true));
			}
			if (getCarD() == 5) {
				setX(300);
				setY(679.8 + movementY);
				setWaterDeath(false);
				setCarD(0);
				setImage(
						new Image("file:src/main/resources/frog_movement/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points > 50) {
					points -= 50;
					setChangeScore(true);
				}
			}

		}

		if (getX() > 600) {
			move(-movementY * 2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			setCarDeath(true);
		}
		if (getX() == 240 && getY() == 82) {
			setStop(true);
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if (getIntersectingObjects(Log.class).get(0).getLeft()) {
				move(-2, 0);
			} else {
				move(.75, 0);
			}
		} else if (getIntersectingObjects(AboveWaterTurtle.class).size() >= 1 && !noMove) {
			move(-1, 0);
		} else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				setWaterDeath(true);
			} else {
				move(-1, 0);
			}
		} else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points -= 50;
			}
			points += 50;
			setChangeScore(true);
			setW(800);
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8 + movementY);
		} else if (getY() < 413) {
			setWaterDeath(true);
			// setX(300);
			// setY(679.8+movement);
		}
	}

	public boolean getStop() {
		return end == 5;
	}

	public int getPoints() {
		return points;
	}

	public boolean changeScore() {
		if (isChangeScore()) {
			setChangeScore(false);
			return true;
		}
		return false;

	}

	/**
	 * @return the carDeath
	 */
	boolean isCarDeath() {
		return carDeath;
	}

	/**
	 * @param carDeath the carDeath to set
	 */
	void setCarDeath(boolean carDeath) {
		this.carDeath = carDeath;
	}

	/**
	 * @return the waterDeath
	 */
	boolean isWaterDeath() {
		return waterDeath;
	}

	/**
	 * @param waterDeath the waterDeath to set
	 */
	void setWaterDeath(boolean waterDeath) {
		this.waterDeath = waterDeath;
	}

	/**
	 * @return the stop
	 */
	boolean isStop() {
		return stop;
	}

	/**
	 * @param stop the stop to set
	 */
	void setStop(boolean stop) {
		this.stop = stop;
	}

	/**
	 * @return the changeScore
	 */
	public boolean isChangeScore() {
		return changeScore;
	}

	/**
	 * @param changeScore the changeScore to set
	 */
	public void setChangeScore(boolean changeScore) {
		this.changeScore = changeScore;
	}

	/**
	 * @return the carD
	 */
	int getCarD() {
		return carD;
	}

	/**
	 * @param carD the carD to set
	 */
	void setCarD(int carD) {
		this.carD = carD;
	}

	/**
	 * @return the w
	 */
	double getW() {
		return w;
	}

	/**
	 * @param w the w to set
	 */
	void setW(double w) {
		this.w = w;
	}

	/**
	 * @return the inter
	 */
	ArrayList<End> getInter() {
		return inter;
	}

	/**
	 * @param inter the inter to set
	 */
	void setInter(ArrayList<End> inter) {
		this.inter = inter;
	}

}
