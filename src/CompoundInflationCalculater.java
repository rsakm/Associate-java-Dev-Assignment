import java.text.DecimalFormat;
import java.util.Scanner;
public class CompoundInflationCalculater {

    /**
     * Calculates compounded inflation using the formula:
     * (1 + r)^n - 1
     * where r = inflation rate in decimal, n = number of years
     *
     * @param rate  annual inflation rate (in percent)
     * @param years number of years
     * @return compounded inflation (in percent)
     */
    public static double calculateCompoundedInflation(double rate, int years) {
        double inflationRateDecimal = rate / 100.0;
        double compounded = Math.pow(1 + inflationRateDecimal, years) - 1;
        return compounded * 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the yearly retail inflation rate (in %): ");
            double rate = Double.parseDouble(sc.nextLine().trim());

            if (rate < 0) {
                System.out.println("Inflation rate cannot be negative.");
                return;
            }

            System.out.print("Enter the number of years: ");
            int years = Integer.parseInt(sc.nextLine().trim());

            if (years <= 0) {
                System.out.println("Number of years must be greater than zero.");
                return;
            }

            double compoundedInflation = calculateCompoundedInflation(rate, years);

            DecimalFormat df = new DecimalFormat("#.##");

            System.out.printf("Compounded retail inflation after %d years is: %d%%%n", years, Math.round(compoundedInflation));

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values.");
        } finally {
            sc.close();
        }
    }
}
