import java.text.DecimalFormat;
import java.util.Scanner;

public class GrossCalculator {

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
