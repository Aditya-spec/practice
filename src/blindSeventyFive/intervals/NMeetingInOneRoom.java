package blindSeventyFive.intervals;

import java.util.Arrays;
import java.util.Comparator;

//similar to find minimum number of overlapping intervals
public class NMeetingInOneRoom {
    public int findMaxMeetings(int[][] arr){
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
    });
        int count = 1;
        int endTime = arr[0][1];
        for (int i = 1; i < arr.length; i++){
            if(arr[i][0] >= endTime){
                count +=1;
                endTime = arr[i][1];
            }
        }
    return count;
}

}
