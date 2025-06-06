import java.util.*;
class Mehod2rope{
    public static void main(String[]a){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        PriorityQueue<Integer>q=new PriorityQueue<>();
        for(int i=0;i<n;i++)q.add(s.nextInt());
        int cost=0;
        while(q.size()>1){
            int x=q.poll()+q.poll();
            cost+=x;
            q.add(x);
        }
        System.out.println(cost);
    }
}
