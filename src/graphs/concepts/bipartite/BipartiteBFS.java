package graphs.concepts.bipartite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteBFS {
    public static void main(String[] args) {
        int[][] graph = /*{{1,2,3},
                {0,2},
                {0,1,3},
                {0,2}};*/
                {{1,3},{0,2},{1,3},{0,2}};
        int length = graph.length;
        int[] colorArr = new int[length];
        Arrays.fill(colorArr, -1);
        boolean isBipartite = true;
        for(int u = 0; u < length; u++){
            if(colorArr[u] == -1){
                if(!isBipartite(graph, u, colorArr, 0)){
                    isBipartite = false;
                    break;
                }
            }
        }
        System.out.println(isBipartite);
    }

    public static boolean isBipartite(int[][] graph, int u, int[] colorArr, int color){
        Queue<Integer> queue = new LinkedList<>();
        colorArr[u] = color;
        queue.add(u);
        while (!queue.isEmpty()){
            Integer curr = queue.poll();
            for (int v : graph[curr]){
                if(colorArr[curr] == colorArr[v]){
                    return false;
                }
                if(colorArr[v] == -1){
                    colorArr[v] = 1 - colorArr[curr];
                    queue.add(v);
                }
            }
        }
        return true;
    }
}
