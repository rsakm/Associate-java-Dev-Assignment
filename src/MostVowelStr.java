import java.util.Scanner;

public class MostVowelStr {
    /**
     * Counts the number of vowels in a given string.
     *
     * @param str input string
     * @return number of vowels
     */
    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char ch : str.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    /**
     * Finds the string with the most vowels in the array.
     *
     * @param strings array of strings
     * @return string with the highest number of vowels
     */
    public static String getMaxVowelString(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        String maxVowelStr = strings[0];
        int maxVowels = countVowels(strings[0]);

        for (int i = 1; i < strings.length; i++) {
            int currentVowels = countVowels(strings[i]);
            if (currentVowels > maxVowels) {
                maxVowels = currentVowels;
                maxVowelStr = strings[i];
            }
        }

        return maxVowelStr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the number of strings: ");
            int n = Integer.parseInt(sc.nextLine().trim());

            if (n <= 0) {
                System.out.println("Array must contain at least one string.");
                sc.close();
                return;
            }

            String[] words = new String[n];
            System.out.println("Enter the strings one by one:");

            for (int i = 0; i < n; i++) {
                words[i] = sc.nextLine().trim();
            }

            String result = getMaxVowelString(words);
            System.out.println("String with the most vowels: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Invalid number input.");
        } finally {
            sc.close();
        }
    }
}
