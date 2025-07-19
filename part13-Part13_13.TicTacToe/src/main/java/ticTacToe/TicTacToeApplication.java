package ticTacToe;

import java.beans.EventHandler;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ticTacToe.GameBoard.CellState;

public class TicTacToeApplication extends Application{
    private static boolean isXTurn;
    private static Label text;
    private static GameBoard gameBoard;

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        isXTurn = true;
        text = new Label("Turn: X");
        gameBoard = new GameBoard();


        Button [][] cells = new Button[3][3];
        GridPane cellsLayout = new GridPane();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = getCellButton(i, j);
                cellsLayout.add(cells[i][j], i, j);
            }
        } 

        BorderPane layout = new BorderPane();
        layout.setTop(text);
        layout.setCenter(cellsLayout);

        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }

    public static Button getCellButton(int i, int j) {
        Button btn = new Button(" ");
        btn.setFont(Font.font("Monospaced", 40));

        btn.setOnMouseClicked((event) -> {
            if (!btn.getText().isBlank() || gameBoard.isGameFinished()) {
                return;
            }

            if (isXTurn) {
                btn.setText("X");
                gameBoard.setCell(i, j, CellState.X);
                text.setText("Turn: O");
                isXTurn = false;
            } else {
                btn.setText("O");
                gameBoard.setCell(i, j, CellState.O);
                text.setText("Turn: X");
                isXTurn = true;
            }

            if (gameBoard.isGameFinished()) {
                text.setText("The end!");
            }
        });

        return btn;
    }

}
