import java.util.*;
class Node{
    int d;Node l,r;
    Node(int d){this.d=d;}
}
class Binary2{
    static Node insert(Node r,int v){
        if(r==null)return new Node(v);
        if(v<r.d)r.l=insert(r.l,v);
        else r.r=insert(r.r,v);
        return r;
    }
    static int widthAtLevel(Node r,int lev){
        if(r==null)return 0;
        Queue<Node>q=new LinkedList<>();
        q.add(r);
        int l=0;
        while(!q.isEmpty()){
            int n=q.size();
            l++;
            if(l==lev)return n;
            for(int i=0;i<n;i++){
                Node cur=q.poll();
                if(cur.l!=null)q.add(cur.l);
                if(cur.r!=null)q.add(cur.r);
            }
        }
        return 0;
    }
    public static void main(String[]a){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        Node r=null;
        for(int i=0;i<n;i++)r=insert(r,s.nextInt());
        int lev=s.nextInt();
        System.out.println(widthAtLevel(r,lev));
    }
}