package graphs.topologicalSort;

import graphs.GetGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSSort {
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
        int[] inDegree = new int[adj.size()];
        for (List<Integer> list : adj) {
            for (Integer v : list) {
                inDegree[v]++;
            }
        }
        BFSSortSolution obj = new BFSSortSolution();
        obj.method(adj, inDegree);
    }
}

class BFSSortSolution{
    public void method(List<List<Integer>> adj, int[] inDegree){
        Queue<Integer> queue = new LinkedList<>();
        for(int u = 0; u < inDegree.length; u++){
            if(inDegree[u] == 0){
                queue.add(u);
            }
        }
        while (!queue.isEmpty()){
            Integer curr = queue.poll();
            System.out.println(curr);
            for(Integer v : adj.get(curr)){
                inDegree[v]--;
                if(inDegree[v] == 0){
                    queue.add(v);
                }
            }
        }
    }
}
