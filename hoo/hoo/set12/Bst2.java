import java.util.*;
class Bst2{
    static long[]buildTree(long[]a,int n){
        long[]t=new long[4*n];
        build(a,0,n-1,t,1);
        return t;
    }
    static void build(long[]a,int l,int r,long[]t,int i){
        if(l==r){t[i]=a[l];return;}
        int m=l+(r-l)/2;
        build(a,l,m,t,2*i);
        build(a,m+1,r,t,2*i+1);
        t[i]=t[2*i]*t[2*i+1];
    }
    static long query(long[]t,int l,int r,int i,int s,int e){
        if(r<s||l>e)return 1;
        if(l<=s&&e<=r)return t[i];
        int m=s+(e-s)/2;
        return query(t,l,r,2*i,s,m)*query(t,l,r,2*i+1,m+1,e);
    }
    public static void main(String[]a){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        long[]arr=new long[n];
        for(int i=0;i<n;i++)arr[i]=s.nextLong();
        long[]t=buildTree(arr,n);
        for(int i=0;i<n;i++){
            long left=query(t,0,i-1,1,0,n-1);
            long right=query(t,i+1,n-1,1,0,n-1);
            System.out.print(left*right+" ");
        }
    }
}

