package academy.schildkroetenSpiel.model;

public class Turtle {
    private int points;
    private double PosX;
    private double posY;
    private boolean dead;
    private int lives = 3;

    Turtle(double PosX, double posY) {
        this.PosX = PosX;
        this.posY = posY;
    }

    public double getPosX() {
        return PosX;
    }

    public double getPosY() {
        return posY;
    }

    void setPosY(double posY) {
        this.posY = posY;
    }

    public int getPoints() {
        return points;
    }

    void setPoints(int points) {
        this.points = points;
    }

    public boolean isDead() {
        return dead;
    }

    void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getLives() {
        return lives;
    }

    void setLives(int lives) {
        this.lives = lives;
    }
}
