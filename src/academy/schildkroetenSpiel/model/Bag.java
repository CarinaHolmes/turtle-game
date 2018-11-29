package academy.schildkroetenSpiel.model;

public class Bag {

    private double posX;
    private double posY;

    Bag(double posX, double posY) {
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
