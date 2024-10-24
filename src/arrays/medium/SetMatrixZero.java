package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZero {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();
        SetMatrixZeroSolution obj = new SetMatrixZeroSolution();
        obj.method(matrix, n, m);

    }
}

class SetMatrixZeroSolution{
    public void method(List<List<Integer>> matrix, int row, int col){
        int colZero = -1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col;j++){
                if(matrix.get(i).get(j) == 0){
                    matrix.get(i).set(0,0);
                    if(j !=0 ){
                        matrix.get(0).set(j, 0);
                    }else{
                        colZero = 0;
                    }
                }
            }
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix.get(i).get(j) !=0){
                    if(matrix.get(i).get(0) == 0 || matrix.get(0).get(j) ==0){
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }

        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < col; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (colZero == 0) {
            for (int i = 0; i < row; i++) {
                matrix.get(i).set(0, 0);
            }
        }
        System.out.println("The Final matrix is: ");
        for (List<Integer> data : matrix) {
            for (Integer ele : data) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

    }
}