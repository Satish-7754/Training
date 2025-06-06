import java.util.*;

public class DFSUsingLinkedList {

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        // Constructor
        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];

            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        // Add edge (undirected graph; remove one line if directed)
        void addEdge(int src, int dest) {
            adjList[src].add(dest);
            adjList[dest].add(src); // Remove this line for directed graph
        }

        // DFS utility function
        void dfsUtil(int v, boolean[] visited) {
            visited[v] = true;
            System.out.print(v + " ");

            for (int neighbor : adjList[v]) {
                if (!visited[neighbor]) {
                    dfsUtil(neighbor, visited);
                }
            }
        }

        // DFS starting from a given vertex
        void dfs(int start) {
            boolean[] visited = new boolean[vertices];
            System.out.print("DFS traversal starting from vertex " + start + ": ");
            dfsUtil(start, visited);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        Graph graph = new Graph(vertices);

        System.out.println("Enter edges (format: src dest):");
        for (int i = 0; i < edges; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            graph.addEdge(src, dest);
        }

        System.out.print("Enter starting vertex for DFS: ");
        int start = scanner.nextInt();

        // Perform DFS
        graph.dfs(start);
    }
}