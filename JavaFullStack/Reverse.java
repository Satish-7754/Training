import java.util.*;
class Reverse
{
    public static void main(String[] args) 
    {        
	Scanner sc=new Scanner(System.in);
        System.out.println("Enter String:");
    	String str=sc.next();        
        String reversed = "";
        for (int i=str.length()-1;i>=0;i--) 
	{
            reversed += str.charAt(i);
        }
        System.out.println("Reversed String: "+reversed);
        sc.close();
    }
}


