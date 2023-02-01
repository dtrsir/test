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

public class LoanCalculator extends Application {
	private TextField AnnualInterestRate = new TextField();
	private TextField NumberOfYears = new TextField();
	private TextField LoanAmount = new TextField();
	private TextField MonthlyPayment = new TextField();
	private TextField TotalPayment = new TextField();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		GridPane  gridePane = new GridPane();
		gridePane.setHgap(5);
		gridePane.setVgap(5);
		
		
		gridePane.setAlignment(Pos.CENTER);
		gridePane.add(new Label("Annual Interest Rate£º"), 0, 0);
		gridePane.add(new Label("Number of Years£º"), 0, 1);
		gridePane.add(new Label("Loan Amount£º"), 0, 2);
		gridePane.add(new Label("Monthly Payment£º"), 0, 3);
		gridePane.add(new Label("Total Payment£º"), 0, 4);
		
		gridePane.add(AnnualInterestRate, 1, 0);
		gridePane.add(NumberOfYears, 1, 1);
		gridePane.add(LoanAmount, 1, 2);
		gridePane.add(MonthlyPayment, 1, 3);
		gridePane.add(TotalPayment, 1, 4);
		
		Button button = new Button("Caloulate");
		button.setOnAction(new Handler());
		
		
		gridePane.add(button, 1, 5);
		gridePane.setHalignment(button, HPos.RIGHT);
		Scene scene = new Scene(gridePane, 400, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle(STYLESHEET_CASPIAN);
		primaryStage.show();
		
	}

	
	public void calculateLoanPayment() {
		double rate = Double.parseDouble(AnnualInterestRate.getText()) * 0.01;
		int year = Integer.parseInt(NumberOfYears.getText());
		double loanAmount = Double.parseDouble(LoanAmount.getText());
		double monthlyValue = loanAmount * (rate / 12) / (1 - (1 / Math.pow(1 + rate / 12, year * 12)));
		double TotalValue = monthlyValue * year * 12 ;
		MonthlyPayment.setText(String.format("$%.2f", monthlyValue));
		TotalPayment.setText(String.format("$%.2f", TotalValue));
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
