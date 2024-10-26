package arrays.medium;

/**
DNF algorithm is used here::
0 to low-1 : 0
low to mid -1 : 1
mid to high : unsorted
high + 1 to length : 2
 */

public class SortArrayOfZeroOneAndTwo {
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,2,1,0,0,1,1,2,2};
        SortArrayOfZeroOneAndTwoSolution obj = new SortArrayOfZeroOneAndTwoSolution();
        obj.method(arr);
    }
}

class SortArrayOfZeroOneAndTwoSolution{
    public void method(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while(low <= mid && mid <= high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                mid ++;
                low++;
            } else if (arr[mid] == 1) {
                mid ++;
            }else {
                swap(arr, mid, high);
                high--;
            }
        }
        for (int j : arr) {
            System.out.println(j);
        }
    }

    private void swap(int[] arr, int low, int mid) {
        int temp = arr[low];
        arr[low] = arr[mid];
        arr[mid] = temp;
    }
}
