import java.util.Scanner;
class RightPyramid 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the height of the pyramid:");
        int n=scanner.nextInt();
        for(int i=1;i<=n;i++) 
	{
            for(int j=0;j<i;j++) 
	    {
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}