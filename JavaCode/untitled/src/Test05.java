import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Test05 extends Application{
	private String text = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Label lable = new Label("hello,world!");
		Pane pane = new Pane();
		pane.getChildren().add(lable);
		new Thread(()-> {
				 while(true) {
					 if(lable.getText().trim().length()==0) {
						 text = "Welcome";
					 }else {
						 text = "";
					 }
					 Platform.runLater(()->lable.setText(text));// new Runnable
					 try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
				
			}
		).start();
		Scene scene = new Scene(pane, 200, 50);
		primaryStage.setTitle(text);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}

}

