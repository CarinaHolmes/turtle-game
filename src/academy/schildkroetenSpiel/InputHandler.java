package academy.schildkroetenSpiel;

import academy.schildkroetenSpiel.model.Model;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InputHandler {

    /*
    Input Handler handles all input from user, e.g. a pressed key or pressed mouse. At the moment we are only detecting
    pressed space bar and use it to move the turtle.
     */

    private Model model;

    InputHandler(Model model) {
        this.model = model;
    }

    /*
    onKeyPressed handles what happens if space bar is pressed. If space is pressed turtle moves up through moveTurtleUp method
    this happens only if turtle is not dead and her lives are not <= 0
     */

    void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            if (!(model.getTurty().isDead() || model.getTurty().getLives() <= 0)) {
                this.model.moveTurtleUp(); //turtle only moves up if her lives are not <= 0 and she is not dead
            }
        }
    }

    void onQPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.Q) {
            //TODO: Hier soll der Welcome pane aufgerufen werden, wenn man Q drückt
        }
    }
}
