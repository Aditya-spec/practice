package graphs.concepts.cyleDetection.undirected;

import java.util.ArrayList;
import java.util.List;

public class UsingDFS {
    public static void main(String[] args) {
        Representation representation = new Representation();
        List<List<Integer>> adj = representation.getGraph();
        UsingDfsSolution obj = new UsingDfsSolution();
        boolean isCyclic = obj.method(adj);
        System.out.println(isCyclic);

    }
}

class UsingDfsSolution {
    public boolean method(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i] && checkDfsCycle(adj, 0, visited, -1)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDfsCycle(List<List<Integer>> adj, int u, boolean[] visited, int parent) {
        visited[u] = true;
        for (Integer v : adj.get(u)) {
            if (v == parent) continue;
            if (visited[v]) {
                return true;
            }
                if (checkDfsCycle(adj, v, visited, u)) {
                    return true;
                }
            }
        return false;
    }
}



class Representation {
    public List<List<Integer>> getGraph() {
        int vertices = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
        addData(adj, 0, 2);
        addData(adj, 0, 1);
        addData(adj, 1, 3);
        addData(adj, 2, 4);
        //addData(adj, 4, 1);//uncomment this line to make graph cyclic
        return adj;
    }

    private void addData(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        /**
         * For undirected:
         * adj.get(v).add(u);
         */
    }
}