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

public class ControlCircle extends Application {
    private CirclePane circlePane = new CirclePane();

    @Override
    public void start(Stage primaryStage){
        HBox HBox = new HBox();
        HBox.setSpacing(10);
        HBox.setAlignment(Pos.CENTER);
        Button big = new Button("放大");
        Button reduce = new Button("缩小");
        HBox.getChildren().addAll(big,reduce);

        big.setOnAction(new EnlargeHandler());
        reduce.setOnAction(new ReduceHandler());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(HBox);
        BorderPane.setAlignment(HBox,Pos.CENTER);

        Scene scene = new Scene(borderPane,200,150);
        primaryStage.setTitle("handler");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    class EnlargeHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            circlePane.enlarge();
        }
    }

    class ReduceHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            circlePane.shrink();
        }
    }
}



class CirclePane extends StackPane{
    private Circle circle = new Circle(50);
    public CirclePane(){
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
    }

    public void enlarge(){
        circle.setRadius(circle.getRadius() + 2);
    }

    public void shrink(){
        circle.setRadius(circle.getRadius() > 2? circle.getRadius() -2 : circle.getRadius());
    }

}

