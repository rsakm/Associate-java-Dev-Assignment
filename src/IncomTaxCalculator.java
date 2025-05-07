import java.text.DecimalFormat;
import java.util.Scanner;

public class IncomTaxCalculator {

    // Constants for tax slabs(As per tha table given in the table)
    private static final double SLAB1 = 250000;
    private static final double SLAB2 = 500000;
    private static final double SLAB3 = 1000000;

    /**
     * Calculates income tax based on the given Indian tax slabs.
     * @param income taxable income
     * @return total income tax
     */
    public static double calculateTax(double income) {
        if (income <= SLAB1) {
            return 0.0;
        }

        double tax = 0.0;

        if (income > SLAB3) {
            tax += 0.10 * (SLAB2 - SLAB1);               // 10% on 2.5L to 5L
            tax += 0.20 * (SLAB3 - SLAB2);               // 20% on 5L to 10L
            tax += 0.30 * (income - SLAB3);              // 30% on above 10L
        } else if (income > SLAB2) {
            tax += 0.10 * (SLAB2 - SLAB1);               // 10% on 2.5L to 5L
            tax += 0.20 * (income - SLAB2);              // 20% on above 5L
        } else {
            tax += 0.10 * (income - SLAB1);              // 10% on above 2.5L
        }

        return tax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#,##0.00");

        try {
            System.out.print("Enter your taxable income (you may use commas): ");
            String incomeInput = scanner.nextLine().replace(",", "");
            double income = Double.parseDouble(incomeInput);

            if (income < 0) {
                System.out.println("Income cannot be negative.");
            } else {
                double tax = calculateTax(income);
                System.out.println("Income Tax: ₹" + formatter.format(tax));
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
