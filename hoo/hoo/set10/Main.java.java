import java.util.*;

class Node {
    int d;
    Node l, r;

    Node(int d) {
        this.d = d;
    }
}

class Main {
    static Node insert(Node r, int v) {
        if (r == null) return new Node(v);
        if (v < r.d) r.l = insert(r.l, v);
        else r.r = insert(r.r, v);
        return r;
    }

    static void mirror(Node r) {
        if (r == null) return;
        Node t = r.l;
        r.l = r.r;
        r.r = t;
        mirror(r.l);
        mirror(r.r);
    }

    static void inorder(Node r) {
        if (r == null) return;
        inorder(r.l);
        System.out.print(r.d + " ");
        inorder(r.r);
    }

    public static void main(String[] a) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Node r = null;
        for (int i = 0; i < n; i++) r = insert(r, s.nextInt());
        mirror(r);
        inorder(r);
        s.close();
    }
}