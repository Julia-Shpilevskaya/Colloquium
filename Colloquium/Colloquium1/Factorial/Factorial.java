import java.util.ArrayList;

public class Factorial {
    public static ArrayList<int> getFactorialRow(int upperBorder) {
        ArrayList<int> factorialContainer = new ArrayList<int>();

        if (upperBorder < 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 1; i <= upperBorder; i++) {
            factorialContainer.add(getFactorial(i));
        }

        return factorialContainer;
    }

    private static int getFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * getFactorial(n - 1);
    }
}