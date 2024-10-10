package sorting;

class RecursiveInsertionSort
{
    public static void main(String args[])
    {
        RecursiveInsertionSortImpl obj = new RecursiveInsertionSortImpl();
        int[] arr = {4, 1, 3, 9, 7};
        obj.recursiveInsertionSort(arr, arr.length);

    }
}
public class RecursiveInsertionSortImpl {

    void recursiveInsertionSort(int arr[], int n) {
        for (int i = 0; i <= n - 1; i++) {
            int j = i;
            recursiveMethod(arr, j);
        }
        for(int i = 0; i< arr.length; i++){
            System.out.println("\n" + arr[i]);
        }
    }

    private void recursiveMethod(int[] arr, int j){
        if(j == 0){
            return;
        }
        if(arr[j - 1] > arr[j]){
            swap(arr, j);
        }
        j--;
    }

    private static void swap(int[] arr, int j) {
        int temp = arr[j-1];
        arr[j-1] = arr[j];
        arr[j]  = temp;
    }
}

