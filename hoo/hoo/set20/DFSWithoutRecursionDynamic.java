import java.util.*; 
public class DFSWithoutRecursionDynamic { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter the number of nodes in the graph:"); 
        int nodes = scanner.nextInt(); 
        Map<Integer, List<Integer>> graph = new HashMap<>(); 
        System.out.println("Enter the edges in the graph (as pairs of nodes):"); 
        System.out.println("Type '-1 -1' to stop entering edges."); 
        while (true) { 
            int from = scanner.nextInt(); 
            int to = scanner.nextInt(); 
            if (from == -1 && to == -1) break; 
            graph.putIfAbsent(from, new ArrayList<>()); 
            graph.get(from).add(to); 
            graph.putIfAbsent(to, new ArrayList<>()); 
            graph.get(to).add(from);  
        } 
        System.out.println("Enter the starting node for DFS:"); 
        int startNode = scanner.nextInt(); 
        System.out.println("DFS Traversal:"); 
        dfs(startNode, graph); 
    } 
    public static void dfs(int startNode, Map<Integer, List<Integer>> graph) { 
        Stack<Integer> stack = new Stack<>(); 
        Set<Integer> visited = new HashSet<>(); 
        stack.push(startNode); 
        visited.add(startNode); 
        while (!stack.isEmpty()) { 
            int currentNode = stack.pop(); 
            System.out.print(currentNode + " "); 
            List<Integer> neighbors = graph.getOrDefault(currentNode, new ArrayList<>()); 
            for (int neighbor : neighbors) { 
                if (!visited.contains(neighbor)) { 
                    stack.push(neighbor); 
                    visited.add(neighbor); 
                } 
            } 
        } 
    } 
} 