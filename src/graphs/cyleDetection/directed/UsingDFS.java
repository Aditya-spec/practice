package graphs.cyleDetection.directed;

import graphs.GetGraph;

import java.util.List;

public class UsingDFS {
    public static void main(String[] args) {
        GetGraph getGraph = new GetGraph();
        int[][] matrix = {
                {0, 1},
                {0, 2},
                {3, 4},
                {4, 5},
                {5, 3}
        };
        boolean isCycle = false;
        List<List<Integer>> adj = getGraph.getGraph(matrix, 6, 5);
        boolean[] visited = new boolean[adj.size()];
        boolean[] inRecursion = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i] && detectCycle(adj, i, visited, inRecursion)) {
                isCycle = true;
                break;
            }
        }
        if (isCycle) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static boolean detectCycle(List<List<Integer>> adj, int u, boolean[] visited, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;
        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                if (detectCycle(adj, v, visited, inRecursion)) {
                    return true;
                }
            } else if (inRecursion[v]) {
                return true; // Cycle detected
            }
        }
        inRecursion[u] = false;
        return false;
    }
}
