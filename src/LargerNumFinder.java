import java.util.Scanner;

public class LargerNumFinder {

    public static double getLargerNum(double a, double b){
        return (a>=b)?a:b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        if(!sc.hasNextDouble()){
            System.out.println("Please enter a valid number! ");
            sc.close();
            return;
        }

        double num1 = sc.nextDouble();

        System.out.print("Enter the second number: ");
        if(!sc.hasNextDouble()){
            System.out.println("Please enter a valid number!");
            sc.close();
            return;
        }
        double num2 = sc.nextDouble();

        double largerNum = getLargerNum(num1,num2);
        System.out.println("The larger number is: "+largerNum);

        sc.close();
    }
}
