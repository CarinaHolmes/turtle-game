package academy.schildkroetenSpiel.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Model {

    /*
    The Model class is where the magic happens: we define which elements perform what actions at what time
     */

    /*
    set counters for creating individual elements
     */
    private int counter = 0;
    private long jellyfishCounter = 0;
    private long sharkCounter = 0;
    private long bagCounter = 0;

    /*
    update method uses deltaMillis from Timer to trigger regular events, such as creating new elements or moving elements on screen
     */

    public void update(long deltaMillis) {
        counter += deltaMillis / 1000;
        if (!(turty.isDead() || turty.getLives() <= 0)) {
            moveTurtleDown();// for every update call method that moves turtle down
        }

        double randomY = ThreadLocalRandom.current().nextDouble(10, 260);
        newJellyfishList(1200, randomY, deltaMillis);
        if (!(turty.isDead() || turty.getLives() <= 0)) {
            moveJellyfish();
        }

        double randomSharkY = ThreadLocalRandom.current().nextDouble(10, 220);
        newSharkList(1200, randomSharkY, deltaMillis);
        if (!(turty.isDead() || turty.getLives() <= 0)) {
            moveShark();
        }
        collisionJellyfish();
        collisionShark();

        double randomBagY = ThreadLocalRandom.current().nextDouble(10, 260);
        newBagList(1200, randomBagY, deltaMillis);
        if (!(turty.isDead() || turty.getLives() <= 0)) {
            moveBag();
        }
        collisionBag();
    }

    /*
    Turtles
     */
    private Turtle turty = new Turtle(0, 150);

    public Turtle getTurty() {
        return turty;
    }

    /*
    Jellyfish-List
     */
    private List<Jellyfish> jellyfishList = new LinkedList<>();

    private void newJellyfishList(double posX, double posY, long deltaMillis) {
        this.jellyfishCounter += deltaMillis;
        if (this.jellyfishCounter >= 4000) {
            jellyfishList.add(new Jellyfish (posX, posY));
            this.jellyfishCounter = 0;
        }
    }

    public List<Jellyfish> getJellyfishist() {
        return jellyfishList;
    }


    /*
    Hai-Liste
     */

    private List<Shark> sharkList = new LinkedList<>();

    private void newSharkList(double posX, double posY, long deltaMillis) {
        this.sharkCounter += deltaMillis;
        if (this.sharkCounter >= 7500) {
            sharkList.add(new Shark(posX, posY));
            this.sharkCounter = 0;
        }
    }

    public List<Shark> getSharkList() {
        return sharkList;
    }

    /*
    Tueten-Liste
     */

    private List<Bag> baglist = new LinkedList<>();

    private void newBagList(double posX, double posY, long deltaMillis) {
        this.bagCounter += deltaMillis;
        if (this.bagCounter >= 4000) {
            baglist.add(new Bag(posX, posY));
            this.bagCounter = 0;
        }
    }

    public List<Bag> getBaglist() {
        return baglist;
    }

    /*
    Methoden zur Bewegung der Elemente
     */

    public void moveTurtleUp() {
        /*
        ich hole mir die alte Position, verringere sie um 10 und weise sie wieder zu.
         */
        if ((turty.getPosY() > 0 && turty.getPosY() < 250)) { // Damit die Schildkroete nicht über die Scene hinaus läuft
            double neuePosition = turty.getPosY();
            neuePosition -= 10;
            turty.setPosY(neuePosition);
        }
    }

    private void moveTurtleDown() {
        if ((turty.getPosY() > -10 && turty.getPosY() < 240)) {
            double neuePosition = turty.getPosY();
            neuePosition += 1;
            turty.setPosY(neuePosition);
        }
    }

    private void moveJellyfish() {
        for (Jellyfish jellyfish : jellyfishList) {
            /*
            mit Schleife iterieren wir über das Array an Jellyfish
             */
            if (jellyfish.getPosX() >= -50) {
                double neuePosition = jellyfish.getPosX();
                neuePosition -= 0.75;
                jellyfish.setPosX(neuePosition);
            }
        }
    }


    private void moveShark() {
        for (Shark shark : sharkList) {
            if (shark.getPosX() >= -100) {
                double neuePosition = shark.getPosX();
                neuePosition -= 1;
                shark.setPosX(neuePosition);
            }
        }
    }

    private void moveBag() {
        for (Bag tuete : baglist) {
            if (tuete.getPosX() >= -50) {
                double neuePosition = tuete.getPosX();
                neuePosition -= 0.5;
                tuete.setPosX(neuePosition);
            }
        }
    }

    /*
    Methoden zur Kollision der Elemente
     */

    private void collisionJellyfish() {
        for (Iterator<Jellyfish> iterator = jellyfishList.iterator(); iterator.hasNext(); ) {
            Jellyfish jellyfish = iterator.next();
            if (turty.getPosY() - 10 <= jellyfish.getPosY()
                    && jellyfish.getPosY() <= turty.getPosY() + 30
                    && turty.getPosX() + 45 >= jellyfish.getPosX()
                    && turty.getPosX() + 25 <= jellyfish.getPosX()) {
                iterator.remove();
                int score = turty.getPoints();
                turty.setPoints(score += 50);
            }
        }
    }

    private void collisionShark() {
        for (Iterator<Shark> iterator = sharkList.iterator(); iterator.hasNext(); ) {
            Shark shark = iterator.next();
            if (turty.getPosY() - 20 <= shark.getPosY()
                    && shark.getPosY() <= turty.getPosY() + 40
                    && turty.getPosX() + 55 >= shark.getPosX()
                    && turty.getPosX() + 35 <= shark.getPosX()) {
                iterator.remove();
                int score = turty.getPoints();
                turty.setPoints(score -= 150);
                if (score <= 0) {
                    turty.setDead(true);
                }
            }
        }
    }

    private void collisionBag() {
        for (Iterator<Bag> iterator = baglist.iterator(); iterator.hasNext(); ) {
            Bag bag = iterator.next();
            if (turty.getPosY() - 10 <= bag.getPosY()
                    && bag.getPosY() <= turty.getPosY() + 35
                    && turty.getPosX() + 45 >= bag.getPosX()
                    && turty.getPosX() + 25 <= bag.getPosX()) {
                iterator.remove();
                int lives = turty.getLives();
                turty.setLives(lives -= 1);
            }
        }
    }
}
