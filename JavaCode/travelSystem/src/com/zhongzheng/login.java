package com.zhongzheng;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class login extends Application {
	public static void main(String[] args) {
		launch(login.class);
	}
	
	@Override
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.add(new Label("”√ªß√˚£∫"), 0, 0);
		pane.add(new Label("√‹¬Î£∫"), 0, 1);
		pane.add(new TextArea(), 1, 0);
		pane.add(new PasswordField(), 1, 2);
		Button bt = new Button("login");
		pane.add(bt, 1, 3);
		pane.setHalignment(bt, HPos.LEFT);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("login");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
