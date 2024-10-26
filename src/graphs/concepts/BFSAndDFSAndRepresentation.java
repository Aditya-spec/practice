package graphs.concepts;

import java.util.*;

public class BFSAndDFSAndRepresentation {
    public static void main(String[] args) {
        List<List<Integer>> adj = getGraphRepresentation();
        dfs(adj);
        bfs(adj);
    }

    private static List<List<Integer>> getGraphRepresentation() {
        Representation representation = new Representation();
        List<List<Integer>> adj = representation.getGraph();
        printGraphRepresentation(adj);
        return adj;
    }

    private static void printGraphRepresentation(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++){
            System.out.println("For " + i + "::");
            for(int j = 0; j< adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j) + "  ");
            }
            System.out.println();
        }
    }

    private static void dfs(List<List<Integer>> adj) {
        DFS dfs = new DFS();
        boolean[] visitedDFs = new boolean[adj.size()];
        List<Integer> resultDFS = new ArrayList<>();
        dfs.dfs(adj, 0, visitedDFs,resultDFS);
        System.out.println("DFS");
        for(Integer i : resultDFS){
            System.out.println(i);
        }
    }

    private static void bfs(List<List<Integer>> adj) {
        BFS bfs = new BFS();
        boolean[] visitedBFs = new boolean[adj.size()];
        Arrays.fill(visitedBFs, false);
        List<Integer> resultBFS = new ArrayList<>();
        System.out.println("BFS");
        bfs.bfs(adj, 0, visitedBFs, resultBFS);
        for(Integer i : resultBFS){
            System.out.println(i);
        }
    }
}

class DFS{
    public void dfs(List<List<Integer>> adj, int u, boolean[] visited, List<Integer> result){
        if(visited[u]){
            return;
        }
        result.add(u);
        visited[u] = true;
        for(Integer i : adj.get(u)){
            dfs(adj, i, visited, result);
        }
    }
}

class BFS{
    public  void bfs(List<List<Integer>> adj, int u, boolean[] visited, List<Integer> result){
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        while(!q.isEmpty()){
            Integer curr = q.poll();
            result.add(curr);
            visited[curr] = true;
            for(Integer i : adj.get(curr)){
                if(!visited[i]){
                    q.add(i);
                }
            }
        }
    }
}
class Representation{
    public List<List<Integer>> getGraph(){
        int vertices = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < vertices; i++){
            adj.add(new ArrayList<>());
        }
        addData(adj,0,2);
        addData(adj,0,1);
        addData(adj,1,3);
        addData(adj,2,4);
        addData(adj,4,1);
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