# COMP2042_CW_LimZhiXin
UNMC 2020/2021 Spring Semester 

#To run file
1. Import Frogger_Maven_LimZhiXin20204972.zip
2. Set up Maven plugin on eclipse
3. Run > Run Configurations > At Goals column, type "clean javafx:run" (without "") > Run

UML Class Diagram is under src/main/resources/UML Class Diagram

Javadocs is under target/apidocs/packageName/className after running step 3

*Note : Bolded text in Javadocs represents modification made 

#Part 1
1. Use Maven & set up pom.xml file
2. Added background
3. Organize files to src/main/java file(for  all .java files) and src/main/resources file (others)
3. Move digit
4. Add icon & title to Window

#Part 2
1. Continue detailed housekeeping
	- Actor.java delete unused manageInput() function at line 38
	- Actor.java delete repeated function line 42-50
2.	Modify code to allow control with arrow key (and WASD key)
3. Split ViewRenderer from Main.java
	- Move line 24-98 from Main.java to constructor of MyStage class
4. Rename MyStage class to MyStage_ViewRenderer 
	- Better represent functionality
5. Move MyStage to View package
	- Change access modifier of attribute from private to support encapsulation
6. Delete abstract method act() in World since it is not used
	- Delete in inheriting class MyStage_ViewRenderer too (Line 35-40)
7. Interface Segregation Principle of Solid Principle
	- Seperate void act(long now) method from Actor since Background/Digit/End class which inherits Actor class do not need it
	-Concrete class Actor & abstract class Actor with abstract method void (act long)
	-Move function move(double dx, double dy) to Actor_Character
	-Delete void act longnow in Digit and background
8. Complete excapsulation (Add missing getter/setter method) for further use 
	- Log.java, Line 10 : provide getter function for speed;
9. Chanege access modifier of all attribute to private
10. Support single responsibility 
	- Line 144 - 150 MyStage_ViewRenderer, playMusic() function is in charge of setting music to be played @ playing music. 
11. Remove dead code unused (code smell)
	- Line 37-38 private int i & boolean bbool deleted
12. Self-Encapsulation Field
	- make all reference to private be done in getter/setter method in order to support uniform access principle
13. Created abstract class from Turtle & WetTurtle by extracting common fields

#Part 3 
1. Add Start Scene
	- Added required resources to new folder "startScene" in src/main/resources folder
	- Added new class "StartScene_Controller" and "InstructionScene_Controller" in src/mainjava/controller package to provide functionality of button

2.Extracted new class "GameTimer_Controller" from Main.java
	- Class is responsible for controlling flow of game (when to display End Game scene, etc.)

