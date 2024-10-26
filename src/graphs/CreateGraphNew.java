package graphs;

import java.util.ArrayList;
import java.util.List;

public class CreateGraphNew {
    public List<List<Integer>> getGraph(int[][] matrix, int rows, int columns){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < columns; j++) {
                adj.get(i).add(j);
            }
        }
        return adj;
    }
}
