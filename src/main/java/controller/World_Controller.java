package controller;

import java.util.ArrayList;
import java.util.List;

import com.sun.glass.ui.Timer;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.Actor;
import model.Actor_Characters;
import view.MyStage_ViewRenderer;

/**
 * Detects any changes at gameplay scene <br>
 * <br>
 * <b> Modification done : <br>
 * 1 - Add getter and setter method for<code> private </code>field</b>
 * <code>timer</code> <br>
 * <b> 2 - Deleted <code>public abstract method act(long now)</code> in this
 * abstract class as it is not used by inheriting subclass </b>
 * {@link MyStage_ViewRenderer} <br>
 * <b>3 - All </b><code>private</code><b> attribute is internally accessed
 * through getter/setter method;<br>
 * (Enforce Self-Encapsulation Field in class to support the
 * UniformAccessPrinciple)</b>
 * 
 * @see javafx.scene.layout.Pane
 **/
public abstract class World_Controller extends Pane {
	/**
	 * Timer that is called in each frame while the game is active
	 * 
	 * @see javafx.animation.AnimationTimer
	 **/
	private AnimationTimer timer;

	/**
	 * Detect key event happening to main game scene <br>
	 * A {@link Timer} Object must be created when game starts.
	 */
	public World_Controller() {
		// Detect any changes to scene property
		sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				// if there is any new changes
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if (getOnKeyReleased() != null) {
								getOnKeyReleased().handle(event);
							}
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor : myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}

					});

					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if (getOnKeyPressed() != null) {
								getOnKeyPressed().handle(event);
							}
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor : myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}

					});
				}

			}

		});
	}

	/**
	 * Use timer to declare flow of activity done by each character at each frame
	 **/
	public void createTimer() {
		setTimer(new AnimationTimer() {
			@Override
			public void handle(long now) {
				// act(now);
				List<Actor_Characters> actors = getObjects(Actor_Characters.class);

				for (Actor_Characters anActor : actors) {
					anActor.act(now);
				}

			}
		});
	}

	/** Upon starting game, create Timer object and start Timer object */
	public void start() {
		createTimer();
		getTimer().start();
	}

	/** Stop Timer object */
	public void stop() {
		getTimer().stop();
	}

	/**
	 * Add Actor to layout
	 * 
	 * @param actor Actor element to be added to main game layout
	 **/
	public void add(Actor actor) {
		getChildren().add(actor);
	}

	/**
	 * Remove Actor from layout
	 * 
	 * @param actor Actor element to be removed to main game layout
	 **/
	public void remove(Actor actor) {
		getChildren().remove(actor);
	}

	public <A extends Actor> List<A> getObjects(Class<A> cls) {
		ArrayList<A> someArray = new ArrayList<A>();
		for (Node n : getChildren()) {
			if (cls.isInstance(n)) {
				someArray.add((A) n);
			}
		}
		return someArray;
	}

	/**
	 * Return timer <br>
	 * <br>
	 * <b>Modification done : Add getter method </b> <br>
	 * 
	 * @return the timer
	 */
	public AnimationTimer getTimer() {
		return timer;
	}

	/***
	 * Set timer <br>
	 * <br>
	 * <b>Modification done : Add setter method </b> <br>
	 * 
	 * @param timer the timer to be set
	 */
	public void setTimer(AnimationTimer timer) {
		this.timer = timer;
	}

}
