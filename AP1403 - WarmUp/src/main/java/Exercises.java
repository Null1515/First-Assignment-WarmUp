import java.util.Arrays;

public class Exercises {

    /*
        complete this function to check if the input number is prime or not
     */
    public boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /*
        implement an algorithm to find out the index of input number in a fibonacci sequence starting from 0, 1
        e.g. 0, 1, 1, 2, 3, 5, ...
        indices start from 0, e.g. 3 is the index 4 of this sequence
        if the input is not a fibonacci number with description above, return -1
     */
    public long fibonacciIndex(long n) {
        if (n == 0) {
            return 0; // 0 index 0
        }
        if (n == 1) {
            return 1; // 1 index 1
        }

        long a = 0, b = 1;
        long index = 1;

        while (b <= n) {
            if (b == n) {
                return index;
            }
            long next = a + b;
            a = b;
            b = next;
            index++;
        }

        return -1; //BUG
    }

    /*
        you should create a triangle with "*" and return a two-dimensional array of characters based on that
        the triangle's area is empty, which means some characters should be " "

        example 1, input = 3:
        *
        **
        ***

        example 2, input = 5:
        *
        **
        * *
        *  *
        *****

        the output has to be a two-dimensional array of characters, so don't just print the triangle!
     */
    public char[][] generateTriangle(int n) {
        if (n <= 0) {
            return new char[0][0];
        }

        char[][] triangle = new char[n][];

        for (int i = 0; i < n; i++) {
            // create row
            triangle[i] = new char[i + 1];

            // every row 1 at start 1 at end
            triangle[i][0] = '*';
            triangle[i][i] = '*';

            // middle rows 1 at start 1 at end
            if (i > 1) {
                for (int j = 1; j < i; j++) {
                    triangle[i][j] = ' ';
                }
            }

            // Last row
            if (i == n - 1) {
                for (int j = 0; j <= i; j++) {
                    triangle[i][j] = '*';
                }
            }
        }

        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Exercises().generateTriangle(5)));
    }
}
