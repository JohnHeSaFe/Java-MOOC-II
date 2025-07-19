package application;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Map<String, Map<Integer, Double>> partiesData = getPartiesData();

        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        xAxis.setLabel("Year");
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        yAxis.setLabel("Relative support (%)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        partiesData.keySet().stream().forEach(party -> {
            XYChart.Series partyData = new XYChart.Series();
            partyData.setName(party);

            partiesData.get(party).entrySet().stream().forEach(data -> {
                partyData.getData().add(new XYChart.Data<>(data.getKey(), data.getValue()));
            });

            lineChart.getData().add(partyData);
        });

        primaryStage.setScene(new Scene(lineChart));
        primaryStage.show();
    }

    public static Map<String, Map<Integer, Double>> getPartiesData() throws IOException {
        
        try (Scanner scanner = new Scanner(Paths.get("partiesdata.tsv"))) {
            List<Integer> years = new ArrayList<>();
            String [] rowValues = scanner.nextLine().split("\t");
            if (rowValues[0].equals("Party")) {
                for (int i = 1; i < rowValues.length; i++) {
                    years.add(Integer.valueOf(rowValues[i]));
                }
            } 

            Map<String, Map<Integer, Double>> partiesData = new HashMap<>();
            
            while (scanner.hasNextLine()) {
                rowValues = scanner.nextLine().split("\t");
                String partyName = rowValues[0];

                Map<Integer, Double> percentages = new HashMap<>();
                for (int i = 1; i < rowValues.length; i++) {
                    if (!rowValues[i].equals("-")) {
                        percentages.put(years.get(i - 1), Double.valueOf(rowValues[i]));
                    }
                }

                partiesData.put(partyName, percentages);
            }

            return partiesData;
        } catch (IOException e) {
            throw new IOException("Cannot read file");
        }
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }
}
