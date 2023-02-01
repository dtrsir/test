package com.zhongzheng.ball;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MultipleBouncePane extends Application {


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MultipleBallPane ballPane = new MultipleBallPane();
		ballPane.setStyle("-fx-border-color: yellow");
		
		Button bt1 = new Button("+");
		Button bt2 = new Button("-");
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(bt1, bt2);
		hBox.setAlignment(Pos.CENTER);
		
		
		bt1.setOnAction(e -> ballPane.add());
		bt1.setOnAction(e -> ballPane.sub());
		
		ballPane.setOnMousePressed(e -> ballPane.pause());
		ballPane.setOnMouseReleased(e -> ballPane.play());
		
		ScrollBar sbSpeed = new ScrollBar();
		sbSpeed.setMax(20);
		sbSpeed.setValue(10);
		ballPane.rateProperty().bind(sbSpeed.valueProperty());
		
		BorderPane pane = new BorderPane();
		pane.setCenter(ballPane);
		pane.setTop(sbSpeed);
		pane.setBottom(hBox);
		
		Scene scene = new Scene(pane, 250, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("sasas");
		primaryStage.show();
		
	}
	
	private class MultipleBallPane extends Pane{
		private Timeline animation;
		
		public MultipleBallPane() {
			animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();
		}
		
		public void add() {
			Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
			getChildren().add(new Ball(30, 30, 20, color));
		}
		
		public void sub() {
			if(getChildren().size() > 0) {
				getChildren().remove(getChildren().size() - 1);
			}
		}
		public void play() {
			animation.play();
		}
		
		public void pause() {
			animation.pause();
		}
		
		public void increaseSpeed() {
			animation.setRate(animation.getRate() + 0.1);
		}
		
		public void decreaseSpeed() {
			animation.setRate(animation.getRate() > 0? animation.getRate() - 0.1 : 0);
		}
		public DoubleProperty rateProperty() {
			return animation.rateProperty();
		}
		
		protected void moveBall() {
			for(Node node : this.getChildren()) {
				Ball ball = (Ball)node;
				if(ball.getCenterX() < ball.getRadius() || ball.getCenterX() > getWidth() - ball.getRadius()) {
					ball.dx *= -1;
				}
				if(ball.getCenterY() < ball.getRadius() || ball.getCenterY() > getHeight() - ball.getCenterY()) {
					ball.dy *= -1;
				}
				
				ball.setCenterY(ball.dy + ball.getCenterY());
				ball.setCenterX(ball.dx + ball.getCenterX());
				
			}	
		}
	}
	public static void main(String[] args) {
		launch();
	}
}


