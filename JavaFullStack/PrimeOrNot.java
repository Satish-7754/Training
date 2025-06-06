import java.util.Scanner;
class PrimeOrNot
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        if (isPrime(n)) 
        {
            System.out.println(n + " is a Prime number.");
        } 
	else 
	{
            System.out.println(n + " is NOT a Prime number.");
        }
        sc.close();
    }
    static boolean isPrime(int num) 
     {
     if (num<2) 
     {
            return false;
      }
      for (int i=2;i*i<=num;i++) 
       {
            if (num%i==0) 
	    {
                return false;
            }
        }
        return true;
    }
}