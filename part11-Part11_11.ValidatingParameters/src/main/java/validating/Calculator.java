package validating;

public class Calculator {

    public int factorial(int num) throws IllegalArgumentException {
        if (num < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }

        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }

        return answer;
    }

    public int binomialCoefficent(int setSize, int subsetSize) throws IllegalArgumentException {
        if (setSize < 0 || subsetSize < 0) {
            throw new IllegalArgumentException("Numbers cannot be negative");
        }
        if (subsetSize > setSize) {
            throw new IllegalArgumentException("Subset size cannot exceed set size");
        }

        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        return numerator / denominator;
    }
}
