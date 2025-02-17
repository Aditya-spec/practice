package blindSeventyFive.binarySearch;

public class FindPeak {
    public int findPeak(int[] arr, int n){
        if(n == 1){
            return arr[0];
        }
        if(arr[0] > arr[1]){
            return arr[0];
        }if(arr[n-1] > arr[n-2]){
            return arr[n-1];
        }
        int l = 1;
        int h = n-2;
        while(l <= h){
            int m = (l + h)/2;
            if((arr[m] > arr[m-1]) && (arr[m] > arr[m+1])){
                return arr[m];
            }if(arr[m] > arr[m-1]){
                l = m + 1;
            }else{
                h = m-1;
            }
        }
        return  -1;
    }
}
