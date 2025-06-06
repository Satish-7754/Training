import java.util.*;
class Swap 
{
    public static void main(String[] args) 
    {        
	Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number:");
        int a = sc.nextInt();        
        System.out.println("Enter second number:");
        int b = sc.nextInt();                
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping:");
        System.out.println("First number: " + a);
        System.out.println("Second number: " + b); 
        sc.close();
    }
}
