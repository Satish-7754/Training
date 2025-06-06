import java.util.*;
class Triangle
{
    public static void main(String[] args) 
    {        
	Scanner sc=new Scanner(System.in);
        System.out.println("Enter first side:");
        int a=sc.nextInt();        
        System.out.println("Enter second side:");
        int b=sc.nextInt(); 
	System.out.println("Enter third side:");
        int c=sc.nextInt();  
        int perimeter=a+b+c;
        double s=perimeter/2;
        double area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
        System.out.println("Perimeter of the triangle: " + perimeter);
        System.out.println("Area of the triangle: " + area);
        sc.close();
    }
}