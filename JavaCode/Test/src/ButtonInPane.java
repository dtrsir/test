import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ButtonInPane extends Application {
    @Override
    public void start(Stage primaryStage){
        StackPane stackPane = new StackPane();
        Button button = new Button("OK");
        Button button1 = new Button("NO");
        button1.setStyle("-fx-border-color: blue;-fx-text-fill: red");
        button1.setTranslateY(40);
        button.setTranslateX(-40);
        button1.setTranslateX(40);
        stackPane.getChildren().add(button1);
        button.setStyle("-fx-border-color: blue;-fx-text-fill: red");
        stackPane.getChildren().add(button);
//        stackPane.setRotate(45);
        stackPane.setStyle("-fx-border-color: red;-fx-background-color: lightgray");
        button.setTranslateY(40);
        Scene scene = new Scene(stackPane, 500, 500);
        Font sansSerif = new Font("SansSerif", 16);
        Label javaFX = new Label("今天你学习了吗？");
        javaFX.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC,20));
        stackPane.getChildren().add(javaFX);
        primaryStage.setScene(scene);
        primaryStage.setTitle("123");
        primaryStage.show();

    }
}
