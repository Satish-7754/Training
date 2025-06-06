import java.util.*;
class Main4{
    public static void main(String[]a){
        Scanner s=new Scanner(System.in);
        int n1=s.nextInt(),n2=s.nextInt(),n3=s.nextInt();
        int[]a1=new int[n1],a2=new int[n2],a3=new int[n3];
        for(int i=0;i<n1;i++)a1[i]=s.nextInt();
        for(int i=0;i<n2;i++)a2[i]=s.nextInt();
        for(int i=0;i<n3;i++)a3[i]=s.nextInt();
        int sum1=0,sum2=0,sum3=0;
        for(int v:a1)sum1+=v;
        for(int v:a2)sum2+=v;
        for(int v:a3)sum3+=v;
        int i=0,j=0,k=0;
        while(true){
            if(sum1==sum2&&sum2==sum3){
                System.out.println(sum1);
                break;
            }
            if(sum1>=sum2&&sum1>=sum3)sum1-=a1[i++];
            else if(sum2>=sum1&&sum2>=sum3)sum2-=a2[j++];
            else sum3-=a3[k++];
            if(i>n1||j>n2||k>n3){
                System.out.println(0);
                break;
            }
        }
    }
}
