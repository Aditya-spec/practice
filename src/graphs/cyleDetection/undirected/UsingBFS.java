package graphs.cyleDetection.undirected;

import graphs.GetGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UsingBFS {
    public static void main(String[] args) {
        getGraph();
    }

    private static void getGraph() {
        int[][] matrix = {
                {0,1},
                {0,2},
                {3,4},
                {4,5},
                {3,5}
        };
        GetGraph getGraph = new GetGraph();
        List<List<Integer>> adj = getGraph.getGraph(matrix, 6, 5);
        boolean[] visited = new boolean[adj.size()];
        for(int i = 0; i < adj.size(); i++){
            if(!visited[i]){
                Node node = new Node(i, -1);
                UsingBFSSolution usingBFSSolution = new UsingBFSSolution();
                boolean cycle = usingBFSSolution.detectCycle(adj, i, visited, node);
                if(cycle){
                    System.out.println("true");
                    break;
                }
            }
        }
        System.out.println("false");

    }
}

class UsingBFSSolution{
    public boolean detectCycle(List<List<Integer>> adj, int u, boolean[] visited, Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[node.val] = true;
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            int val = curr.val;
            int parent = curr.parent;
            for(Integer i : adj.get(val)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(new Node(i, val));
                }else if(i != parent){
                    return true;
                }
            }
        }
        return false;
    }

}

class Node{
    int val;
    int parent;
    public Node(int v, int p){
        this.val = v;
        this.parent = p;
    }
}

class BFS{

}

