# COMP2042_CW_LimZhiXin
UNMC 2020/2021 Spring Semester 

1. Import JAR
2. Set up Maven plugin on eclipse
3. Run > Run Configurations > At Goals column, type "clean javafx:run" (without "") > Run
UML Class Diagram is under src/main/resources/UML Class Diagram

Part 1
#Use Maven & set up pom.xml file
#added background
#split to resource vs src file & reconnect
#move digit
#add icon & title

Part 2
#Continue detailed housekeeping
1. Actor.java delete unused manageInput() function at line 38
2. Actor.java delete repeated function line 42-50
#Fix error after orgranizing file
1.file:resources/path --> file:src/main.resources/path
#Modify code to allow control with arrow key
#Split ViewRenderer from Main.java
- Move line 24-98 from Main.java to constructor of MyStage class
#Rename MyStage class to MyStage_ViewRenderer 
- Better represent functionality
#Move MyStage to View package
-Change access modifier of attribute from private to support encapsulation
#Delete abstract method act() in World since it is not used
-Delete in inheriting class MyStage_ViewRenderer too (Line 35-40)
#Interface Segregation Principle of Solid Principle
-Seperate void act(long now) method from Actor since Background/Digit/End class which inherits
Actor class do not need it
-Concrete class Actor & abstract class Actor with abstract method void (act long)
-Move function move(double dx, double dy) to Actor_Character
-Delete void act longnow in Digit and background
#Complete excapsulation (Add missing getter/setter method) for further use 
- Log.java, Line 10 : provide getter function for speed;
#Chanege access modifier of all attribute to private
#Support single responsibility 
Line 144 - 150 MyStage_ViewRenderer, playMusic() function is in charge of setting music to be played @ playing music. 
#Remove dead code unused 
Line 37-38 private int i & boolean bbool deleted
#Self-Encapsulation 
make all reference to private be done in getter/setter method
uniform access principle
#Created abstract class from Turtle & WetTurtle by extracting common fields

Part 3 
Add Start Scene, Extract new class "GameTimer_Controller" and Refactoring

1. Add Start Scene
- Added required resources to new folder "startScene" in src/main/resources folder
- Added new class "StartScene_Controller" and "InstructionScene_Controller" in src/mainjava/controller package to provide functionality of button

2.Extracted new class "GameTimer_Controller" from Main.java
- Class is responsible for controlling flow of game (when to display End Game scene, etc.)

