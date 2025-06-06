import java.util.Scanner;

public class ReverseOnlyLetters {

    // Function to reverse only the letters in the string
    public static String reverseOnlyLetters(String input) {
        char[] characters = input.toCharArray();
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            // Skip non-letter characters on the left
            if (!Character.isLetter(characters[left])) {
                left++;
            }
            // Skip non-letter characters on the right
            else if (!Character.isLetter(characters[right])) {
                right--;
            }
            // Swap letters
            else {
                char temp = characters[left];
                characters[left] = characters[right];
                characters[right] = temp;
                left++;
                right--;
            }
        }

        return new String(characters);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your string (e.g., ab-cd): ");
        String input = scanner.nextLine();

        String result = reverseOnlyLetters(input);
        System.out.println("Output: " + result);

        scanner.close();
    }
}
