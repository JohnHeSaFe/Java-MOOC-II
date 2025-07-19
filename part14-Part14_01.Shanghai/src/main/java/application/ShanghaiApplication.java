package application;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        NumberAxis xAxis = new NumberAxis(2007, 2017, 1); 
        NumberAxis yAxis = new NumberAxis(0, 100, 5);     
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        Map<Integer, Integer> values = new HashMap<>();
        values.put(2007, 73);
        values.put(2008, 68);
        values.put(2009, 72);
        values.put(2010, 72);
        values.put(2011, 74);
        values.put(2012, 73);
        values.put(2013, 76);
        values.put(2014, 73);
        values.put(2015, 67);
        values.put(2016, 56);
        values.put(2017, 56);

        XYChart.Series rankingData = new XYChart.Series();
        rankingData.setName("Ranking");

        values.entrySet().stream().forEach(pair -> {
            rankingData.getData().add(new XYChart.Data<>(pair.getKey(), pair.getValue()));
        });

        lineChart.getData().add(rankingData);

        Scene view = new Scene(lineChart, 640, 480);
        primaryStage.setScene(view);
        primaryStage.show();
    }

}
