package academy.schildkroetenSpiel;

import academy.schildkroetenSpiel.model.*;
import academy.schildkroetenSpiel.model.Turtle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Graphics {


    private Model model;
    private GraphicsContext gc;

    Graphics(Model model, GraphicsContext gc) {
        this.model = model;
        this.gc = gc;
    }

    private Image plasticbag = new Image("plasticbag.png");


    void draw() {

        /*
        Setting background of ocean and sand on the bottom
         */
        gc.setFill(Color.BLUE);
        gc.fillRect(0, 0, 1200, 300);
        gc.setFill(Color.BLUEVIOLET);
        gc.fillRect(0, 290, 1200, 10);
        /*
        Defining screen when turtle died of loss of points (she was eaten by too many sharks)
         */
        if (model.getTurty().isDead()) {
            gc.setFill(Color.RED);
            gc.fillRect(10, 10, 1180, 280);
            gc.setFill(Color.BLACK);
            gc.setFont(new Font("Sans Serif", 30));
            gc.fillText("Du bist tot! ", 500, 100);
            gc.setFont(new Font("Sans Serif", 15));
            gc.fillText("Deine Punktanzahl: " + model.getTurty().getPoints(), 500, 130);
            gc.fillText("Deine Leben: " + model.getTurty().getLives(), 500, 145);

            /*
            Defining shat to show when turtle has 0 or less lives (she ate too many plastic bags)
             */
        } else if (model.getTurty().getLives() <= 0) {
            gc.setFill(Color.RED);
            gc.fillRect(10, 10, 1180, 280);
            gc.setFill(Color.WHITE);
            gc.setFont(new Font("Sans Serif", 30));
            gc.fillText("Du hast zu viele Tüten gefressen! ", 350, 30);
            gc.setFont(new Font("Sans Serif", 15));
            gc.setFill(Color.BLACK);
            gc.fillText("Deine Punktanzahl: " + model.getTurty().getPoints(), 350, 60);
            gc.fillText("Deine Leben: " + model.getTurty().getLives(), 350, 75);

        } else {
            Turtle schildi = model.getTurty();
            gc.setFill(Color.GREEN);
            gc.fillRect(20, schildi.getPosY(), 60, 60);

            for (Jellyfish jellyfishi : model.getJellyfishist()) {
                gc.setFill(Color.WHITE);
                gc.fillRect(jellyfishi.getPosX(), jellyfishi.getPosY(), 40, 50);
            }

            for (Bag bag : model.getBaglist()) {
                gc.drawImage(plasticbag, bag.getPosX(), bag.getPosY(), 40, 50);
            }

            gc.setFill(Color.GREY);
            for (Shark sharki : model.getSharkList()) {
                gc.fillRect(sharki.getPosX(), sharki.getPosY(), 100, 80);
            }

            gc.setFill(Color.BLACK);
            gc.fillText("Punkte " + schildi.getPoints(), 10, 10);
            gc.fillText("Leben " + schildi.getLives(), 10, 20);
        }
    }
}
