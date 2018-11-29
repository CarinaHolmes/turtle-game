package academy.schildkroetenSpiel.model;

public class Shark {

    /*
    This is the shark that eats turtles. It has a position on the screen that changes along the x axis, y axis always stays the same
     */

    private double posX;
    private double posY;

    Shark(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

}
