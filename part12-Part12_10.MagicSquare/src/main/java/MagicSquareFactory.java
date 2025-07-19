import java.util.Arrays;

public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int [] currentPosition = {square.getWidth() / 2, 0};
        int [] nextPosition = new int[2];
        for (int i = 1; i <= square.getWidth() * square.getHeight(); i++) {
            square.placeValue(currentPosition[0], currentPosition[1], i);
            nextPosition = Arrays.copyOf(currentPosition, currentPosition.length);
            if (currentPosition[0] == square.getWidth() - 1) {
                nextPosition[0] = 0;
            } else {
                nextPosition[0]++;
            }
            if (currentPosition[1] == 0) {
                nextPosition[1] = square.getHeight() - 1;
            } else {
                nextPosition[1]--;
            }
            if (square.readValue(nextPosition[0], nextPosition[1]) > 0) {
                currentPosition[1]++;
            } else {
                currentPosition = Arrays.copyOf(nextPosition, nextPosition.length);
            }
        }

        return square;
    }

}
