package matrix;

public class PrintSpiral {
    public void printSpiral(int[][] matrix) {
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        while (top <= bottom && left <= right) {
            for (int i = top; i <= right; i++) {
                System.out.println(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.println(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.println(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.println(matrix[left][i]);
                }
                left++;
            }
        }
        return void;
    }

}
