import java.util.Scanner;
class Fibonacci
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        if (isFibonacci(n)) 
	{
            System.out.println(n + " is a Fibonacci number.");
        }
	 else 
	{
            System.out.println(n + " is NOT a Fibonacci number.");
        }

        sc.close();
    }
    static boolean isFibonacci(int num) 
    {
        if (num==0||num==1) 
	{
            return true;         
	}
        int a=0,b=1,c=0;
        while(c<num) 
	{
            c=a+b;
            a=b;
            b=c;
        }
        return c==num; 
    }
}