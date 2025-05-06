
/*
* Write a program that finds the median of a sorted array of numbers, where the
median of an array is defined as the number exactly in the middle of the sorted array.
When the array contains an odd number of numbers, the median is the number
exactly in the middle and when the array contains an even number of numbers, the
median is the average of the two numbers exactly in the middle. The table below
shows some sorted arrays, their middle elements and their medians.

* */

import java.util.Scanner;

public class MedianFinder {

    /**
     * Returns the median of a sorted array.
     * If the array is empty, returns -1.0.
     *
     * @param numbers sorted array of doubles
     * @return median value or -1.0 if array is empty
     */
    public static double findMedian(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1.0;
        }

        int n = numbers.length;
        if (n % 2 == 1) {
            return numbers[n / 2]; // odd: return middle element
        } else {
            // even: average of two middle elements
            return (numbers[n / 2 - 1] + numbers[n / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the number of elements in the sorted array: ");
            int size = scanner.nextInt();

            if (size <= 0) {
                System.out.println("Median: -1.0");
                return;
            }

            double[] arr = new double[size];
            System.out.println("Enter the sorted elements one by one:");

            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextDouble();
            }

            double median = findMedian(arr);
            System.out.println("Median: " + median);

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numeric values only.");
        } finally {
            scanner.close();
        }
    }
}
