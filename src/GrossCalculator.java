
/**
 * Problem 2:
 * A supermarket sells thousands of products. Every product is properly packaged and
 * the product packaging shows the total price a customer must pay for the product.
 * The total product price includes taxes and the rate of taxation varies from product to
 * product. For legal reasons, the supermarket must provide invoices to every customer
 * that show the price of each product before taxes, the tax rate and the tax amount.
 * Write a program that takes the net price of a product including taxes and the tax rate,
 * and computes the gross price before taxes. The table below shows some examples
 * for the expected output of the program.
 *
 * | Net Price  |  Tax Rate   |   Gross Price |
 * | 99.95      |   0.12      |     89.24     |
 * | 49,999.00  |   0.28      |    39,061.72  |
 * | 720.00     |   0.05      |    685.71     |
 * | 45.00      |   0.00      |    45.00      |
 *
 */


import java.text.DecimalFormat;
import java.util.Scanner;

public class GrossCalculator {


    /**
     * Returns the gross price based on the given net price and tax rate.
     * Negative value(s) of net price or tax rate gives invalid input error as they can't be negative.
     *
     * @param netPrice the input net price
     * @param taxRate  the input tax rate
     * @return the calculated gross price
     */

    public static double calculateGross(double netPrice, double taxRate){
        return  netPrice / (1+taxRate);
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#, ##0.00");

        System.out.print("Enter net Price: ");

//        Input validation
        if(!s.hasNextDouble()){
            System.out.println("Invalid Input");
            s.close();
            return;
        }

        double netPrice = s.nextDouble();

        System.out.print("Enter tax rate (e.g., 0.12 for 12%): ");
        if (!s.hasNextDouble()) {
            System.out.println("Invalid tax rate input.");
            s.close();
            return;
        }

        double taxRate = s.nextDouble();

        if(netPrice < 0 || taxRate < 0){
            System.out.println("Can't accept negative value(s): ");
        }else{
            double grossvalue = calculateGross(netPrice, taxRate);
            System.out.println("Gross price: "+df.format(grossvalue));
        }

        s.close();
    }
}
