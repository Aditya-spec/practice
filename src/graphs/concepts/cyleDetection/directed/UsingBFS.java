package graphs.concepts.cyleDetection.directed;

import graphs.concepts.GetGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * We use kahn's algorithm logic here to find topological sort, we can find topological sort only for Directed Acyclic Graph
 *
 * if we are able to find topological sort, i.e we are able to visit every node means that this is not cyclic,
 * so we take a variable count and increase it's value everytime we add item in a queue
 * if in the end of topological sort, count != number of vertices, there is a cycle there
 */
public class UsingBFS {
    public static void main(String[] args) {
        GetGraph getGraph = new GetGraph();
        int[][] matrix = {
                {0, 1},
                {0, 2},
                {3, 4},
                {4, 5},
                {5, 3}
        };
        List<List<Integer>> adj = getGraph.getGraph(matrix, 6, 5);
        UsingBFSSolution obj = new UsingBFSSolution();
        int[] inDegree = new int[adj.size()];
        for (List<Integer> u : adj){
            for(Integer v : u){
                inDegree[v]++;
            }
        }
        obj.method(adj,inDegree );
    }
}

class UsingBFSSolution{
    public void method(List<List<Integer>> adj, int[] inDegree){
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0 ; i < adj.size();i++){
            count ++;
            queue.add(i);
        }
        while (!queue.isEmpty()){
            Integer curr = queue.poll();
            for (Integer v : adj.get(curr)){
                inDegree[v]--;
                if(inDegree[v] == 0){
                    count++;
                    queue.add(v);
                }
            }
        }
        if(count == adj.size()){
            System.out.println("not cyclic");
        }else {
            System.out.println("cyclic");
        }
    }
}
