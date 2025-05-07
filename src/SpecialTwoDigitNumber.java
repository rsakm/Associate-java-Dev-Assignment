import java.util.Scanner;

public class SpecialTwoDigitNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a two-digit integer: ");

        String input = scanner.nextLine().replace(",", "").trim();

        try {
            int number = Integer.parseInt(input);

            if (number < 10 || number > 99) {
                System.out.println("Error: Please enter a valid two-digit number.");
                return;
            }

            int tens = number / 10;
            int units = number % 10;

            int sum = tens + units + (tens * units);

            if (sum == number) {
                System.out.println(number + " is a special two-digit integer.");
            } else {
                System.out.println(number + " is NOT a special two-digit integer.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric two-digit integer.");
        }
    }
}
