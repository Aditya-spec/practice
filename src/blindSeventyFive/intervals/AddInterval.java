package blindSeventyFive.intervals;

import java.util.ArrayList;
import java.util.List;

public class AddInterval {
    public List<List<Integer>> addInterval(int[][] arr, int[] newInterval){
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while(i < arr.length && arr[i][1] < newInterval[0]){
            List<Integer> list = new ArrayList<>();
            list.add(arr[i][0]);
            list.add(arr[i][1]);
            result.add(list);
            i++;
        }
        while (i < arr.length && arr[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(arr[i][0], newInterval[0]);
            newInterval[1] = Math.max(arr[i][1], newInterval[1]);
            i++;
        }
        List<Integer> mergedInterval = new ArrayList<>();
        mergedInterval.add(newInterval[0]);
        mergedInterval.add(newInterval[1]);
        result.add(mergedInterval);

        while (i < arr.length) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[i][0]);
            list.add(arr[i][1]);
            result.add(list);
            i++;
        }
        return result;
    }

}
