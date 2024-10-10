package sorting;


class BubbleSort
{
    public static void main(String args[])
    {
        BubbleSortImpl obj = new BubbleSortImpl();
        int[] arr = {4, 1, 3, 9, 7};
        obj.bubbleSort(arr, arr.length);

    }
}
class BubbleSortImpl
{

    void bubbleSort(int arr[], int n) {
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(arr, j);
                }
            }
        }
        System.out.println(arr.length);
    }

    private static void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j +1];
        arr[j + 1]  =temp;
    }

}


