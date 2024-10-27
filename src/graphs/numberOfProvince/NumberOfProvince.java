package graphs.numberOfProvince;

/**
 * It is a simple dfs traversal in which while calling dfs we are checking if the node is visited or not
 *
 * if not, we are increasing province count and calling dfs
 */

public class NumberOfProvince {
    public static void main(String[] args) {
        int[][] matrix = {
                /*{1,1,0},
                {1,1,0},
                {0,0,1}*/

                {1,0,0},
                {0,1,0},
                {0,0,1}

        };
        NumberOfProvinceSolutionDFS obj = new NumberOfProvinceSolutionDFS();
        obj.method(matrix);

    }

}

class NumberOfProvinceSolutionDFS {
    public void method(int[][] matrix){

        int n = matrix.length;
        int provinceCount = 0;
        boolean[] visited = new boolean[matrix.length];

        for(int v = 0; v < n; v++){
            if(!visited[v] ){
                getDfs(matrix, v, visited);
                provinceCount++;
            }
        }
        System.out.println(provinceCount);
    }

    private void getDfs(int[][] adj, int u, boolean[] visited) {
        visited[u] = true;
        for(int col = 0; col < adj.length ; col++){
            if(!visited[col] && adj[u][col] ==1){
                getDfs(adj, col, visited);
            }
        }
    }
}