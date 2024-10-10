package sorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeSort
{
    public static void main(String args[])
    {
        MergeSortImpl obj = new MergeSortImpl();
        int[] arr = {4, 1, 3, 9, 7, 13, 11};
        obj.recursiveInsertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr)); // Output the sorted array


    }
}
public class MergeSortImpl {
    public void recursiveInsertionSort(int[] arr, int length) {
        List<Integer> list = new ArrayList<>();
        mergeSort(arr, 0, arr.length-1);
    }

    private void mergeSort(int[] arr, int low, int high) {
        if(low >= high){
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private void merge(int[] arr, int low, int mid, int high) {
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while(left <= mid && right <= high ){
            if(arr[left] < arr[right]){
                list.add(arr[left]);
                left++;
            }else {
                list.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
            list.add(arr[left]);
            left++;
        }

        while(right <= high){
            list.add(arr[right]);
            right++;
        }
        for(int i= low; i <= high; i ++){
            arr[i] = list.get(i-low);
        }
    }
}
