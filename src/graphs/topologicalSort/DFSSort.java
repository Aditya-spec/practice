package graphs.topologicalSort;

import graphs.GetGraph;

import java.util.List;
import java.util.Stack;

public class DFSSort {
    public static void main(String[] args) {
        GetGraph getGraph = new GetGraph();
        int[][] matrix = {
                {0, 3},
                {0, 2},
                {3, 1},
                {2, 3},
                {2, 1},
                {1, 4},
                {5, 1},
                {5, 4}
        };
        List<List<Integer>> adj = getGraph.getGraph(matrix, 6, 8);
        Stack<Integer> stack = new Stack<>();
        TopologicalSortDFS obj = new TopologicalSortDFS();
        boolean[] visited = new boolean[adj.size()];
        for(int i = 0; i<adj.size();i++){
            if(!visited[i]){
                obj.getTopologicalSort(adj, i, visited, stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}

class TopologicalSortDFS{

    public void getTopologicalSort(List<List<Integer>> adj, int u, boolean[] visited, Stack<Integer> stack){
        visited[u] = true;
        for(Integer v : adj.get(u)){
            if(!visited[v]){
                getTopologicalSort(adj, v, visited, stack);
            }
        }
        stack.push(u);
    }

}