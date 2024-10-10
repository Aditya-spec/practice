package sorting;

//{ Driver Code Starts

class GFG
{
    public static void main(String args[])
    {
        SelectionSortImpl obj = new SelectionSortImpl();
        int[] arr = {4, 1, 3, 9, 7};
        obj.selectionSort(arr, arr.length);

    }
}

class SelectionSortImpl
{

    void selectionSort(int arr[], int n)
    {
        int min = arr[0];
        int minIndex = 0;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i+1; j <= arr.length - 1; j++){
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[minIndex] = temp;
            min = arr[i+1];
            minIndex = i + 1;

        }
        System.out.println(arr.length);
    }
}
