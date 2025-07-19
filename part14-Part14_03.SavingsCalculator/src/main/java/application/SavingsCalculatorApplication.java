package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Slider sliderMonthlySavings = new Slider(25, 250, 0);
        sliderMonthlySavings.setShowTickMarks(true);
        sliderMonthlySavings.setShowTickLabels(true);

        BorderPane layoutMonthlySavings = new BorderPane();
        layoutMonthlySavings.setLeft(new Label("Monthly savings"));
        layoutMonthlySavings.setCenter(sliderMonthlySavings);
        layoutMonthlySavings.setRight(new Label("25.0"));
        
        Slider sliderYearlyInterestRate = new Slider(0, 10, 0);
        sliderYearlyInterestRate.setShowTickMarks(true);
        sliderYearlyInterestRate.setShowTickLabels(true);
        sliderYearlyInterestRate.setMajorTickUnit(10);

        BorderPane layoutYearlyInterestRate = new BorderPane();
        layoutYearlyInterestRate.setLeft(new Label("Yearly interest rate"));
        layoutYearlyInterestRate.setCenter(sliderYearlyInterestRate);
        layoutYearlyInterestRate.setRight(new Label("0.0"));

        VBox layoutSliders = new VBox();
        layoutSliders.getChildren().addAll(layoutMonthlySavings, layoutYearlyInterestRate);

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, 110, 10);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings calculator");

        XYChart.Series chartMonthlySavings = new XYChart.Series();
        chartMonthlySavings.setName("MonthlySavings without interest rate");
        XYChart.Series chartYearlyInterestRate = new XYChart.Series();
        chartYearlyInterestRate.setName("MonthlySavings with interest rate");

        lineChart.getData().addAll(chartMonthlySavings, chartYearlyInterestRate);

        sliderMonthlySavings.valueProperty().addListener((obs, oldVal, newVal) -> {
            double monthlySavings = newVal.doubleValue();
            double yearlyInterestRate = sliderYearlyInterestRate.getValue() / 100;

            layoutMonthlySavings.setRight(new Label(String.format("%.2f", monthlySavings)));

            updateCharts(monthlySavings, yearlyInterestRate, chartMonthlySavings, chartYearlyInterestRate, xAxis, yAxis);
        });

        sliderYearlyInterestRate.valueProperty().addListener((obs, oldVal, newVal) -> {
            double monthlySavings = sliderMonthlySavings.getValue();
            double yearlyInterestRate = newVal.doubleValue() / 100;

            layoutYearlyInterestRate.setRight(new Label(String.format("%.2f", yearlyInterestRate * 100)));

            updateCharts(monthlySavings, yearlyInterestRate, chartMonthlySavings, chartYearlyInterestRate, xAxis, yAxis);
        });

        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(layoutSliders);
        mainLayout.setCenter(lineChart);

        primaryStage.setScene(new Scene(mainLayout));
        primaryStage.show();

        sliderMonthlySavings.setValue(26);  
        sliderMonthlySavings.setValue(25); 
        sliderYearlyInterestRate.setValue(1);
        sliderYearlyInterestRate.setValue(0);
    }

    public static void updateCharts(double monthlySavings,
        double yearlyInterestRate,
        XYChart.Series<Number, Number> chartMonthlySavings,
        XYChart.Series<Number, Number> chartYearlyInterestRate,
        NumberAxis xAxis,
        NumberAxis yAxis
    ) {
        chartMonthlySavings.getData().clear();
        chartYearlyInterestRate.getData().clear();

        double total = 0;
        int years = (int) xAxis.getUpperBound();
        double maxValue = 0;

        for (int year = 0; year <= years; year++) {
            chartMonthlySavings.getData().add(new XYChart.Data<>(year, monthlySavings * year * 12));

            if (year > 0) {
                total = (total + monthlySavings * 12) * (1 + yearlyInterestRate);
            }

            chartYearlyInterestRate.getData().add(new XYChart.Data<>(year, total));

            if (year == years) {
                maxValue = total;
            }
        }

        yAxis.setUpperBound(maxValue * 1.1);
        double yTickUnit = maxValue / 6;
        if (yTickUnit < 1) {
            yTickUnit = 1;
        }
        yAxis.setTickUnit(yTickUnit);
    }
}
