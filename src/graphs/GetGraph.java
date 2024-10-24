package graphs;

import java.util.ArrayList;
import java.util.List;

public class GetGraph {
    public List<List<Integer>> getGraph(int[][] adj, int vertices, int rows){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < vertices; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < rows; i++){
            int u = adj[i][0];
            int v = adj[i][1];
            graph.get(u).add(v);
        }
        return graph;
    }
}
