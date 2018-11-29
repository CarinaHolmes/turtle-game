package academy.schildkroetenSpiel.model;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameMenu {

    /*
    setWelcomePane method defines how the menu should look, which elements it has and what should happen if you click on the
    start Button
     */

    //TODO: Maybe move creation of pane and the items in the pane into different methods

    public void setWelcomePane(Stage primaryStage, Scene scene) {
        Pane pane = new Pane();
        Scene welcome = new Scene(pane);
        pane.setPrefSize(800, 200); //set size of menu pane
        Button start = new Button("Start Spiel"); //when instantiating the javaFX-Button we can pass the button text as an argument
        start.setTranslateX(600); //moves the button along X axis (to the right)
        start.setTranslateY(100);
        pane.getChildren().add(start); //adding start Button to my pane
        start.setOnAction(event -> primaryStage.setScene(scene)); //when clicking on start button the scene will be changed

        /*
        adding any other buttons or items that we might need
         */
        Button exit = new Button("Weg hier");
        exit.setTranslateX(400);
        exit.setTranslateY(100);
        pane.getChildren().add(exit);
        exit.setOnAction(event -> primaryStage.close()); //window (primaryStage) closes on click on exit button

        primaryStage.setScene(welcome); //this puts the whole stage together by adding the welcome scene
    }

}
