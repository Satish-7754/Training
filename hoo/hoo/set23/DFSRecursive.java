import java.util.*;

public class DFSRecursive {
    
    // Graph represented as an adjacency list
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    
    // To keep track of visited nodes
    static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: number of nodes and edges
        System.out.print("Enter number of nodes: ");
        int nodes = scanner.nextInt();
        
        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        // Initialize the adjacency list
        for (int i = 0; i < nodes; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Input: edges
        System.out.println("Enter edges (format: from to):");
        for (int i = 0; i < edges; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            
            // Undirected graph: add both directions
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        // Input: starting node for DFS
        System.out.print("Enter starting node for DFS: ");
        int startNode = scanner.nextInt();

        System.out.println("DFS traversal starting from node " + startNode + ":");
        dfs(startNode);

        scanner.close();
    }

    // Recursive DFS method
    static void dfs(int node) {
        if (visited.contains(node)) return;

        // Visit the node
        visited.add(node);
        System.out.print(node + " ");

        // Visit all unvisited neighbors
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            }
        }
    }
}
