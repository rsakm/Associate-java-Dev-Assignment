/**
 * Problem 1:
 * Write a program that prints the number of digits in an integer.
 * For example, given the integer “34” (without quotes) as the input,
 * the program must print “2” (without quotes) as the output,
 * given “-7291” (without quotes), the program must print “4” (without quotes), and so on.
 */

import java.util.Scanner;

public class CountDigits {

    /**
     * Returns the number of digits in the given integer.
     * Negative sign is ignored. Zero is considered a 1-digit number.
     *
     * @param num the input integer
     * @return number of digits
     */
    public static int getDigitCount(int num) {
        num = Math.abs(num); // Ignore negative sign
        if (num == 0) return 1;

        int count = 0;
        while (num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an integer: ");

        if (s.hasNextInt()) {    //// Input validation to avoid crashing the program with an exception
            int input = s.nextInt();
            System.out.println(getDigitCount(input));
        } else {
            System.out.println("Invalid input. Please enter a valid integer.");
        }

        s.close();
    }
}
