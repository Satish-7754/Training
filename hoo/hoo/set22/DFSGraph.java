import java.util.*;

public class DFSGraph {

    // Function to perform DFS traversal
    public static void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        // Mark the node as visited and print it
        visited[node] = true;
        System.out.print(node + " ");

        // Recur for all the adjacent vertices
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of nodes and edges
        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();
        System.out.print("Enter number of edges: ");
        int m = scanner.nextInt();

        // Create an adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Input edges
        System.out.println("Enter " + m + " edges (u, v) where there is an edge from u to v:");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u).add(v);  // Add v to the adjacency list of u
            adj.get(v).add(u);  // As the graph is undirected, add u to the adjacency list of v
        }

        // Input the starting node for DFS
        System.out.print("Enter the starting node for DFS: ");
        int startNode = scanner.nextInt();

        // Array to track visited nodes
        boolean[] visited = new boolean[n];

        // Perform DFS
        System.out.println("DFS traversal starting from node " + startNode + ":");
        dfs(startNode, visited, adj);
        System.out.println();
    }
}