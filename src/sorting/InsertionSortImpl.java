package sorting;

class InsertionSort
{
    public static void main(String args[])
    {
        InsertionSortImpl obj = new InsertionSortImpl();
        int[] arr = {4, 1, 3, 9, 7};
        obj.insertionSort(arr, arr.length);

    }
}
public class InsertionSortImpl {

    void insertionSort(int arr[], int n) {
        for (int i = 0; i <= n - 1; i++) {
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){
                swap(arr, j);
                j--;
            }
        }
        for(int i = 0; i< arr.length; i++){
            System.out.println("\n" + arr[i]);
        }
    }

    private static void swap(int[] arr, int j) {
        int temp = arr[j-1];
        arr[j-1] = arr[j];
        arr[j]  = temp;
    }
}
