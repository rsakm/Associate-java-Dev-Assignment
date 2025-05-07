import java.util.Scanner;

public class TimeConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total number of seconds: ");
        while (!sc.hasNextLong()) {
            System.out.println("Invalid input. Please enter a valid number of seconds.");
            sc.next();
        }

        long totalSeconds = sc.nextLong();
        sc.close();

        long days = totalSeconds / (24 * 3600);
        long remainingAfterDays = totalSeconds % (24 * 3600);

        long hours = remainingAfterDays / 3600;
        long remainingAfterHours = remainingAfterDays % 3600;

        long minutes = remainingAfterHours / 60;
        long seconds = remainingAfterHours % 60;

        System.out.printf("%d Day(s) %d Hour(s) %d Minute(s) %d Second(s)%n", days, hours, minutes, seconds);
    }
}
