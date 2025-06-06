import java.util.Scanner;

class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else { // bill is 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of bills:");
        int n = scanner.nextInt();
        int[] bills = new int[n];
        System.out.println("Enter the bills:");
        for (int i = 0; i < n; i++) {
            bills[i] = scanner.nextInt();
        }
        System.out.println("Can provide change: " + lemonadeChange(bills));
        scanner.close();
    }
}