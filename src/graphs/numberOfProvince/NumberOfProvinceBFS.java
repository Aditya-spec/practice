package graphs.numberOfProvince;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinceBFS {
    public static void main(String[] args) {
        int[][] matrix = {
                /*{1,1,0},
                {1,1,0},
                {0,0,1}*/

                {1,0,0},
                {0,1,0},
                {0,0,1}

        };
        NumberOfProvinceBFSSolution obj = new NumberOfProvinceBFSSolution();
        obj.method(matrix);
    }

}

class NumberOfProvinceBFSSolution{
    public void method(int[][] matrix){
        int provinceCount = 0;
        boolean[] visited = new boolean[matrix.length];
        for(int i = 0; i < matrix.length;i++){
            if(!visited[i]){
                provinceCount++;
                bfs(matrix, i, visited);
            }
        }
        System.out.println(provinceCount);
    }

    void bfs(int[][] matrix, int u, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        visited[u] = true;
        queue.add(u);
        while (!queue.isEmpty()){
            Integer curr = queue.poll();
                visited[curr] = true;
                for(int col = 0; col < matrix.length; col++){
                    if(!visited[col] && matrix[u][col] ==1){
                        queue.add(col);
                    }
                }
        }

    }
}
