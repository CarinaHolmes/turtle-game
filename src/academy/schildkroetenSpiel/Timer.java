package academy.schildkroetenSpiel;

import academy.schildkroetenSpiel.model.Model;
import javafx.animation.AnimationTimer;

public class Timer extends AnimationTimer {

    private Model model;
    private Graphics graphics;
    private long lastMillis = -1;

    Timer(Model model, Graphics graphics) {
        this.model = model;
        this.graphics = graphics;
    }

    /*
    we overwrite the default handler of the timer so that we can use it for our pusposes. Normal AnimationTimer counts in nanoseconds
    we want milliseconds, which is more manageable for us. We also use the method to calculate the passed time from start point of the
    game to now (deltaMillis)
     */

    public void handle(long now) {
        long millis = now / 1_000_000;  // da Zeit in Nanosekunden gerechnet wird, rechnen wir es mit /1000000 in Millisekunden um, denn nanos brauchen wir nicht
        long deltaMillis = 0;
        if (lastMillis != -1) {
            deltaMillis = millis - lastMillis;
        }
        this.model.update(deltaMillis);

        lastMillis = millis;

        graphics.draw();

    }
}
