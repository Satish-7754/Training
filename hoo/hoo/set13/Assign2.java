
import java.util.*;
class Assign2{
    public static void main(String[]a){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),m=s.nextInt();
        int[]g=new int[n],c=new int[m];
        for(int i=0;i<n;i++)g[i]=s.nextInt();
        for(int i=0;i<m;i++)c[i]=s.nextInt();
        Arrays.sort(g);
        Arrays.sort(c);
        int i=0,j=0,res=0;
        while(i<n&&j<m){
            if(c[j]>=g[i]){
                res++;
                i++;
                j++;
            }else j++;
        }
        System.out.println(res);
    }
}

