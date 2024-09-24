import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/** Undirected Adjcency List Graph Impl
 * 
 * Beecrownd 3171
 * link -> https://judge.beecrowd.com/en/problems/view/3171
 * 
 * @author Thomas Neuenschwander
 * @since 23/09/2024
*/
public class StringLed {
    static boolean isConnected(Map<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        dfs(1, graph, visited);
        
        for (boolean v : visited) 
            if (!v) return false;
        
        return true;
    }

    static void dfs(int v, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[v] = true;
        for (int w : graph.get(v)) {
            if (!visited[w - 1]) {
                visited[w - 1] = true;
                dfs(w, graph, visited);
            }
        }
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numVertices = sc.nextInt(); 
            int numEdges = sc.nextInt();

            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int i = 1; i <= numVertices; i++)
                graph.put(i, new LinkedList<>());

            for (int i = 0; i < numEdges; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();

                if (v1 < 1 || v1 > numVertices || v2 < 1 || v2 > numVertices)
                    throw new IllegalArgumentException("Vertex out of bounds");

                addUndirectedEdge(graph, v1, v2);
            }
            String output = isConnected(graph) ? "COMPLETO" : "INCOMPLETO";
            System.out.println(output);
        }
    }

    static void addUndirectedEdge(Map<Integer, List<Integer>> graph, int v, int w) {
        graph.get(v).add(w);
        graph.get(w).add(v);
    }
}