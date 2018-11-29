package academy.schildkroetenSpiel;

import academy.schildkroetenSpiel.model.GameMenu;
import academy.schildkroetenSpiel.model.Model;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    static final double WIDTH = 1200;
    static final double HEIGHT = 300;

    private Timer timer; //wichtig: Den eigenen Timer verwenden, nicht einen anderen

    /*
    we create the stage of the game here, with one scene
    set basic setup for the game
     */

    public void start(Stage primaryStage) throws Exception {

        /*
        This is the start method where the whole program starts (like main). We instantiate a Canvas so we can use the canvas
        framework, we create a new scene with a primary stage where our game can happen.
        We instantiate a model, graphics and a timer, so that in this Main class all other important classes are instantiated
        and thus connected here.
         */


        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        Group group = new Group(); //we use a group as a "frame" to our children (Buttons, pictures, text) inside the frame. Groups resize with the size of their children.

        group.getChildren().addAll(canvas);

        Scene scene = new Scene(group);
        primaryStage.setScene(scene);

        /*
        Create instance of GameMenu class to be able to call setWelcomePane method, where layout of the game menu is defined
         */
        GameMenu gameMenu = new GameMenu();
        gameMenu.setWelcomePane(primaryStage,scene);

        primaryStage.show(); //GameMenu and the game itself are now part of the primaryStage, with method .show we make them display.

        Model model = new Model();
        Graphics graphics = new Graphics(model, canvas.getGraphicsContext2D());
        timer = new Timer(model, graphics);

        InputHandler inputHandler = new InputHandler(model);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                inputHandler.onKeyPressed(event);
                inputHandler.onQPressed(event);
            }
        });

        timer.start();

    }

    public void stop() throws Exception {
        timer.stop();
        super.stop();
    }

}
