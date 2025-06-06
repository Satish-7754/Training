import java.util.Arrays;
import java.util.Scanner;

public class AssignCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the greed factors of the children (comma-separated):");
        String greedInput = scanner.nextLine();
        String[] greedStr = greedInput.split(",");
        int[] greed = new int[greedStr.length];
        for (int i = 0; i < greedStr.length; i++) {
            greed[i] = Integer.parseInt(greedStr[i].trim());
        }

        System.out.println("Enter the sizes of the cookies (comma-separated):");
        String cookiesInput = scanner.nextLine();
        String[] cookiesStr = cookiesInput.split(",");
        int[] cookies = new int[cookiesStr.length];
        for (int i = 0; i < cookiesStr.length; i++) {
            cookies[i] = Integer.parseInt(cookiesStr[i].trim());
        }

        System.out.println("Number of children satisfied: " + findContentChildren(greed, cookies));
        scanner.close();
    }

    public static int findContentChildren(int[] greed, int[] cookies) {
        Arrays.sort(greed);
        Arrays.sort(cookies);
        int childIndex = 0;
        int cookieIndex = 0;
        int satisfiedChildren = 0;
        while (childIndex < greed.length && cookieIndex < cookies.length) {
            if (cookies[cookieIndex] >= greed[childIndex]) {
                satisfiedChildren++;
                childIndex++;
            }
            cookieIndex++;
        }
        return satisfiedChildren;
    }
}