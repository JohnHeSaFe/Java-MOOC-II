package ticTacToe;

public class GameBoard {
    public enum CellState {
        EMPTY,
        X,
        O
    }

    private CellState [][] board;
    private boolean isGameFinished;

    public GameBoard() {
        board = new CellState[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = CellState.EMPTY;
            }
        }
        isGameFinished = false;
    }

    public void setCell(int row, int column, CellState state) {
        board[row][column] = state;
        updateGame();
    }

    private void updateGame() {
        for (int i = 0; i < 3; i++) {
            if (isWinningLine(board[i][0], board[i][1], board[i][2])) {
                isGameFinished = true;
            }
            if (isWinningLine(board[0][i], board[1][i], board[2][i])) {
                isGameFinished = true;
            }
        }

        if (isWinningLine(board[0][0], board[1][1], board[2][2])) {
            isGameFinished = true;
        }
        if (isWinningLine(board[0][2], board[1][1], board[2][0])) {
            isGameFinished = true;
        }
    }

    private boolean isWinningLine(CellState a, CellState b, CellState c) {
        return a != CellState.EMPTY && a == b && b == c;
    }

    public boolean isGameFinished() {
        return isGameFinished;
    }
}
