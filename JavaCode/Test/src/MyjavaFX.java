import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyjavaFX extends Application {
    @Override
    public void start(Stage primaryStage){
        Button btOK = new Button("提醒学习小助手提醒你，今天你学习了吗?");
        Scene scene = new Scene(btOK, 200, 250);
        primaryStage.setTitle("MyJavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}