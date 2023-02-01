import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Event extends Application {
    @Override
    public void start(Stage primaryStage){

        StackPane pane = new StackPane();
        Circle circle = new Circle(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);

        HBox HBox = new HBox();
        HBox.setSpacing(10);
        HBox.setAlignment(Pos.CENTER);
        Button big = new Button("放大");
        Button reduce = new Button("缩小");
        HBox.getChildren().addAll(big,reduce);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(HBox);



        Scene scene = new Scene(borderPane,200,150);
        primaryStage.setTitle("handler");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
