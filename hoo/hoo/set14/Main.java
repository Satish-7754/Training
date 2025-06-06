import java.util.*;
class Node{
    int d;Node l,r;
    Node(int d){this.d=d;}
}
class Main{
    static Node insert(Node r,int v){
        if(r==null)return new Node(v);
        if(v<r.d)r.l=insert(r.l,v);
        else r.r=insert(r.r,v);
        return r;
    }
    static int height(Node r){
        if(r==null)return 0;
        return 1+Math.max(height(r.l),height(r.r));
    }
    public static void main(String[]a){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        Node r=null;
        for(int i=0;i<n;i++)r=insert(r,s.nextInt());
        System.out.println(height(r));
    }
}