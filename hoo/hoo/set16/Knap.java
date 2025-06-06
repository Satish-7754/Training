import java.util.*;
class Knap{
    public static void main(String[]a){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),w=s.nextInt();
        int[]wt=new int[n],val=new int[n];
        for(int i=0;i<n;i++)wt[i]=s.nextInt();
        for(int i=0;i<n;i++)val[i]=s.nextInt();
        int[][]dp=new int[n+1][w+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(wt[i-1]<=j)dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                else dp[i][j]=dp[i-1][j];
            }
        }
        System.out.println(dp[n][w]);
    }
}
