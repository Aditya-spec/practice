package graphs.concepts.bipartite;

import java.util.Arrays;

public class BipartiteDFS {
    public static void main(String[] args) {
        int[][] graph = /*{{1,2,3},
                {0,2},
                {0,1,3},
                {0,2}};*/
        {{1,3},{0,2},{1,3},{0,2}};
        int v = graph.length;
        int[] colorArr = new int[v];
        Arrays.fill(colorArr, -1);
        for(int i = 0; i < v; i++){
            if(colorArr[i] == -1){
                if(!isBipartite(graph, i, colorArr, 0)){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }



    public static boolean isBipartite(int[][] graph, int u, int[] colorArr, int color) {
        colorArr[u] = color;

        for(int v : graph[u]){
            if(colorArr[v] == colorArr[u]){
                return false;
            }
            if(colorArr[v] == -1){
                int colorOfV = 1-color;
                if(!isBipartite(graph, v, colorArr, colorOfV)){
                    return false;
                }
            }
        }
        return true;
    }
}


