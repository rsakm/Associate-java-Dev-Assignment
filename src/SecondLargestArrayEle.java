import java.util.Scanner;
public class SecondLargestArrayEle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n;

        try {
            n = Integer.parseInt(sc.nextLine().trim());
            if (n < 2) {
                System.out.println("At least two elements are required.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers separated by space:");
        String[] inputs = sc.nextLine().split("\\s+");

        if (inputs.length != n) {
            System.out.println("Error: You must enter exactly " + n + " integers.");
            return;
        }

        try {
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. All values must be integers.");
            return;
        }

        Integer largest = null;
        Integer secondLargest = null;

        for (int num : arr) {
            if (largest == null || num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num != largest && (secondLargest == null || num > secondLargest)) {
                secondLargest = num;
            }
        }

        if (secondLargest == null) {
            System.out.println("There is no distinct second largest number.");
        } else {
            System.out.println("The second largest number is: " + secondLargest);
        }
    }
}


