import java.util.*;
class Node{
    int d;Node l,r;
    Node(int d){this.d=d;}
}
class Maxbst2{
    static Node insert(Node r,int v){
        if(r==null)return new Node(v);
        if(v<r.d)r.l=insert(r.l,v);
        else r.r=insert(r.r,v);
        return r;
    }
    static int maxWidth(Node r){
        if(r==null)return 0;
        Queue<Node>q=new LinkedList<>();
        q.add(r);
        int maxw=0;
        while(!q.isEmpty()){
            int n=q.size();
            maxw=Math.max(maxw,n);
            for(int i=0;i<n;i++){
                Node cur=q.poll();
                if(cur.l!=null)q.add(cur.l);
                if(cur.r!=null)q.add(cur.r);
            }
        }
        return maxw;
    }
    public static void main(String[]a){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        Node r=null;
        for(int i=0;i<n;i++)r=insert(r,s.nextInt());
        System.out.println(maxWidth(r));
    }
}