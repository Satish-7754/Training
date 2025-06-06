import java.util.*;
class Node{
    int d;Node l,r;
    Node(int d){this.d=d;}
}
class Dynamic2{
    static Node insert(Node r,int v){
        if(r==null)return new Node(v);
        if(v<r.d)r.l=insert(r.l,v);
        else r.r=insert(r.r,v);
        return r;
    }
    static Node removeHalf(Node r){
        if(r==null)return null;
        r.l=removeHalf(r.l);
        r.r=removeHalf(r.r);
        if(r.l==null&&r.r!=null)return r.r;
        if(r.r==null&&r.l!=null)return r.l;
        return r;
    }
    static void inorder(Node r){
        if(r==null)return;
        inorder(r.l);
        System.out.print(r.d+" ");
        inorder(r.r);
    }
    public static void main(String[]a){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        Node r=null;
        for(int i=0;i<n;i++)r=insert(r,s.nextInt());
        r=removeHalf(r);
        inorder(r);
    }
}