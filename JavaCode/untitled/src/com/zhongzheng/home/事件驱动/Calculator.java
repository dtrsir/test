package com.zhongzheng.home.ÊÂ¼þÇý¶¯;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {
	private TextField InvestmentAmount = new TextField();
	private TextField NumberOfYears = new TextField();
	private TextField AnrualInterestRate = new TextField();
	private TextField FutureValue = new TextField();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		GridPane  gridePane = new GridPane();
		gridePane.setHgap(5);
		gridePane.setVgap(5);
		
		
		gridePane.setAlignment(Pos.CENTER);
		gridePane.add(new Label("Investment Amount£º"), 0, 0);
		gridePane.add(new Label("Number of Years£º"), 0, 1);
		gridePane.add(new Label("Anrual Interest Rate£º"), 0, 2);
		gridePane.add(new Label("Future value£º"), 0, 3);
		
		gridePane.add(InvestmentAmount, 1, 0);
		gridePane.add(NumberOfYears, 1, 1);
		gridePane.add(AnrualInterestRate, 1, 2);
		gridePane.add(FutureValue, 1, 3);
		
		Button button = new Button("Caloulate");
		button.setOnAction(new Handler());
		
		
		gridePane.add(button, 1, 4);
		gridePane.setHalignment(button, HPos.RIGHT);
		Scene scene = new Scene(gridePane, 400, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle(STYLESHEET_CASPIAN);
		primaryStage.show();
		
	}

	
	public void calculateLoanPayment() {
		double interest = Double.parseDouble(InvestmentAmount.getText());
		int year = Integer.parseInt(NumberOfYears.getText());
		double loanAmount = Double.parseDouble(AnrualInterestRate.getText());
		double value = interest * Math.pow((1 + loanAmount * 0.01 / 12), year * 12);
		FutureValue.setText(String.format("$%.2f", value));
	}
	class Handler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			calculateLoanPayment();
		}
	}
	
	
	public static void main(String[] args) {
		launch();
	}
}
