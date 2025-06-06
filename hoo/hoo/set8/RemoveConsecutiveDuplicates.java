import java.util.Scanner; 
public class RemoveConsecutiveDuplicates { 
    public static String removeConsecutiveDuplicates(String str) { 
        if (str.length() == 0) return ""; 
        StringBuilder result = new StringBuilder(); 
        result.append(str.charAt(0));   
        for (int i = 1; i < str.length(); i++) { 
            if (str.charAt(i) != str.charAt(i - 1)) { 
                result.append(str.charAt(i)); 
            } 
        } 
        return result.toString(); 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter a string: "); 
        String input = sc.nextLine(); 
        String output = removeConsecutiveDuplicates(input); 
        System.out.println("After removing consecutive duplicates: " + output); 
    } 
} 
